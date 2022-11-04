import entity.Author;
import entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repos.DAOFactory;
import repos.daoImpl.DAOFactoryImpl;
import services.AuthorService;
import services.BookService;
import services.servImpl.AuthorServiceImpl;
import services.servImpl.BookServiceImpl;

import java.util.List;

/**
 * Домашнее задание 6
 * Задание 3
 * В класс BookHelper пакета ex_004_relations дописать методы удаления книги по id и по автору.
 **/

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        DAOFactory factory = DAOFactoryImpl.getInstance();
        AuthorService authorService = new AuthorServiceImpl(factory.getDaoAuthorHelperImpl());
        BookService bookService = new BookServiceImpl(factory.getDaoBookHelperImpl());

        authorService.add15EntityAuthorsByRnd();
        bookService.add20EntityBooksByRnd();

        Book book = bookService.removeById(17);
        LOGGER.info("Delete book ById: " + book.getId() + " " + book.getName() + ", автор: " + book.getAuthor().getLastName() + " " + book.getAuthor().getName());

        Author author = authorService.getById(10);
        int resultDelete = bookService.deleteWithCriteriaAllBookByAuthor(author);
        LOGGER.info("Delete All book by Author result: " + resultDelete + " " + author.getLastName() + " " + author.getName());

//        List<Author> list = authorService.getAll();
//        for (Author a : list) {
//            LOGGER.info(a.getName() + " " + a.getLastName() + " " + a.getSalary());
//        }
//
//
//        List<Book> bookList = bookService.getAll();
//        for (Book books : bookList) {
//            LOGGER.info(books.getId() + " " + books.getName());
//        }

    }
}
