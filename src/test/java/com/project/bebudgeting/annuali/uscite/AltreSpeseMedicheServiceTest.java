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

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.AltroSpeseMedicheEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice.AltreSpeseMedicheService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltreSpeseMedicheServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltreSpeseMedicheService altreSpeseMedicheService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltroSpeseMedicheEntity entityToDelete = new AltroSpeseMedicheEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroSpeseMedicheEntity entitySaved = altreSpeseMedicheService.save(entityToDelete);
        assertNotNull(altreSpeseMedicheService.findById(entitySaved.getId()).get());
        assertTrue(altreSpeseMedicheService.count() != 0);

        altreSpeseMedicheService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltroSpeseMedicheEntity entityToSave = new AltroSpeseMedicheEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreSpeseMedicheService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altreSpeseMedicheService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroSpeseMedicheEntity entityToSave = new AltroSpeseMedicheEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreSpeseMedicheService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altreSpeseMedicheService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroSpeseMedicheEntity entityToSave = new AltroSpeseMedicheEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreSpeseMedicheService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altreSpeseMedicheService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltroSpeseMedicheEntity entityToSave = new AltroSpeseMedicheEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreSpeseMedicheService.save(entityToSave) != null);

        assertTrue(altreSpeseMedicheService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltroSpeseMedicheEntity entityToSave = new AltroSpeseMedicheEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altreSpeseMedicheService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltroSpeseMedicheEntity entityToDelete = new AltroSpeseMedicheEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroSpeseMedicheEntity entitySaved = altreSpeseMedicheService.save(entityToDelete);
        assertNotNull(altreSpeseMedicheService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altreSpeseMedicheService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreSpeseMedicheService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltroSpeseMedicheEntity entityToDelete = new AltroSpeseMedicheEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroSpeseMedicheEntity entitySaved = altreSpeseMedicheService.save(entityToDelete);
        assertNotNull(altreSpeseMedicheService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altreSpeseMedicheService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreSpeseMedicheService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltroSpeseMedicheEntity> aList = StreamSupport
                .stream(altreSpeseMedicheService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltroSpeseMedicheEntity entityToDelete = new AltroSpeseMedicheEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroSpeseMedicheEntity entitySaved = altreSpeseMedicheService.save(entityToDelete);
        assertNotNull(altreSpeseMedicheService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltroSpeseMedicheEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altreSpeseMedicheService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreSpeseMedicheService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altreSpeseMedicheService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altreSpeseMedicheService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altreSpeseMedicheService.deleteAll(altreSpeseMedicheService.findAll());

            assertTrue(StreamSupport.stream(altreSpeseMedicheService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltroSpeseMedicheEntity entityToDelete = new AltroSpeseMedicheEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroSpeseMedicheEntity entitySaved = altreSpeseMedicheService.save(entityToDelete);
        assertNotNull(altreSpeseMedicheService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altreSpeseMedicheService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreSpeseMedicheService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altreSpeseMedicheService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altreSpeseMedicheService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altreSpeseMedicheService.deleteAll(altreSpeseMedicheService.findAll());
            assertTrue(StreamSupport.stream(altreSpeseMedicheService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
