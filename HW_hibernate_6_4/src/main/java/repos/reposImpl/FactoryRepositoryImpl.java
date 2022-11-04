package repos.reposImpl;

import repos.AuthorBookRepository;
import repos.AuthorRepository;
import repos.BookRepository;
import repos.FactoryRepository;

public class FactoryRepositoryImpl implements FactoryRepository {

    private static FactoryRepositoryImpl factory;

    public static synchronized FactoryRepositoryImpl getInstance() {
        factory = new FactoryRepositoryImpl();
        return factory;
    }

    @Override
    public AuthorRepository getAuthorRepositoryImpl() {
        return new AuthorRepositoryImpl();
    }

    @Override
    public BookRepository getBookRepositoryImpl() {
        return new BookRepositoryImpl();
    }

    @Override
    public AuthorBookRepository getAuthorBookRepositoryImpl() {
        return new AuthorBookRepositoryImpl();
    }
}
