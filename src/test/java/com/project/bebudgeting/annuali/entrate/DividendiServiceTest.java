package com.project.bebudgeting.annuali.entrate;

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

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.DividendiEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.DividendiService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DividendiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    DividendiService dividendiService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        DividendiEntity entityToDelete = new DividendiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DividendiEntity entitySaved = dividendiService.save(entityToDelete);
        assertNotNull(dividendiService.findById(entitySaved.getId()).get());
        assertTrue(dividendiService.count() != 0);

        dividendiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        DividendiEntity entityToSave = new DividendiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(dividendiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(dividendiService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        DividendiEntity entityToSave = new DividendiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(dividendiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(dividendiService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        DividendiEntity entityToSave = new DividendiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(dividendiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(dividendiService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        DividendiEntity entityToSave = new DividendiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(dividendiService.save(entityToSave) != null);

        assertTrue(dividendiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        DividendiEntity entityToSave = new DividendiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(dividendiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        DividendiEntity entityToDelete = new DividendiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DividendiEntity entitySaved = dividendiService.save(entityToDelete);
        assertNotNull(dividendiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        dividendiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            dividendiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        DividendiEntity entityToDelete = new DividendiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DividendiEntity entitySaved = dividendiService.save(entityToDelete);
        assertNotNull(dividendiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        dividendiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            dividendiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<DividendiEntity> aIterable = StreamSupport.stream(dividendiService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aIterable.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        DividendiEntity entityToDelete = new DividendiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DividendiEntity entitySaved = dividendiService.save(entityToDelete);
        assertNotNull(dividendiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<DividendiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        dividendiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            dividendiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(dividendiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(dividendiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            dividendiService.deleteAll(dividendiService.findAll());
            assertTrue(StreamSupport.stream(dividendiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        DividendiEntity entityToDelete = new DividendiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DividendiEntity entitySaved = dividendiService.save(entityToDelete);
        assertNotNull(dividendiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        dividendiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            dividendiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(dividendiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(dividendiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            dividendiService.deleteAll(dividendiService.findAll());
            assertTrue(StreamSupport.stream(dividendiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
