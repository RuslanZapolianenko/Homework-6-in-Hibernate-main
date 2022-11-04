package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Authors_Books")
public class AuthorBookDto implements Serializable {
    @Id
    @Column(name = "author_id")
    private long authorId;
    @Id
    @Column(name = "book_id")
    private long bookId;

    public AuthorBookDto(Long authorId, Long bookId) {
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public AuthorBookDto() {

    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "AuthorBookDto{" +
                "authorId=" + authorId +
                ", bookId=" + bookId +
                '}';
    }
}
