package services.servImpl;

import entity.Author;
import entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repos.DAOBookHelper;
import repos.daoImpl.DAOFactoryImpl;
import services.BookService;

import java.util.List;
import java.util.Random;

public class BookServiceImpl implements BookService {
    private DAOBookHelper daoBookHelperImpl;

    private static final Logger LOGGER = LogManager.getLogger();

    public BookServiceImpl(DAOBookHelper daoBookHelperImpl) {
        this.daoBookHelperImpl = daoBookHelperImpl;
    }


    public Book add(Book book) {
        return daoBookHelperImpl.add(book);
    }


    public List<Book> getAll() {
        return daoBookHelperImpl.getAll();
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
            book.setAuthor(DAOFactoryImpl.getInstance().getDaoAuthorHelperImpl().getById(Math.max(rnd.nextInt(15), 1)));
            daoBookHelperImpl.add(book);
        } while (countEntity != 20);
        LOGGER.info("закончил работу метод add20EntityBookRnd(), счетчик= " + countEntity);
    }

    @Override
    public Book getById(long id) {
        return daoBookHelperImpl.getById(id);
    }

    @Override
    public Book updateNameById(long id, String newName) {
        return daoBookHelperImpl.updateNameById(id, newName);
    }

    @Override
    public Book remove(Book book) {
        return daoBookHelperImpl.remove(book);
    }

    @Override
    public Book removeById(long id) {
        return daoBookHelperImpl.removeById(id);
    }

    @Override
    public int deleteWithCriteriaAllBookByAuthor(Author author) {
        return daoBookHelperImpl.deleteWithCriteriaAllBookByAuthor(author);
    }

}
