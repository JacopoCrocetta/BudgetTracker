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

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.PaghettaFigliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.PaghettaFigliService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PaghettaFigliServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    PaghettaFigliService paghettaFigliService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        PaghettaFigliEntity entityToDelete = new PaghettaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PaghettaFigliEntity entitySaved = paghettaFigliService.save(entityToDelete);
        assertNotNull(paghettaFigliService.findById(entitySaved.getId()).get());
        assertTrue(paghettaFigliService.count() != 0);

        paghettaFigliService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        PaghettaFigliEntity entityToSave = new PaghettaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(paghettaFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(paghettaFigliService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        PaghettaFigliEntity entityToSave = new PaghettaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(paghettaFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(paghettaFigliService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        PaghettaFigliEntity entityToSave = new PaghettaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(paghettaFigliService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(paghettaFigliService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        PaghettaFigliEntity entityToSave = new PaghettaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(paghettaFigliService.save(entityToSave) != null);

        assertTrue(paghettaFigliService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        PaghettaFigliEntity entityToSave = new PaghettaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(paghettaFigliService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        PaghettaFigliEntity entityToDelete = new PaghettaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PaghettaFigliEntity entitySaved = paghettaFigliService.save(entityToDelete);
        assertNotNull(paghettaFigliService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        paghettaFigliService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            paghettaFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        PaghettaFigliEntity entityToDelete = new PaghettaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PaghettaFigliEntity entitySaved = paghettaFigliService.save(entityToDelete);
        assertNotNull(paghettaFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        paghettaFigliService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            paghettaFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<PaghettaFigliEntity> aList = StreamSupport
                .stream(paghettaFigliService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        PaghettaFigliEntity entityToDelete = new PaghettaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PaghettaFigliEntity entitySaved = paghettaFigliService.save(entityToDelete);
        assertNotNull(paghettaFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<PaghettaFigliEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        paghettaFigliService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            paghettaFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(paghettaFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(paghettaFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            paghettaFigliService.deleteAll(paghettaFigliService.findAll());

            assertTrue(StreamSupport.stream(paghettaFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        PaghettaFigliEntity entityToDelete = new PaghettaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PaghettaFigliEntity entitySaved = paghettaFigliService.save(entityToDelete);
        assertNotNull(paghettaFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        paghettaFigliService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            paghettaFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(paghettaFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(paghettaFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            paghettaFigliService.deleteAll(paghettaFigliService.findAll());
            assertTrue(StreamSupport.stream(paghettaFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}