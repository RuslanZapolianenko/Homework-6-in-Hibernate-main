import entity.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repos.repoImpl.AuthorRepositoryImpl;
import repos.repoImpl.BookRepositoryImpl;

import services.AuthorService;
import services.BookService;
import services.servImpl.AuthorServiceImpl;
import services.servImpl.BookServiceImpl;

import java.util.List;

/**
 * Домашнее задание 6
 * Задание 5
 * Из пакета ex_002_select_where написать отдельный метод для выборки по поиску выражения
 * и в пакете ex_003_delete методы createCriteria и createCriteriaLogic переписать правильно.
 **/

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        AuthorService authorService = new AuthorServiceImpl(new AuthorRepositoryImpl());
        BookService bookService = new BookServiceImpl(new BookRepositoryImpl());

        authorService.add15EntityAuthorsByRnd();
        bookService.add20EntityBooksByRnd();

        List<Author> authorList = authorService.findAuthorByLikeLastName("Ковал");

        for (Author author : authorList) {
            LOGGER.info("result find: id=" + author.getId() + " " + author.getLastName() + " " + author.getName());
        }

        int resultDelete = authorService.deleteCriteria("Коваль");
        LOGGER.info("Delete Authors by deleteCriteria result: " + resultDelete);

        int resultDelete2 = authorService.deleteCriteriaLogic("Ткач", "Алекс", "Анастасия");
        LOGGER.info("Delete Authors by deleteCriteriaLogic result: " + resultDelete2);


    }
}
