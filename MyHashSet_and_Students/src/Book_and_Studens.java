import java.util.*;

class Book {
    private String title;
    private int year;
    private int pages;

    public Book (String title, int year, int pages) {
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public int getPages() { return pages; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Book book = (Book) o;
        return year == book.year && pages == book.pages && Objects.equals(title, book.title);
    }

    @Override
    public String toString() {
        return title + " (" + year + ") " + "стр.";
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, pages);
    }
}

class Student {
    private String name;
    private List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public List<Book> getBooks() { return books; }

    @Override
    public String toString() {
        return "Студент: " + name + ", книги: " + books;
    }
}
