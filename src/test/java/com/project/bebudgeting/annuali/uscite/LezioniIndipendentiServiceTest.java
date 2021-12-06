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

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LezioniIndipendentiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice.LezioniIndipendentiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LezioniIndipendentiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    LezioniIndipendentiService lezioniIndipendentiService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        LezioniIndipendentiEntity entityToDelete = new LezioniIndipendentiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LezioniIndipendentiEntity entitySaved = lezioniIndipendentiService.save(entityToDelete);
        assertNotNull(lezioniIndipendentiService.findById(entitySaved.getId()).get());
        assertTrue(lezioniIndipendentiService.count() != 0);

        lezioniIndipendentiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        LezioniIndipendentiEntity entityToSave = new LezioniIndipendentiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(lezioniIndipendentiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(lezioniIndipendentiService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        LezioniIndipendentiEntity entityToSave = new LezioniIndipendentiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(lezioniIndipendentiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(lezioniIndipendentiService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        LezioniIndipendentiEntity entityToSave = new LezioniIndipendentiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(lezioniIndipendentiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(lezioniIndipendentiService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        LezioniIndipendentiEntity entityToSave = new LezioniIndipendentiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(lezioniIndipendentiService.save(entityToSave) != null);

        assertTrue(lezioniIndipendentiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        LezioniIndipendentiEntity entityToSave = new LezioniIndipendentiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(lezioniIndipendentiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        LezioniIndipendentiEntity entityToDelete = new LezioniIndipendentiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LezioniIndipendentiEntity entitySaved = lezioniIndipendentiService.save(entityToDelete);
        assertNotNull(lezioniIndipendentiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        lezioniIndipendentiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            lezioniIndipendentiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        LezioniIndipendentiEntity entityToDelete = new LezioniIndipendentiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LezioniIndipendentiEntity entitySaved = lezioniIndipendentiService.save(entityToDelete);
        assertNotNull(lezioniIndipendentiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        lezioniIndipendentiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            lezioniIndipendentiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<LezioniIndipendentiEntity> aList = StreamSupport
                .stream(lezioniIndipendentiService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        LezioniIndipendentiEntity entityToDelete = new LezioniIndipendentiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LezioniIndipendentiEntity entitySaved = lezioniIndipendentiService.save(entityToDelete);
        assertNotNull(lezioniIndipendentiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<LezioniIndipendentiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        lezioniIndipendentiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            lezioniIndipendentiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(lezioniIndipendentiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(lezioniIndipendentiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            lezioniIndipendentiService.deleteAll(lezioniIndipendentiService.findAll());

            assertTrue(StreamSupport.stream(lezioniIndipendentiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        LezioniIndipendentiEntity entityToDelete = new LezioniIndipendentiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LezioniIndipendentiEntity entitySaved = lezioniIndipendentiService.save(entityToDelete);
        assertNotNull(lezioniIndipendentiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        lezioniIndipendentiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            lezioniIndipendentiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(lezioniIndipendentiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(lezioniIndipendentiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            lezioniIndipendentiService.deleteAll(lezioniIndipendentiService.findAll());
            assertTrue(StreamSupport.stream(lezioniIndipendentiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
