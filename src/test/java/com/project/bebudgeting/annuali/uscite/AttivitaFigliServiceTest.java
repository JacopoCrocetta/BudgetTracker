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

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.AttivitaFigliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.AttivitaFigliService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AttivitaFigliServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AttivitaFigliService attivitaFigliService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AttivitaFigliEntity entityToDelete = new AttivitaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaFigliEntity entitySaved = attivitaFigliService.save(entityToDelete);
        assertNotNull(attivitaFigliService.findById(entitySaved.getId()).get());
        assertTrue(attivitaFigliService.count() != 0);

        attivitaFigliService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AttivitaFigliEntity entityToSave = new AttivitaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(attivitaFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(attivitaFigliService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AttivitaFigliEntity entityToSave = new AttivitaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(attivitaFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(attivitaFigliService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AttivitaFigliEntity entityToSave = new AttivitaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(attivitaFigliService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(attivitaFigliService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AttivitaFigliEntity entityToSave = new AttivitaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(attivitaFigliService.save(entityToSave) != null);

        assertTrue(attivitaFigliService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AttivitaFigliEntity entityToSave = new AttivitaFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(attivitaFigliService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AttivitaFigliEntity entityToDelete = new AttivitaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaFigliEntity entitySaved = attivitaFigliService.save(entityToDelete);
        assertNotNull(attivitaFigliService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        attivitaFigliService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            attivitaFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AttivitaFigliEntity entityToDelete = new AttivitaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaFigliEntity entitySaved = attivitaFigliService.save(entityToDelete);
        assertNotNull(attivitaFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        attivitaFigliService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            attivitaFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AttivitaFigliEntity> aList = StreamSupport
                .stream(attivitaFigliService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AttivitaFigliEntity entityToDelete = new AttivitaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaFigliEntity entitySaved = attivitaFigliService.save(entityToDelete);
        assertNotNull(attivitaFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AttivitaFigliEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        attivitaFigliService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            attivitaFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(attivitaFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(attivitaFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            attivitaFigliService.deleteAll(attivitaFigliService.findAll());

            assertTrue(StreamSupport.stream(attivitaFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AttivitaFigliEntity entityToDelete = new AttivitaFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaFigliEntity entitySaved = attivitaFigliService.save(entityToDelete);
        assertNotNull(attivitaFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        attivitaFigliService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            attivitaFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(attivitaFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(attivitaFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            attivitaFigliService.deleteAll(attivitaFigliService.findAll());
            assertTrue(StreamSupport.stream(attivitaFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
