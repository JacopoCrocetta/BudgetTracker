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

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.LavanderiaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.LavanderiaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LavanderiaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    LavanderiaService lavanderiaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        LavanderiaEntity entityToDelete = new LavanderiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LavanderiaEntity entitySaved = lavanderiaService.save(entityToDelete);
        assertNotNull(lavanderiaService.findById(entitySaved.getId()).get());
        assertTrue(lavanderiaService.count() != 0);

        lavanderiaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        LavanderiaEntity entityToSave = new LavanderiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(lavanderiaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(lavanderiaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        LavanderiaEntity entityToSave = new LavanderiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(lavanderiaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(lavanderiaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        LavanderiaEntity entityToSave = new LavanderiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(lavanderiaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(lavanderiaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        LavanderiaEntity entityToSave = new LavanderiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(lavanderiaService.save(entityToSave) != null);

        assertTrue(lavanderiaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        LavanderiaEntity entityToSave = new LavanderiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(lavanderiaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        LavanderiaEntity entityToDelete = new LavanderiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LavanderiaEntity entitySaved = lavanderiaService.save(entityToDelete);
        assertNotNull(lavanderiaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        lavanderiaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            lavanderiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        LavanderiaEntity entityToDelete = new LavanderiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LavanderiaEntity entitySaved = lavanderiaService.save(entityToDelete);
        assertNotNull(lavanderiaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        lavanderiaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            lavanderiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<LavanderiaEntity> aList = StreamSupport
                .stream(lavanderiaService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        LavanderiaEntity entityToDelete = new LavanderiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LavanderiaEntity entitySaved = lavanderiaService.save(entityToDelete);
        assertNotNull(lavanderiaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<LavanderiaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        lavanderiaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            lavanderiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(lavanderiaService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(lavanderiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            lavanderiaService.deleteAll(lavanderiaService.findAll());

            assertTrue(StreamSupport.stream(lavanderiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        LavanderiaEntity entityToDelete = new LavanderiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LavanderiaEntity entitySaved = lavanderiaService.save(entityToDelete);
        assertNotNull(lavanderiaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        lavanderiaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            lavanderiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(lavanderiaService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(lavanderiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            lavanderiaService.deleteAll(lavanderiaService.findAll());
            assertTrue(StreamSupport.stream(lavanderiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
