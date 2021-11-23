package com.project.bebudgeting.annuali.uscite;

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

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice.AlimentiAnimaliDomesticiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AlimentiAnimaliDomesticiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AlimentiAnimaliDomesticiService alimentiAnimaliDomesticiService;

    // COUNT TEST
    @Test
    void countAllAltroSalarioEntitiesTest() {
        AlimentiAnimaliDomesticiEntity entityToDelete = new AlimentiAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AlimentiAnimaliDomesticiEntity entitySaved = alimentiAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(alimentiAnimaliDomesticiService.findById(entitySaved.getId()).get());
        assertTrue(alimentiAnimaliDomesticiService.count() != 0);

        alimentiAnimaliDomesticiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AlimentiAnimaliDomesticiEntity entityToSave = new AlimentiAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(alimentiAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(alimentiAnimaliDomesticiService.findAll() != null);
    }

    @Test
    void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AlimentiAnimaliDomesticiEntity entityToSave = new AlimentiAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(alimentiAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(alimentiAnimaliDomesticiService.findById(entityToSave.getId()) != null);
    }

    @Test
    void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AlimentiAnimaliDomesticiEntity entityToSave = new AlimentiAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(alimentiAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(alimentiAnimaliDomesticiService.findAllById(ids) != null);
    }

    @Test
    void findById() {
        // SAVE ONE ENTITY
        AlimentiAnimaliDomesticiEntity entityToSave = new AlimentiAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(alimentiAnimaliDomesticiService.save(entityToSave) != null);

        assertTrue(alimentiAnimaliDomesticiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AlimentiAnimaliDomesticiEntity entityToSave = new AlimentiAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(alimentiAnimaliDomesticiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AlimentiAnimaliDomesticiEntity entityToDelete = new AlimentiAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AlimentiAnimaliDomesticiEntity entitySaved = alimentiAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(alimentiAnimaliDomesticiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        alimentiAnimaliDomesticiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            alimentiAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AlimentiAnimaliDomesticiEntity entityToDelete = new AlimentiAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AlimentiAnimaliDomesticiEntity entitySaved = alimentiAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(alimentiAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        alimentiAnimaliDomesticiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            alimentiAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AlimentiAnimaliDomesticiEntity> aList = StreamSupport
                .stream(alimentiAnimaliDomesticiService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AlimentiAnimaliDomesticiEntity entityToDelete = new AlimentiAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AlimentiAnimaliDomesticiEntity entitySaved = alimentiAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(alimentiAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AlimentiAnimaliDomesticiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        alimentiAnimaliDomesticiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            alimentiAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(alimentiAnimaliDomesticiService.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(alimentiAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            alimentiAnimaliDomesticiService.deleteAll(alimentiAnimaliDomesticiService.findAll());

            assertTrue(StreamSupport.stream(alimentiAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    void deleteAllByIdsTest() {
        AlimentiAnimaliDomesticiEntity entityToDelete = new AlimentiAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AlimentiAnimaliDomesticiEntity entitySaved = alimentiAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(alimentiAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        alimentiAnimaliDomesticiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            alimentiAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(alimentiAnimaliDomesticiService.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(alimentiAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            alimentiAnimaliDomesticiService.deleteAll(alimentiAnimaliDomesticiService.findAll());
            assertTrue(StreamSupport.stream(alimentiAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
