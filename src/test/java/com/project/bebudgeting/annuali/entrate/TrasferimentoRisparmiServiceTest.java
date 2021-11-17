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

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.TrasferimentoRisparmiEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.TrasferimentoRisparmiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TrasferimentoRisparmiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    TrasferimentoRisparmiService trasferimentoRisparmiService;

    // COUNT TEST
    @Test
    void countAllAltroSalarioEntitiesTest() {
        TrasferimentoRisparmiEntity entityToDelete = new TrasferimentoRisparmiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TrasferimentoRisparmiEntity entitySaved = trasferimentoRisparmiService.save(entityToDelete);
        assertNotNull(trasferimentoRisparmiService.findById(entitySaved.getId()).get());
        assertTrue(trasferimentoRisparmiService.count() != 0);

        trasferimentoRisparmiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        TrasferimentoRisparmiEntity entityToSave = new TrasferimentoRisparmiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(trasferimentoRisparmiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(trasferimentoRisparmiService.findAll() != null);
    }

    @Test
    void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        TrasferimentoRisparmiEntity entityToSave = new TrasferimentoRisparmiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(trasferimentoRisparmiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(trasferimentoRisparmiService.findById(entityToSave.getId()) != null);
    }

    @Test
    void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        TrasferimentoRisparmiEntity entityToSave = new TrasferimentoRisparmiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(trasferimentoRisparmiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(trasferimentoRisparmiService.findAllById(ids) != null);
    }

    @Test
    void findById() {
        // SAVE ONE ENTITY
        TrasferimentoRisparmiEntity entityToSave = new TrasferimentoRisparmiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(trasferimentoRisparmiService.save(entityToSave) != null);

        assertTrue(trasferimentoRisparmiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        TrasferimentoRisparmiEntity entityToSave = new TrasferimentoRisparmiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(trasferimentoRisparmiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        TrasferimentoRisparmiEntity entityToDelete = new TrasferimentoRisparmiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TrasferimentoRisparmiEntity entitySaved = trasferimentoRisparmiService.save(entityToDelete);
        assertNotNull(trasferimentoRisparmiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        trasferimentoRisparmiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            trasferimentoRisparmiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        TrasferimentoRisparmiEntity entityToDelete = new TrasferimentoRisparmiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TrasferimentoRisparmiEntity entitySaved = trasferimentoRisparmiService.save(entityToDelete);
        assertNotNull(trasferimentoRisparmiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        trasferimentoRisparmiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            trasferimentoRisparmiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<TrasferimentoRisparmiEntity> aList = StreamSupport
                .stream(trasferimentoRisparmiService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        TrasferimentoRisparmiEntity entityToDelete = new TrasferimentoRisparmiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TrasferimentoRisparmiEntity entitySaved = trasferimentoRisparmiService.save(entityToDelete);
        assertNotNull(trasferimentoRisparmiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<TrasferimentoRisparmiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        trasferimentoRisparmiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            trasferimentoRisparmiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(trasferimentoRisparmiService.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(trasferimentoRisparmiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            trasferimentoRisparmiService.deleteAll(trasferimentoRisparmiService.findAll());

            assertTrue(StreamSupport.stream(trasferimentoRisparmiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    void deleteAllByIdsTest() {
        TrasferimentoRisparmiEntity entityToDelete = new TrasferimentoRisparmiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TrasferimentoRisparmiEntity entitySaved = trasferimentoRisparmiService.save(entityToDelete);
        assertNotNull(trasferimentoRisparmiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        trasferimentoRisparmiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            trasferimentoRisparmiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(trasferimentoRisparmiService.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(trasferimentoRisparmiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            trasferimentoRisparmiService.deleteAll(trasferimentoRisparmiService.findAll());
            assertTrue(StreamSupport.stream(trasferimentoRisparmiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
