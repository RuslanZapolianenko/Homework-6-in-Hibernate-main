package repos.reposImpl;
import entity.AuthorBookDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import java.util.List;
import java.util.logging.Logger;


public class AuthorBookRepositoryImpl implements repos.AuthorBookRepository {

    private final SessionFactory sessionFactory;

    public AuthorBookRepositoryImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    private final Logger log = Logger.getLogger(String.valueOf(AuthorBookRepositoryImpl.class));

    @Override
    @SuppressWarnings("unchecked")
    public void addAuthorToBook(long authorId, long bookId) {
        AuthorBookDto authorBookDto = new AuthorBookDto(authorId, bookId);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(authorBookDto);
        session.getTransaction().commit();
        session.close();
    }

@Override
    public List<AuthorBookDto> getAuthorBookDtoByAuthorId(long id) {
        Session session = sessionFactory.openSession();
        Query<AuthorBookDto> query = session.createQuery("select ab from AuthorBookDto ab where ab.authorId = :id");
        query.setParameter("id", id);
        List<AuthorBookDto> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<AuthorBookDto> getAuthorBookDtoByBookId(long id) {
        Session session = sessionFactory.openSession();
        Query<AuthorBookDto> query = session.createQuery("select ab from AuthorBookDto ab where ab.bookId = :id");
        query.setParameter("id", id);
        List<AuthorBookDto> list = query.list();
        session.close();
        return list;
    }


}
