package repos;

import entity.Author;
import entity.Book;

import java.util.List;

public interface BookRepository {
    Book add (Book book);

    List<Book> getAll();

    Book getById(long id);

    Book updateNameById(long id, String newName);

    Book remove(Book book);

    Book removeById(long id);

    int deleteWithCriteriaAllBookByAuthor(Author author);

    List<Book> getAllAuthorsBooks(Integer id);
}
