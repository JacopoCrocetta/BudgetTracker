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

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.DottoriEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice.DottoriService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DottoriServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    DottoriService dottoriService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        DottoriEntity entityToDelete = new DottoriEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DottoriEntity entitySaved = dottoriService.save(entityToDelete);
        assertNotNull(dottoriService.findById(entitySaved.getId()).get());
        assertTrue(dottoriService.count() != 0);

        dottoriService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        DottoriEntity entityToSave = new DottoriEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(dottoriService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(dottoriService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        DottoriEntity entityToSave = new DottoriEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(dottoriService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(dottoriService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        DottoriEntity entityToSave = new DottoriEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(dottoriService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(dottoriService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        DottoriEntity entityToSave = new DottoriEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(dottoriService.save(entityToSave) != null);

        assertTrue(dottoriService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        DottoriEntity entityToSave = new DottoriEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(dottoriService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        DottoriEntity entityToDelete = new DottoriEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DottoriEntity entitySaved = dottoriService.save(entityToDelete);
        assertNotNull(dottoriService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        dottoriService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            dottoriService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        DottoriEntity entityToDelete = new DottoriEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DottoriEntity entitySaved = dottoriService.save(entityToDelete);
        assertNotNull(dottoriService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        dottoriService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            dottoriService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<DottoriEntity> aList = StreamSupport
                .stream(dottoriService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        DottoriEntity entityToDelete = new DottoriEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DottoriEntity entitySaved = dottoriService.save(entityToDelete);
        assertNotNull(dottoriService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<DottoriEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        dottoriService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            dottoriService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(dottoriService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(dottoriService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            dottoriService.deleteAll(dottoriService.findAll());

            assertTrue(StreamSupport.stream(dottoriService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        DottoriEntity entityToDelete = new DottoriEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DottoriEntity entitySaved = dottoriService.save(entityToDelete);
        assertNotNull(dottoriService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        dottoriService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            dottoriService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(dottoriService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(dottoriService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            dottoriService.deleteAll(dottoriService.findAll());
            assertTrue(StreamSupport.stream(dottoriService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
