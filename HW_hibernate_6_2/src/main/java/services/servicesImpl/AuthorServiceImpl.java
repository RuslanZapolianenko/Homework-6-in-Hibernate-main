package services.servicesImpl;
import entity.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repos.reposImpl.AuthorRepositoryImpl;
import services.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepositoryImpl authorRepositoryImpl;

    private static final Logger LOGGER = LogManager.getLogger();


    public AuthorServiceImpl(AuthorRepositoryImpl authorRepositoryImpl) {
        this.authorRepositoryImpl = authorRepositoryImpl;
    }

@Override
    public Author add(Author author) {
        return authorRepositoryImpl.add(author);
    }
    @Override
    public List<Author> getAll() {
        return authorRepositoryImpl.getAll();
    }

    @Override
    public Author getById(long id) {
        return authorRepositoryImpl.getById(id);
    }

    @Override
    public List<Author> findAuthorByLikeLastName(String likeLastName) {
        return authorRepositoryImpl.findAuthorByLikeLastName(likeLastName);
    }

    @Override
    public Author updateNameById(long id, String newName) {
        return authorRepositoryImpl.updateNameById(id, newName);
    }

    @Override
    public List<Author> updateLastNameByLenghtGreaterSeven() {
        List<Author> authorList = authorRepositoryImpl.getAll();
        List<Author> authorListUpdateName = new ArrayList<>();
        for (Author author : authorList) {
            if (author.getLastName().length() > 7) {
                authorListUpdateName.add(authorRepositoryImpl.updateNameById(author.getId(), "1"));
            }
        }
        return authorListUpdateName;
    }

    @Override
    public Author remove(Author author) {
        return authorRepositoryImpl.remove(author);
    }

    @Override
    public Author removeById(long id) {
        return authorRepositoryImpl.removeById(id);
    }

    public int deleteCriteria(String likeLastName) {
        return authorRepositoryImpl.deleteCriteria(likeLastName);
    }

    @Override
    public int deleteCriteriaLogic(String likeLastName, String likeName, String lastName) {
        return authorRepositoryImpl.deleteCriteriaLogic(likeLastName, likeName, lastName);
    }

    @Override
    public void add15EntityAuthorsByRnd() {
        LOGGER.info("начал работу метод add15EntityAuthorsByRnd()");
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
            authorRepositoryImpl.add(author);
        } while (countEntity != 15);
        LOGGER.info("закончил работу метод add15EntityAuthorsByRnd(), счетчик= " + countEntity);

    }
}

