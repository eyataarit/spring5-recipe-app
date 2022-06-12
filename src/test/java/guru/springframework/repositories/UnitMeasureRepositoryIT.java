package guru.springframework.repositories;

import guru.springframework.model.UnitMeasure;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
//Datajpa test will bring embedded database and configure spring data jpa
public class UnitMeasureRepositoryIT extends TestCase {

    //dependency injection
    @Autowired
    UnitMeasureRepository unitMeasureRepository;


    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void findByDescription() throws Exception {

        Optional<UnitMeasure> uomOptional = unitMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() throws Exception {

        Optional<UnitMeasure> uomOptional = unitMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", uomOptional.get().getDescription());
    }
}