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

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.BustaPagaEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.BustaPagaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BustaPagaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    BustaPagaService bustaPagaService;

    // COUNT TEST
    @Test
    void countAllAltroSalarioEntitiesTest() {
        BustaPagaEntity entityToDelete = new BustaPagaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BustaPagaEntity entitySaved = bustaPagaService.save(entityToDelete);
        assertNotNull(bustaPagaService.findById(entitySaved.getId()).get());
        assertTrue(bustaPagaService.count() != 0);

        bustaPagaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        BustaPagaEntity entityToSave = new BustaPagaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bustaPagaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bustaPagaService.findAll() != null);
    }

    @Test
    void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        BustaPagaEntity entityToSave = new BustaPagaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bustaPagaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bustaPagaService.findById(entityToSave.getId()) != null);
    }

    @Test
    void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        BustaPagaEntity entityToSave = new BustaPagaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bustaPagaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(bustaPagaService.findAllById(ids) != null);
    }

    @Test
    void findById() {
        // SAVE ONE ENTITY
        BustaPagaEntity entityToSave = new BustaPagaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bustaPagaService.save(entityToSave) != null);

        assertTrue(bustaPagaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        BustaPagaEntity entityToSave = new BustaPagaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(bustaPagaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        BustaPagaEntity entityToDelete = new BustaPagaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BustaPagaEntity entitySaved = bustaPagaService.save(entityToDelete);
        assertNotNull(bustaPagaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bustaPagaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bustaPagaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        BustaPagaEntity entityToDelete = new BustaPagaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BustaPagaEntity entitySaved = bustaPagaService.save(entityToDelete);
        assertNotNull(bustaPagaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bustaPagaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bustaPagaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<BustaPagaEntity> aList = StreamSupport.stream(bustaPagaService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        BustaPagaEntity entityToDelete = new BustaPagaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BustaPagaEntity entitySaved = bustaPagaService.save(entityToDelete);
        assertNotNull(bustaPagaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<BustaPagaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        bustaPagaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bustaPagaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bustaPagaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bustaPagaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            bustaPagaService.deleteAll(bustaPagaService.findAll());

            assertTrue(StreamSupport.stream(bustaPagaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    void deleteAllByIdsTest() {
        BustaPagaEntity entityToDelete = new BustaPagaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BustaPagaEntity entitySaved = bustaPagaService.save(entityToDelete);
        assertNotNull(bustaPagaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        bustaPagaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bustaPagaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bustaPagaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bustaPagaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            bustaPagaService.deleteAll(bustaPagaService.findAll());
            assertTrue(StreamSupport.stream(bustaPagaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
