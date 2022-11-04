package repos.reposImpl;

import repos.AuthorRepository;
import repos.BookRepository;
import repos.FactoryRepository;

public class FactoryRepositoryImpl implements FactoryRepository {
    private static FactoryRepository factory;


    public static synchronized FactoryRepository getInstance(){
        factory = new FactoryRepositoryImpl();
        return factory;
    }

    @Override
    public AuthorRepository getAuthorRepositoryImpl() {
        return new AuthorRepositoryImpl();
    }

    @Override
    public BookRepository getBookRepositoryIml() {
        return new BookRepositoryImpl();
    }
}
