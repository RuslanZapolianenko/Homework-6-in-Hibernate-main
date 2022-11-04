package services;

import entity.Author;

import java.util.List;

public interface AuthorService {
    Author add(Author author);

    @SuppressWarnings("unchecked")
    List<Author> getAll();

    Author getById(long id);

    Author updateNameById(long id, String newName);

    Author remove(Author author);

    Author removeById(long id);

    void add15EntityAuthorsByRnd();
}
