package services.servImpl;

import entity.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repos.DAOAuthorHelper;
import services.AuthorService;

import java.util.List;
import java.util.Random;

public class AuthorServiceImpl implements AuthorService {

    private final DAOAuthorHelper daoAuthorHelperImpl;

    private static final Logger LOGGER = LogManager.getLogger();

    public AuthorServiceImpl(DAOAuthorHelper daoAuthorHelperImpl) {
        this.daoAuthorHelperImpl = daoAuthorHelperImpl;
    }

    @Override
    public Author add(Author author) {
        return daoAuthorHelperImpl.add(author);
    }

    @Override
    public List<Author> getAll() {
        return daoAuthorHelperImpl.getAll();
    }

    @Override
    public Author getById(long id) {
        return daoAuthorHelperImpl.getById(id);
    }

    @Override
    public Author updateNameById(long id, String newName) {
        return daoAuthorHelperImpl.updateNameById(id, newName);
    }

    @Override
    public Author remove(Author author) {
        return daoAuthorHelperImpl.remove(author);
    }

    @Override
    public Author removeById(long id) {
        return daoAuthorHelperImpl.removeById(id);
    }

    @Override
    public void add15EntityAuthorsByRnd() {
        LOGGER.info("начал работу метод add100EntityByRnd()");
        String[] newName = {"Анна", "София", "Виктория", "Дарья", "Анастасия", "Артем", "Александр",
                "Максим", "Дмитрий", "Матвей"};
        String[] newLastName = {"Мельник", "Шевченко", "Коваленко", "Бондаренко", "Бойко", "Ткаченко", "Кравченко",
                "Ковальчук", "Коваль", "Олийник"};
        Random rnd = new Random();
        int countEntity = 0;
        do {
            countEntity++;
            Author author = new Author();
            author.setName(newName[rnd.nextInt(10)]);
            author.setLastName(newLastName[rnd.nextInt(10)]);
            author.setSalary(Math.max(rnd.nextInt(15000), 6500));
            daoAuthorHelperImpl.add(author);
        } while (countEntity != 15);
        LOGGER.info("закончил работу метод add100EntityByRnd(), счетчик= " + countEntity);

    }
}
