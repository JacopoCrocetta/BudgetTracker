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

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.TraslocoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.TraslocoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TraslocoCasaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    TraslocoService traslocoService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        TraslocoEntity entityToDelete = new TraslocoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TraslocoEntity entitySaved = traslocoService.save(entityToDelete);
        assertNotNull(traslocoService.findById(entitySaved.getId()).get());
        assertTrue(traslocoService.count() != 0);

        traslocoService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        TraslocoEntity entityToSave = new TraslocoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(traslocoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(traslocoService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        TraslocoEntity entityToSave = new TraslocoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(traslocoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(traslocoService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        TraslocoEntity entityToSave = new TraslocoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(traslocoService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(traslocoService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        TraslocoEntity entityToSave = new TraslocoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(traslocoService.save(entityToSave) != null);

        assertTrue(traslocoService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        TraslocoEntity entityToSave = new TraslocoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(traslocoService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        TraslocoEntity entityToDelete = new TraslocoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TraslocoEntity entitySaved = traslocoService.save(entityToDelete);
        assertNotNull(traslocoService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        traslocoService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            traslocoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        TraslocoEntity entityToDelete = new TraslocoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TraslocoEntity entitySaved = traslocoService.save(entityToDelete);
        assertNotNull(traslocoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        traslocoService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            traslocoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<TraslocoEntity> aList = StreamSupport.stream(traslocoService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        TraslocoEntity entityToDelete = new TraslocoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TraslocoEntity entitySaved = traslocoService.save(entityToDelete);
        assertNotNull(traslocoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<TraslocoEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        traslocoService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            traslocoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(traslocoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(traslocoService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            traslocoService.deleteAll(traslocoService.findAll());

            assertTrue(StreamSupport.stream(traslocoService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        TraslocoEntity entityToDelete = new TraslocoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TraslocoEntity entitySaved = traslocoService.save(entityToDelete);
        assertNotNull(traslocoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        traslocoService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            traslocoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(traslocoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(traslocoService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {

            traslocoService.deleteAll(traslocoService.findAll());
            assertTrue(StreamSupport.stream(traslocoService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
