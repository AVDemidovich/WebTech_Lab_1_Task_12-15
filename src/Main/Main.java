package Main;

import Books.Book;
import Books.Book.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException{
        Book[] p = new Book[3];
        p[0] = new Book("Milk","Name",756,1);
        p[1] = new Book("Small","Surname",123,2);
        p[2] = new Book("Bread","Mayakovki",200,3);

        Arrays.sort(p, new SortedByTitle());
        for(Book i : p){
            System.out.println(i.toString());
        }
    }
}
