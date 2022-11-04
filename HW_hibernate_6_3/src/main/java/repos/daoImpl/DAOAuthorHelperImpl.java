package repos.daoImpl;

import entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import repos.DAOAuthorHelper;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DAOAuthorHelperImpl implements DAOAuthorHelper {
    private static SessionFactory sessionFactory;

    public DAOAuthorHelperImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Author add(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        cq.from(Author.class);
        Query<Author> query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;
    }

    @Override
    public Author getById(long id) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);
        session.close();
        return author;
    }

    @Override
    public Author updateNameById(long id, String newName) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);
        author.setName(newName);
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }

    @Override
    public Author remove(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }

    @Override
    public Author removeById(long id) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);
        session.beginTransaction();
        session.delete(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }
}
