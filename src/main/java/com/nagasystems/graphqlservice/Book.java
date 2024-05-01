package com.nagasystems.graphqlservice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Book {
    private String id;
    private String name;
    private int pagecount;
    private String authorId;

    public Book(String id, String name, int pagecount, String authorId) {
        this.id = id;
        this.name = name;
        this.pagecount = pagecount;
        this.authorId = authorId;
    }

    private static final List<Book> books = Arrays.asList(
            new Book("book-1", "Effective Java", 416, "author-1"),
            new Book("book-2", "Hitchhiker's Guide to the Galaxy", 209, "author-2"),
            new Book("book-3", "Down Under", 436, "author-3")
    );

    public static Book getById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getPagecount() == book.getPagecount() && Objects.equals(getId(), book.getId()) && Objects.equals(getName(), book.getName()) && Objects.equals(getAuthorId(), book.getAuthorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPagecount(), getAuthorId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pagecount=" + pagecount +
                ", authorId='" + authorId + '\'' +
                '}';
    }
}
