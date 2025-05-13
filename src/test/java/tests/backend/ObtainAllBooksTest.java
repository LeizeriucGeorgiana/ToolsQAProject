package tests.backend;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import backend.services.BookstoreService;
import shareData.Hooks;
@Feature("FE-123")
@Story("ST-322")

public class ObtainAllBooksTest extends Hooks {

    @Test
    public void testMethod(){
        BookstoreService bookStoreService = new BookstoreService();
        bookStoreService.getAllBooks();
    }
}
