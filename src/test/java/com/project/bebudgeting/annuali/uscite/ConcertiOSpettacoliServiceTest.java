package com.project.bebudgeting.annuali.uscite;

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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.ConcertiOSpettacoliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.ConcertiOSpettacoliService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConcertiOSpettacoliServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    ConcertiOSpettacoliService concertiOSpettacoliService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        ConcertiOSpettacoliEntity entityToDelete = new ConcertiOSpettacoliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ConcertiOSpettacoliEntity entitySaved = concertiOSpettacoliService.save(entityToDelete);
        assertNotNull(concertiOSpettacoliService.findById(entitySaved.getId()).get());
        assertTrue(concertiOSpettacoliService.count() != 0);

        concertiOSpettacoliService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        ConcertiOSpettacoliEntity entityToSave = new ConcertiOSpettacoliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(concertiOSpettacoliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(concertiOSpettacoliService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        ConcertiOSpettacoliEntity entityToSave = new ConcertiOSpettacoliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(concertiOSpettacoliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(concertiOSpettacoliService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        ConcertiOSpettacoliEntity entityToSave = new ConcertiOSpettacoliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(concertiOSpettacoliService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(concertiOSpettacoliService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        ConcertiOSpettacoliEntity entityToSave = new ConcertiOSpettacoliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(concertiOSpettacoliService.save(entityToSave) != null);

        assertTrue(concertiOSpettacoliService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        ConcertiOSpettacoliEntity entityToSave = new ConcertiOSpettacoliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(concertiOSpettacoliService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        ConcertiOSpettacoliEntity entityToDelete = new ConcertiOSpettacoliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ConcertiOSpettacoliEntity entitySaved = concertiOSpettacoliService.save(entityToDelete);
        assertNotNull(concertiOSpettacoliService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        concertiOSpettacoliService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            concertiOSpettacoliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        ConcertiOSpettacoliEntity entityToDelete = new ConcertiOSpettacoliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ConcertiOSpettacoliEntity entitySaved = concertiOSpettacoliService.save(entityToDelete);
        assertNotNull(concertiOSpettacoliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        concertiOSpettacoliService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            concertiOSpettacoliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<ConcertiOSpettacoliEntity> aList = StreamSupport
                .stream(concertiOSpettacoliService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        ConcertiOSpettacoliEntity entityToDelete = new ConcertiOSpettacoliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ConcertiOSpettacoliEntity entitySaved = concertiOSpettacoliService.save(entityToDelete);
        assertNotNull(concertiOSpettacoliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<ConcertiOSpettacoliEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        concertiOSpettacoliService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            concertiOSpettacoliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(concertiOSpettacoliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(concertiOSpettacoliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            concertiOSpettacoliService.deleteAll(concertiOSpettacoliService.findAll());

            assertTrue(StreamSupport.stream(concertiOSpettacoliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        ConcertiOSpettacoliEntity entityToDelete = new ConcertiOSpettacoliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ConcertiOSpettacoliEntity entitySaved = concertiOSpettacoliService.save(entityToDelete);
        assertNotNull(concertiOSpettacoliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        concertiOSpettacoliService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            concertiOSpettacoliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(concertiOSpettacoliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(concertiOSpettacoliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            concertiOSpettacoliService.deleteAll(concertiOSpettacoliService.findAll());
            assertTrue(StreamSupport.stream(concertiOSpettacoliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
