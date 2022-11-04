import entity.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repos.reposImpl.AuthorRepositoryImpl;
import repos.reposImpl.BookRepositoryImpl;
import services.AuthorService;
import services.BookService;
import services.servicesImpl.AuthorServiceImpl;
import services.servicesImpl.BookServiceImpl;

import java.util.List;

/**
 * Домашнее задание 6
 * Задание 2
 * Обновить поле name для всех записей, у которых длина значения поля last_name больше 7
 * В поле name записать значение «1»
 * * Задание на самостоятельный поиск решений.
 **/
public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        AuthorService authorService = new AuthorServiceImpl(new AuthorRepositoryImpl());
        BookService bookService = new BookServiceImpl(new BookRepositoryImpl());

        authorService.add15EntityAuthorsByRnd();
        bookService.add20EntityBooksByRnd();

        authorService.updateLastNameByLenghtGreaterSeven();

        List<Author> authorList = authorService.getAll();
        for (Author author : authorList) {
            LOGGER.info("id=" + author.getId() + ", lastName=" + author.getLastName() + ", name=" + author.getName());
        }

    }
}
