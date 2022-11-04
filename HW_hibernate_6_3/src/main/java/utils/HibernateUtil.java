package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final Logger LOGGER = LogManager.getLogger();
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e){
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
