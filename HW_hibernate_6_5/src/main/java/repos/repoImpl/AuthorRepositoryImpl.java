package repos.repoImpl;
import entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import repos.AuthorRepository;
import utils.HibernateUtil;

import javax.persistence.criteria.*;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {
    private static SessionFactory sessionFactory;

    public AuthorRepositoryImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

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
    public List<Author> findAuthorByLikeLastName(String likeLastName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);
        String prepareLikeLastName = '%' + likeLastName + '%';
        cq.where(cb.like(root.get("lastName"), prepareLikeLastName));
        Query<Author> query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;
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

    @Override
    public int deleteCriteria(String likeLastName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Author> cd = cb.createCriteriaDelete(Author.class);
        Root<Author> root = cd.from(Author.class);
        String prepareLikeLastName = '%' + likeLastName + '%';
        cd.where(cb.like(root.get("lastName"), prepareLikeLastName));
        javax.persistence.Query query = session.createQuery(cd);
        int resultDelete = query.executeUpdate();
        session.getTransaction().commit();
        if (!session.getTransaction().getStatus().name().equalsIgnoreCase("COMMITTED")) {
            resultDelete = 0;
        }
        session.close();
        return resultDelete;
    }

    public int deleteCriteriaLogic(String likeLastName, String likeName, String lastName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Author> cd = cb.createCriteriaDelete(Author.class);
        Root<Author> root = cd.from(Author.class);
        String prepareLikeLastName = '%' + likeLastName + '%';
        String prepareLikeName = '%' + likeName + '%';
        cd.where(cb.or(
                cb.and(
                cb.like(root.get("name"), prepareLikeName),
                cb.like(root.get("lastName"), prepareLikeLastName)
        ),
                cb.equal(root.get("name"), lastName)
                ));
        Query query = session.createQuery(cd);
        int resultDelete = query.executeUpdate();
        session.getTransaction().commit();
        if (!session.getTransaction().getStatus().name().equalsIgnoreCase("COMMITTED")) {
            resultDelete = 0;
        }
        session.close();
        return resultDelete;
    }
}
