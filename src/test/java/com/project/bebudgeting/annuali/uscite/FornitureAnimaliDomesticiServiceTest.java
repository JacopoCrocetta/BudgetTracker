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

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice.FornitureAnimaliDomesticiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FornitureAnimaliDomesticiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    FornitureAnimaliDomesticiService fornitureAnimaliDomesticiService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        FornitureAnimaliDomesticiEntity entityToDelete = new FornitureAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureAnimaliDomesticiEntity entitySaved = fornitureAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(fornitureAnimaliDomesticiService.findById(entitySaved.getId()).get());
        assertTrue(fornitureAnimaliDomesticiService.count() != 0);

        fornitureAnimaliDomesticiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        FornitureAnimaliDomesticiEntity entityToSave = new FornitureAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fornitureAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(fornitureAnimaliDomesticiService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        FornitureAnimaliDomesticiEntity entityToSave = new FornitureAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fornitureAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(fornitureAnimaliDomesticiService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        FornitureAnimaliDomesticiEntity entityToSave = new FornitureAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fornitureAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(fornitureAnimaliDomesticiService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        FornitureAnimaliDomesticiEntity entityToSave = new FornitureAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fornitureAnimaliDomesticiService.save(entityToSave) != null);

        assertTrue(fornitureAnimaliDomesticiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        FornitureAnimaliDomesticiEntity entityToSave = new FornitureAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(fornitureAnimaliDomesticiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        FornitureAnimaliDomesticiEntity entityToDelete = new FornitureAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureAnimaliDomesticiEntity entitySaved = fornitureAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(fornitureAnimaliDomesticiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        fornitureAnimaliDomesticiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fornitureAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        FornitureAnimaliDomesticiEntity entityToDelete = new FornitureAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureAnimaliDomesticiEntity entitySaved = fornitureAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(fornitureAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        fornitureAnimaliDomesticiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fornitureAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<FornitureAnimaliDomesticiEntity> aList = StreamSupport
                .stream(fornitureAnimaliDomesticiService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        FornitureAnimaliDomesticiEntity entityToDelete = new FornitureAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureAnimaliDomesticiEntity entitySaved = fornitureAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(fornitureAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<FornitureAnimaliDomesticiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        fornitureAnimaliDomesticiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fornitureAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(fornitureAnimaliDomesticiService.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(fornitureAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            fornitureAnimaliDomesticiService.deleteAll(fornitureAnimaliDomesticiService.findAll());

            assertTrue(StreamSupport.stream(fornitureAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        FornitureAnimaliDomesticiEntity entityToDelete = new FornitureAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureAnimaliDomesticiEntity entitySaved = fornitureAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(fornitureAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertNotNull(entitySaved);

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        fornitureAnimaliDomesticiService.deleteAllById(ids);

        List<FornitureAnimaliDomesticiEntity> aFornitureAnimaliDomesticiEntities = StreamSupport
                .stream(fornitureAnimaliDomesticiService.findAll().spliterator(), false).collect(Collectors.toList());

        if (aFornitureAnimaliDomesticiEntities.size() == 0) {
            assertTrue(aFornitureAnimaliDomesticiEntities.size() == 0);
        } else {
            fornitureAnimaliDomesticiService.deleteAll(fornitureAnimaliDomesticiService.findAll());
            aFornitureAnimaliDomesticiEntities = StreamSupport
                    .stream(fornitureAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList());
            assertTrue(aFornitureAnimaliDomesticiEntities.size() == 0);
        }
    }
}
