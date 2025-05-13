package tests.beckend;

import org.testng.annotations.Test;
import backend.services.BookstoreService;
import shareData.Hooks;

public class ObtainAllBooksTest extends Hooks {

    @Test
    public void testMethod(){
        BookstoreService bookStoreService = new BookstoreService();
        bookStoreService.getAllBooks();
    }
}
