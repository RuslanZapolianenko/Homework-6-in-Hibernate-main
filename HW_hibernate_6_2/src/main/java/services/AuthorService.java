package services;

import entity.Author;

import java.util.List;

public interface AuthorService {
    Author add(Author author);

    @SuppressWarnings("unchecked")
    List<Author> getAll();

    Author getById(long id);

    List<Author> findAuthorByLikeLastName(String likeLastName);

    Author updateNameById(long id, String newName);

    List<Author> updateLastNameByLenghtGreaterSeven();

    Author remove(Author author);

    Author removeById(long id);

    int deleteCriteria(String likeLastName);

   int deleteCriteriaLogic(String likeLastName, String likeName, String lastName);

    void add15EntityAuthorsByRnd();
}

