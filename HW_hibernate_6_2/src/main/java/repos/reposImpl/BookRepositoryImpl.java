package repos.reposImpl;

import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repos.BookRepository;
import utils.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private static SessionFactory sessionFactory;

    public BookRepositoryImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Book add(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")

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


}
