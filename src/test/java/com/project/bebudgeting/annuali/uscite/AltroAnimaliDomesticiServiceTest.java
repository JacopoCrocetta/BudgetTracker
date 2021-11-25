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

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.AltroAnimaliDomesticiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice.AltroAnimaliDomesticiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltroAnimaliDomesticiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltroAnimaliDomesticiService altroAnimaliDomesticiService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltroAnimaliDomesticiEntity entityToDelete = new AltroAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAnimaliDomesticiEntity entitySaved = altroAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(altroAnimaliDomesticiService.findById(entitySaved.getId()).get());
        assertTrue(altroAnimaliDomesticiService.count() != 0);

        altroAnimaliDomesticiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltroAnimaliDomesticiEntity entityToSave = new AltroAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroAnimaliDomesticiService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroAnimaliDomesticiEntity entityToSave = new AltroAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroAnimaliDomesticiService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroAnimaliDomesticiEntity entityToSave = new AltroAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altroAnimaliDomesticiService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltroAnimaliDomesticiEntity entityToSave = new AltroAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroAnimaliDomesticiService.save(entityToSave) != null);

        assertTrue(altroAnimaliDomesticiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltroAnimaliDomesticiEntity entityToSave = new AltroAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altroAnimaliDomesticiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltroAnimaliDomesticiEntity entityToDelete = new AltroAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAnimaliDomesticiEntity entitySaved = altroAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(altroAnimaliDomesticiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroAnimaliDomesticiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltroAnimaliDomesticiEntity entityToDelete = new AltroAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAnimaliDomesticiEntity entitySaved = altroAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(altroAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroAnimaliDomesticiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltroAnimaliDomesticiEntity> aList = StreamSupport
                .stream(altroAnimaliDomesticiService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltroAnimaliDomesticiEntity entityToDelete = new AltroAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAnimaliDomesticiEntity entitySaved = altroAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(altroAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltroAnimaliDomesticiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altroAnimaliDomesticiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroAnimaliDomesticiService.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(altroAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroAnimaliDomesticiService.deleteAll(altroAnimaliDomesticiService.findAll());

            assertTrue(StreamSupport.stream(altroAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltroAnimaliDomesticiEntity entityToDelete = new AltroAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAnimaliDomesticiEntity entitySaved = altroAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(altroAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altroAnimaliDomesticiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroAnimaliDomesticiService.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(altroAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroAnimaliDomesticiService.deleteAll(altroAnimaliDomesticiService.findAll());
            assertTrue(StreamSupport.stream(altroAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
