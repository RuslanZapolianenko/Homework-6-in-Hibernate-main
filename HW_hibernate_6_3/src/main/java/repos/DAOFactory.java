package repos;

public interface DAOFactory {

    DAOAuthorHelper getDaoAuthorHelperImpl();

    DAOBookHelper getDaoBookHelperImpl();


}
