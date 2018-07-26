import br.com.sifat.dao.BookDao;
import br.com.sifat.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBookDao {

    @Test
    private void testSave() {

        Book book = new Book();
        BookDao bookDao = new BookDao();

        bookDao.criar(book);

        Assertions.assertNotEquals(0, book.getId());
    }
}
