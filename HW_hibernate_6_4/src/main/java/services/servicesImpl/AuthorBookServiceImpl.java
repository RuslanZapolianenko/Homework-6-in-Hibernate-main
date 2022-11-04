package services.servicesImpl;
import entity.AuthorBookDto;
import repos.reposImpl.AuthorBookRepositoryImpl;
import repos.reposImpl.AuthorRepositoryImpl;
import repos.reposImpl.BookRepositoryImpl;
import services.AuthorBookService;

import java.util.List;

public class AuthorBookServiceImpl implements AuthorBookService {

    private final AuthorBookRepositoryImpl authorBookRepository;
    private final AuthorRepositoryImpl authorRepository;
    private final BookRepositoryImpl bookRepository;

    public AuthorBookServiceImpl(AuthorBookRepositoryImpl authorBookRepository, AuthorRepositoryImpl authorRepository, BookRepositoryImpl bookRepository) {
        this.authorBookRepository = authorBookRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void addAuthorToBook(long authorId, long bookId) {
//        if (!authorRepository.isAuthorExist(authorId) || !bookRepository.isBookExist(bookId)) {
//            throw new RuntimeException("the author or the book doesn't exist!");
//        }
        authorBookRepository.addAuthorToBook(authorId, bookId);
    }

    @Override
    public List<AuthorBookDto> getAuthorBookDtoByAuthorId(long id) {
        return authorBookRepository.getAuthorBookDtoByAuthorId(id);
    }

    @Override
    public List<AuthorBookDto> getAuthorBookDtoByBookId(long id) {
        return authorBookRepository.getAuthorBookDtoByBookId(id);
    }
}
