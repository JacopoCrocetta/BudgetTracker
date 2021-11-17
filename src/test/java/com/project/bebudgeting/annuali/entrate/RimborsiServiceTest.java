package com.project.bebudgeting.annuali.entrate;

import org.junit.jupiter.api.Test;
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

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.RimborsiEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.RimborsiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RimborsiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    RimborsiService rimborsiService;

    // COUNT TEST
    @Test
    void countAllAltroSalarioEntitiesTest() {
        RimborsiEntity entityToDelete = new RimborsiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RimborsiEntity entitySaved = rimborsiService.save(entityToDelete);
        assertNotNull(rimborsiService.findById(entitySaved.getId()).get());
        assertTrue(rimborsiService.count() != 0);

        rimborsiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        RimborsiEntity entityToSave = new RimborsiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(rimborsiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(rimborsiService.findAll() != null);
    }

    @Test
    void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        RimborsiEntity entityToSave = new RimborsiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(rimborsiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(rimborsiService.findById(entityToSave.getId()) != null);
    }

    @Test
    void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        RimborsiEntity entityToSave = new RimborsiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(rimborsiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(rimborsiService.findAllById(ids) != null);
    }

    @Test
    void findById() {
        // SAVE ONE ENTITY
        RimborsiEntity entityToSave = new RimborsiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(rimborsiService.save(entityToSave) != null);

        assertTrue(rimborsiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        RimborsiEntity entityToSave = new RimborsiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(rimborsiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        RimborsiEntity entityToDelete = new RimborsiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RimborsiEntity entitySaved = rimborsiService.save(entityToDelete);
        assertNotNull(rimborsiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        rimborsiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            rimborsiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        RimborsiEntity entityToDelete = new RimborsiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RimborsiEntity entitySaved = rimborsiService.save(entityToDelete);
        assertNotNull(rimborsiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        rimborsiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            rimborsiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<RimborsiEntity> aList = StreamSupport.stream(rimborsiService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        RimborsiEntity entityToDelete = new RimborsiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RimborsiEntity entitySaved = rimborsiService.save(entityToDelete);
        assertNotNull(rimborsiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<RimborsiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        rimborsiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            rimborsiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(rimborsiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(rimborsiService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            rimborsiService.deleteAll(rimborsiService.findAll());

            assertTrue(StreamSupport.stream(rimborsiService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    void deleteAllByIdsTest() {
        RimborsiEntity entityToDelete = new RimborsiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RimborsiEntity entitySaved = rimborsiService.save(entityToDelete);
        assertNotNull(rimborsiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        rimborsiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            rimborsiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(rimborsiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(rimborsiService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            rimborsiService.deleteAll(rimborsiService.findAll());
            assertTrue(StreamSupport.stream(rimborsiService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
