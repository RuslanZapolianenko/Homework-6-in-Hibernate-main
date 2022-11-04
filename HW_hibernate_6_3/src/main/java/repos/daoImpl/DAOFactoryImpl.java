package repos.daoImpl;

import repos.DAOAuthorHelper;
import repos.DAOBookHelper;
import repos.DAOFactory;

public class DAOFactoryImpl implements DAOFactory {

    private static DAOFactory factory;

    public static synchronized DAOFactory getInstance() {
        factory = new DAOFactoryImpl();
        return factory;
    }

    @Override
    public DAOAuthorHelper getDaoAuthorHelperImpl() {
        return new DAOAuthorHelperImpl();
    }

    @Override
    public DAOBookHelper getDaoBookHelperImpl() {
        return new DAOBookHelperImpl();
    }
}
