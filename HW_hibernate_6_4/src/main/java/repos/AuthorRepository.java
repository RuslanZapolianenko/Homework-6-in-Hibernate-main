package repos;

import entity.Author;

import java.util.List;

public interface AuthorRepository {
    Author add(Author author);

    List<Author> getAll();

    Author getById(long id);

    Author updateNameById(long id, String newName);

    Author remove(Author author);

    Author removeById(long id);


}
