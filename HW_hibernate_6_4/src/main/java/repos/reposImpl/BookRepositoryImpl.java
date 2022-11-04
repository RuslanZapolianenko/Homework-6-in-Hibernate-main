package repos.reposImpl;

import entity.Author;
import entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import repos.BookRepository;
import utils.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private static SessionFactory sessionFactory;

    private static final Logger LOGGER = LogManager.getLogger();

    public BookRepositoryImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }


    @Override
    public Book add(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        cq.from(Book.class);
        Query query = session.createQuery(cq);
        List<Book> bookList = query.getResultList();
        session.close();
        return bookList;
    }

    public List<Book> getAllAuthorsBooks(Integer id) {
        Session session = sessionFactory.openSession();
        NativeQuery<Book> nativeQuery = session.createNativeQuery("SELECT * FROM Book b INNER JOIN Books_Authors ba ON b.id = ba.book_id WHERE ba.author_id = ?1");
        nativeQuery.setParameter(1, id);
        nativeQuery.addEntity(Book.class);
        List<Book> list = nativeQuery.list();
        session.close();
        return list;
    }

    @Override
    public Book getById(long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    @Override
    public Book updateNameById(long id, String newName) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        book.setName(newName);
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    @Override
    public Book remove(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    @Override
    public Book removeById(long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    @Override
    public int deleteWithCriteriaAllBookByAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Book> cd = cb.createCriteriaDelete(Book.class);
        Root<Book> root = cd.from(Book.class);
        cd.where(cb.equal(root.get("author"), author));
        Query query = session.createQuery(cd);
        int resultDelete = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return resultDelete;
    }

    public Boolean isBookExist(Long id) {
        Session session = sessionFactory.openSession();
        //Book book = session.get(Book.class, id);
        org.hibernate.query.Query<Book> query = session.createQuery("select b from Book b where id = :id");
        query.setParameter("id", id);
        boolean isExist = query.uniqueResult() != null;
        session.close();
        LOGGER.info("User with id"+id+" exist: "+isExist);
        return isExist;
    }


}
