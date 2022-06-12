package guru.springframework.model;

import junit.framework.TestCase;
import org.junit.Before;

public class CategoryTest extends TestCase {

    Category category;
    @Before
    public void setUp(){
        category = new Category();
    }
    public void testGetId() {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    public void testGetRecipies() {
    }

    public void testGetDescription() {
    }
}