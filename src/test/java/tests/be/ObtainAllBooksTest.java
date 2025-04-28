package tests.be;

import org.testng.annotations.Test;
import services.BookstoreService;

public class ObtainAllBooksTest {

    @Test
    public void testMethod(){
        BookstoreService bookStoreService = new BookstoreService();
        bookStoreService.getAllBooks();
    }
}
