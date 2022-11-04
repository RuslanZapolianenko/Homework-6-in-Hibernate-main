package repos;

import entity.Author;
import entity.Book;

import java.util.List;

public interface DAOBookHelper {
    Book add (Book book);

    List<Book> getAll();

    Book getById(long id);

    Book updateNameById(long id, String newName);

    Book remove(Book book);

    Book removeById(long id);

    int deleteWithCriteriaAllBookByAuthor(Author author);
}
