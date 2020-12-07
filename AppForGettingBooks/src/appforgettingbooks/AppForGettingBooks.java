/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appforgettingbooks;

import com.classes.Book;
import com.dataaccess.RepositoryLibrary;
import java.util.List;

/**
 *
 * @author valentina
 */
public class AppForGettingBooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Book> books = RepositoryLibrary.getAllBooks();
        for( Book book : books){
            System.out.println("Title "+book.getTitle());
            System.out.println("Author "+book.getAuthorFirstName()+" "+book.getAuthorLastName());
            System.out.println("Rating "+book.getRating());
            System.out.println();
        }
    }
    
}
