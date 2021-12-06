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

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.EmergenzeEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice.EmergenzeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmergenzeServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    EmergenzeService emergenzeService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        EmergenzeEntity entityToDelete = new EmergenzeEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        EmergenzeEntity entitySaved = emergenzeService.save(entityToDelete);
        assertNotNull(emergenzeService.findById(entitySaved.getId()).get());
        assertTrue(emergenzeService.count() != 0);

        emergenzeService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        EmergenzeEntity entityToSave = new EmergenzeEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(emergenzeService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(emergenzeService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        EmergenzeEntity entityToSave = new EmergenzeEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(emergenzeService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(emergenzeService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        EmergenzeEntity entityToSave = new EmergenzeEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(emergenzeService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(emergenzeService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        EmergenzeEntity entityToSave = new EmergenzeEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(emergenzeService.save(entityToSave) != null);

        assertTrue(emergenzeService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        EmergenzeEntity entityToSave = new EmergenzeEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(emergenzeService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        EmergenzeEntity entityToDelete = new EmergenzeEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        EmergenzeEntity entitySaved = emergenzeService.save(entityToDelete);
        assertNotNull(emergenzeService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        emergenzeService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emergenzeService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        EmergenzeEntity entityToDelete = new EmergenzeEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        EmergenzeEntity entitySaved = emergenzeService.save(entityToDelete);
        assertNotNull(emergenzeService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        emergenzeService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emergenzeService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<EmergenzeEntity> aList = StreamSupport
                .stream(emergenzeService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        EmergenzeEntity entityToDelete = new EmergenzeEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        EmergenzeEntity entitySaved = emergenzeService.save(entityToDelete);
        assertNotNull(emergenzeService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<EmergenzeEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        emergenzeService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emergenzeService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(emergenzeService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(emergenzeService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            emergenzeService.deleteAll(emergenzeService.findAll());

            assertTrue(StreamSupport.stream(emergenzeService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        EmergenzeEntity entityToDelete = new EmergenzeEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        EmergenzeEntity entitySaved = emergenzeService.save(entityToDelete);
        assertNotNull(emergenzeService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        emergenzeService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emergenzeService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(emergenzeService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(emergenzeService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            emergenzeService.deleteAll(emergenzeService.findAll());
            assertTrue(StreamSupport.stream(emergenzeService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
