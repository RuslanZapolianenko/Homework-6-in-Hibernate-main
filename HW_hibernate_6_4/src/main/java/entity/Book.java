package entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(name =  "Authors_Books",
                    joinColumns = {@JoinColumn (name = "author_id")},
            inverseJoinColumns = {@JoinColumn (name = "book_id")})
    List<Author> authors;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                '}';
    }
}

