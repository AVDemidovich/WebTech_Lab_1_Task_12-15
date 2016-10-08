package Books;

/**
 * Created by Alexander_Demidovich on 10/8/2016.
 */

import java.util.Comparator;

public class Book implements Cloneable,Comparable{
    private String title;
    private String author;
    private int price;
    private int isbn;
    private static int edition;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Book() {

    }
    public Book(String title, String author, int price, int isbn)  {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getEdition() {
        return edition;
    }

    public static void setEdition(int edition) {
        Book.edition = edition;
    }

    public int compare(Book obj1, Book obj2) {

        String str1 = obj1.getTitle();
        String str2 = obj2.getTitle();

        return str1.compareTo(str2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()){
            return false;
        }
        Book book = (Book) obj;

        if ( this.getPrice() != book.getPrice()) return false;
        if (this.getTitle() != null){
            if (! (this.getTitle().equals(book.getTitle())) )
                return false;
        }
        else
        if ( book.getTitle() != null ) return false;
        return this.getAuthor() != null ? this.getAuthor().equals(book.getAuthor()) : book.getAuthor() == null;
    }
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 0;
        result = PRIME * result + this.getPrice();
        if (this.getAuthor() != null)
            result +=this.getAuthor().hashCode();
        if(this.getTitle() != null)
            result +=this.getTitle().hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Class:Book, Parent:Object, " + "title = '" + title
                + '\''+ ", author = '" + author + '\'' +  ", isbn = '" + isbn + '\'' +", price=" + price;
    }
    @Override
    public Book clone() throws CloneNotSupportedException {
        Book cloneObj=(Book)super.clone();
        return cloneObj;
    }

    @Override
    public int compareTo(Object obj) {
        Book entry = (Book) obj;
        int result = this.getIsbn() - entry.isbn;
        if(result != 0) {
            return (int) result / Math.abs( result );
        }
        return 0;
    }
    public static class SortedByTitle implements Comparator<Book> {
        @Override
        public int compare(Book obj1, Book obj2) {

            String str1 = obj1.getTitle();
            String str2 = obj2.getTitle();

            return str1.compareTo(str2);
        }
    }
    public static class SortedByTitleAndAuthor implements Comparator<Book> {
        @Override
        public int compare(Book obj1, Book obj2) {

            String str1 = obj1.getTitle();
            String str2 = obj2.getTitle();

            if ( str1.compareTo(str2) !=0 ) return str1.compareTo(str2);
            str1 = obj1.getAuthor();
            str2 = obj2.getAuthor();

            return str1.compareTo(str2);
        }
    }
    public static class SortedByAuthorAndTitle implements Comparator<Book> {
        @Override
        public int compare(Book obj1, Book obj2) {

            String str1 = obj1.getAuthor();
            String str2 = obj2.getAuthor();

            if ( str1.compareTo(str2) !=0 ) return str1.compareTo(str2);
            str1 = obj1.getTitle();
            str2 = obj2.getTitle();

            return str1.compareTo(str2);
        }
    }
    public static class SortedByAuthorAndTitleAndPrice implements Comparator<Book> {
        @Override
        public int compare(Book obj1, Book obj2) {

            String str1 = obj1.getAuthor();
            String str2 = obj2.getAuthor();

            if ( str1.compareTo(str2) !=0 ) return str1.compareTo(str2);
            str1 = obj1.getTitle();
            str2 = obj2.getTitle();
            if ( str1.compareTo(str2) !=0 ) return str1.compareTo(str2);

            if(obj1.getPrice() > obj2.getPrice()) {
                return 1;
            }
            else if(obj1.getPrice() < obj2.getPrice()) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}
