/**
 * Created by Alexander_Demidovich on 10/8/2016.
 */

import Books.Book;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class JUnitTests_CompareTests {
    TreeSet<Book> ex = new TreeSet<Book>();
    @Before
    public void setUp() throws Exception {
        ex.add(new Book("Stive Global","lol",1, 121));
        ex.add(new Book("Stive Global","lol",2, 88786));
        ex.add(new Book("Nancy Summer","lol",3, 1213));
        ex.add(new Book("Aaron Eagle","lol",4, 3123));
        ex.add(new Book("Barbara Smith","lol",5, 221));
    }
    @After
    public void tearDown() throws Exception{
        ex.clear();
    }
    @Test
    public void CheckBooksSort_121_121Returned() {
        int expected = 121;
        Book actual = ex.first();
        assertEquals(expected,actual.getIsbn());
    }
    @Test
    public void CheckBooksSort_88786_88786Returned() {
        int expected = 88786;
        Book actual = ex.last();
        assertEquals(expected,actual.getIsbn());
    }
    @Test
    public void CheckBooksSort_0_0Returned() {
        ex.add(new Book("Barbara Smith","lol",5, 0));
        int expected = 0;
        Book actual = ex.first();
        assertEquals(expected,actual.getIsbn());
    }
}
