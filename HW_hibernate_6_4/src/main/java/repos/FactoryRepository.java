package repos;

public interface FactoryRepository {

    AuthorRepository getAuthorRepositoryImpl();

    BookRepository getBookRepositoryImpl();

    AuthorBookRepository getAuthorBookRepositoryImpl();


}
