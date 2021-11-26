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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.AttivitaOutsideEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.AttivitaOutsideService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AttivitaOutsideServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AttivitaOutsideService attivitaOutsideService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AttivitaOutsideEntity entityToDelete = new AttivitaOutsideEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaOutsideEntity entitySaved = attivitaOutsideService.save(entityToDelete);
        assertNotNull(attivitaOutsideService.findById(entitySaved.getId()).get());
        assertTrue(attivitaOutsideService.count() != 0);

        attivitaOutsideService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AttivitaOutsideEntity entityToSave = new AttivitaOutsideEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(attivitaOutsideService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(attivitaOutsideService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AttivitaOutsideEntity entityToSave = new AttivitaOutsideEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(attivitaOutsideService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(attivitaOutsideService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AttivitaOutsideEntity entityToSave = new AttivitaOutsideEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(attivitaOutsideService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(attivitaOutsideService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AttivitaOutsideEntity entityToSave = new AttivitaOutsideEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(attivitaOutsideService.save(entityToSave) != null);

        assertTrue(attivitaOutsideService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AttivitaOutsideEntity entityToSave = new AttivitaOutsideEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(attivitaOutsideService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AttivitaOutsideEntity entityToDelete = new AttivitaOutsideEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaOutsideEntity entitySaved = attivitaOutsideService.save(entityToDelete);
        assertNotNull(attivitaOutsideService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        attivitaOutsideService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            attivitaOutsideService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AttivitaOutsideEntity entityToDelete = new AttivitaOutsideEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaOutsideEntity entitySaved = attivitaOutsideService.save(entityToDelete);
        assertNotNull(attivitaOutsideService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        attivitaOutsideService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            attivitaOutsideService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AttivitaOutsideEntity> aList = StreamSupport.stream(attivitaOutsideService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AttivitaOutsideEntity entityToDelete = new AttivitaOutsideEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaOutsideEntity entitySaved = attivitaOutsideService.save(entityToDelete);
        assertNotNull(attivitaOutsideService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AttivitaOutsideEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        attivitaOutsideService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            attivitaOutsideService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(attivitaOutsideService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(attivitaOutsideService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            attivitaOutsideService.deleteAll(attivitaOutsideService.findAll());

            assertTrue(StreamSupport.stream(attivitaOutsideService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AttivitaOutsideEntity entityToDelete = new AttivitaOutsideEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AttivitaOutsideEntity entitySaved = attivitaOutsideService.save(entityToDelete);
        assertNotNull(attivitaOutsideService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        attivitaOutsideService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            attivitaOutsideService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(attivitaOutsideService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(attivitaOutsideService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            attivitaOutsideService.deleteAll(attivitaOutsideService.findAll());
            assertTrue(StreamSupport.stream(attivitaOutsideService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
