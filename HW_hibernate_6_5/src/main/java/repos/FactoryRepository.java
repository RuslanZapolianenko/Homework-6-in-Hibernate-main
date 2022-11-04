package repos;

public interface FactoryRepository {


    AuthorRepository getAuthorRepositoryImpl();

    BookRepository getBookRepositoryIml();


}
