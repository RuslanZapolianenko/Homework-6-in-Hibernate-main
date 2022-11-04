package services.servicesImpl;

import entity.Author;
import entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repos.BookRepository;

import repos.reposImpl.FactoryRepositoryImpl;
import services.BookService;

import java.util.List;
import java.util.Random;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepositoryImpl;

    private static final Logger LOGGER = LogManager.getLogger();

    public BookServiceImpl(BookRepository bookRepositoryImpl) {
        this.bookRepositoryImpl = bookRepositoryImpl;
    }


    public Book add(Book book) {
        return bookRepositoryImpl.add(book);
    }


    public List<Book> getAll() {
        return bookRepositoryImpl.getAll();
    }


    public void add20EntityBooksByRnd() {
        LOGGER.info("начал работу метод add20EntityBookRnd()");
        String[] newName = {"Убить пересмешника", "Гордость и предубеждение", "Дневник Анны Франк",
                "1984", "Гарри Поттер и философский камень", "Властелин колец", "Великий Гэтсби",
                "Паутина Шарлотты", "Маленькие женщины", "Хоббит", "451° по Фаренгейту", "Джейн Эйр",
                "Унесенные ветром", "Скотный двор", "Над пропастью во ржи", "Приключения Гекльберри Финна",
                "Прислуга", "Гроздья гнева", "Лев, Колдунья и Платяной шкаф", "Голодные игры"};
        Random rnd = new Random();
        int countEntity = 0;
        do {
            countEntity++;
            Book book = new Book();
            book.setName(newName[rnd.nextInt(20)]);
            bookRepositoryImpl.add(book);
        } while (countEntity != 20);
        LOGGER.info("закончил работу метод add20EntityBookRnd(), счетчик= " + countEntity);
    }

    @Override
    public Book getById(long id) {
        return bookRepositoryImpl.getById(id);
    }

    @Override
    public Book updateNameById(long id, String newName) {
        return bookRepositoryImpl.updateNameById(id, newName);
    }

    public List<Book> getAllAuthorsBooks(Integer id){
        return bookRepositoryImpl.getAllAuthorsBooks(id);
    }

    @Override
    public Book remove(Book book) {
        return bookRepositoryImpl.remove(book);
    }

    @Override
    public Book removeById(long id) {
        return bookRepositoryImpl.removeById(id);
    }

    @Override
    public int deleteWithCriteriaAllBookByAuthor(Author author) {
        return bookRepositoryImpl.deleteWithCriteriaAllBookByAuthor(author);
    }

}
