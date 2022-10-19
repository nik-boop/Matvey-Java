package org.example;

import java.util.HashMap;
import java.util.List;

public class Manager extends Employee {
    private Book books = new Book();
    public Manager(int id, String name, String surname, String middleName, String address, int employeeId) {
        super(id, name, surname, middleName, address, employeeId);
    }

    public void createNewBook(int id, String name, String author, String edition, String publisher, int publication_year, String category) throws Exception {
        HashMap<String , String> addBook = new HashMap<>();
        addBook.put("id", Integer.toString(id));
        addBook.put("name", name);
        addBook.put("author", author);
        addBook.put("edition", edition);
        addBook.put("publisher", publisher);
        addBook.put("publication_year", Integer.toString(publication_year));
        addBook.put("category", category);
        books.addNewBook(addBook);
    }

    public void deleteBook(int id) {
        // Менеджер удаляет книгу
    }

    public int findBooksByCategory(String category) {
        // Менеджер ищет кол-во книг по категории
        int result = books.getIndexesFromValue("category", category).size();
        System.out.println("Кол-во книг по теме: " + category + " - " + result + "шт.");
        return result;
    }

    public int findBooksByName(String name){
        // Менеджер ищет кол-во книг по имени
        return books.getIndexesFromValue("name", name).size();
    }

    public int findBooksByAuthor(String author) {
        // Менеджер ищет кол-во книг по автору
        return books.getIndexesFromValue("author", author).size();
    }

    public int findBooksByAttribute(String column, String attribute) {
        // Менеджер ищет кол-во книг по атрибуту
        return books.getIndexesFromValue(column, attribute).size();
    }

    public void findBooksByReader(List<Reader> all_readers) {
        // Менеджер ищет книги, которые брал конкретный читатель
        for (Reader reader: all_readers) {
            System.out.println(reader.name + " " + reader.surname + " " + reader.bookIds);
        }

    }

    public void findBooksDistribution(List<Reader> all_readers, Book books) throws Exception {
        // Менеджер определяет сколько книг было взято читателями
        // и сколько еще находится в библиотеке
        int reader_books = 0;
        for (Reader reader: all_readers) {
            reader_books += reader.bookAmount;
            //System.out.println(reader.bookIds);
        }
        System.out.println("Кол-во книг у читателей: " + reader_books);
        System.out.println("Кол-во книг в библиотеке: " + books.getIdBooks().size());
    }
}