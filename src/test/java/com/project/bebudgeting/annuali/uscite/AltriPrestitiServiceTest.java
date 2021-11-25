package com.project.bebudgeting.annuali.uscite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.AltriPrestitiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.AltriPrestitiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltriPrestitiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltriPrestitiService altriPrestitiService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltriPrestitiEntity entityToDelete = new AltriPrestitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltriPrestitiEntity entitySaved = altriPrestitiService.save(entityToDelete);
        assertNotNull(altriPrestitiService.findById(entitySaved.getId()).get());
        assertTrue(altriPrestitiService.count() != 0);

        altriPrestitiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltriPrestitiEntity entityToSave = new AltriPrestitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altriPrestitiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altriPrestitiService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltriPrestitiEntity entityToSave = new AltriPrestitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altriPrestitiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altriPrestitiService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltriPrestitiEntity entityToSave = new AltriPrestitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altriPrestitiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altriPrestitiService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltriPrestitiEntity entityToSave = new AltriPrestitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altriPrestitiService.save(entityToSave) != null);

        assertTrue(altriPrestitiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltriPrestitiEntity entityToSave = new AltriPrestitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altriPrestitiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltriPrestitiEntity entityToDelete = new AltriPrestitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltriPrestitiEntity entitySaved = altriPrestitiService.save(entityToDelete);
        assertNotNull(altriPrestitiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altriPrestitiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altriPrestitiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltriPrestitiEntity entityToDelete = new AltriPrestitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltriPrestitiEntity entitySaved = altriPrestitiService.save(entityToDelete);
        assertNotNull(altriPrestitiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altriPrestitiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altriPrestitiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltriPrestitiEntity> aList = StreamSupport.stream(altriPrestitiService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltriPrestitiEntity entityToDelete = new AltriPrestitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltriPrestitiEntity entitySaved = altriPrestitiService.save(entityToDelete);
        assertNotNull(altriPrestitiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltriPrestitiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altriPrestitiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altriPrestitiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altriPrestitiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altriPrestitiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altriPrestitiService.deleteAll(altriPrestitiService.findAll());

            assertTrue(StreamSupport.stream(altriPrestitiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltriPrestitiEntity entityToDelete = new AltriPrestitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltriPrestitiEntity entitySaved = altriPrestitiService.save(entityToDelete);
        assertNotNull(altriPrestitiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altriPrestitiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altriPrestitiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altriPrestitiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altriPrestitiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altriPrestitiService.deleteAll(altriPrestitiService.findAll());
            assertTrue(StreamSupport.stream(altriPrestitiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
