package repos.daoImpl;

import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repos.DAOBookHelper;
import utils.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.persistence.criteria.Root;
import java.util.List;

public class DAOBookHelperImpl implements DAOBookHelper {

    private static SessionFactory sessionFactory;

    public DAOBookHelperImpl() {
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


}
