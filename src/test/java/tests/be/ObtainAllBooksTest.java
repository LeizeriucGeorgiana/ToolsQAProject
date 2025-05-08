package tests.be;

import org.testng.annotations.Test;
import services.BookstoreService;
import shareData.SharedData;

public class ObtainAllBooksTest extends SharedData {

    @Test
    public void testMethod(){
        BookstoreService bookStoreService = new BookstoreService();
        bookStoreService.getAllBooks();
    }
}
