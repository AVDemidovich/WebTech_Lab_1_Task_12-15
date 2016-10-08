/**
 * Created by Alexander_Demidovich on 10/8/2016.
 */

import Books.Book;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class JUnitTests {
    Book[] books = new Book[6];
    @Before
    public void setUp() throws Exception {
        books[0] = new Book("Milk","Igor",756,1);
        books[1] = new Book("Small","Kozlov",923,2);
        books[2] = new Book("Bread","Mayakovki",200,3);
        books[3] = new Book("My-My","BB",300,4);
        books[4] = new Book("My-My","Alex",300,4);
        books[5] = new Book("My-My","Alex",200,5);
        Arrays.sort(books, new Book.SortedByTitle());
    }
    @Test
    public void SortByTitle_Bread_MilkReturned() {
        String expected = "Bread";
        Book actual = books[0];
        assertEquals(expected,actual.getTitle());
    }
    @Test
    public void SortByTitle_MyMy_SmallReturned() {
        String expected = "My-My";
        Arrays.sort(books, new Book.SortedByTitle());
        Book actual = books[2];
        assertEquals(expected,actual.getTitle());
    }
    @Test
    public void SortByTitleAndAuthor_Alex_AlexReturned() {
        String expected = "Alex";
        Arrays.sort(books, new Book.SortedByTitleAndAuthor());
        Book actual = books[2];
        assertEquals(expected,actual.getAuthor());
    }
    @Test
    public void SortByAuthorAndTitle_Alex_AlexReturned() {
        String expected = "Alex";
        Arrays.sort(books, new Book.SortedByAuthorAndTitle());
        Book actual = books[0];
        assertEquals(expected,actual.getAuthor());
    }
    @Test
    public void SortByAuthorAndTitleAndPrice_Alex_AlexReturned() {
        int expected = 300;
        Arrays.sort(books, new Book.SortedByAuthorAndTitle());
        Book actual = books[0];
        assertEquals(expected,actual.getPrice());
    }
}
