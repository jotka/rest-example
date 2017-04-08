package pl.finsys.example.domain;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class Book {

    @Id
    @NotNull
    @Size(max = 64)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @NotNull
    @Size(max = 64)
    @Column(name = "author", nullable = false)
    private String author;

    @NotNull
    @Size(max = 64)
    @Column(name = "title", nullable = false)
    private String title;

    Book() {
    }

    public Book(final String author, final String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("author", author)
                .add("title", title)
                .toString();
    }
}
