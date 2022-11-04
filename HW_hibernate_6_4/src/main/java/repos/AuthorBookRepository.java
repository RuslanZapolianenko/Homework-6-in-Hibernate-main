package repos;

import entity.AuthorBookDto;

import java.util.List;

public interface AuthorBookRepository {
    @SuppressWarnings("unchecked")
    void addAuthorToBook(long authorId, long bookId);

    List<AuthorBookDto> getAuthorBookDtoByAuthorId(long id);

    List<AuthorBookDto> getAuthorBookDtoByBookId(long id);
}
