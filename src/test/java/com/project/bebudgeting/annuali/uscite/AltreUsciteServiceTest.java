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

import com.project.bebudgeting.entity.annuali.uscite.AltreUsciteEntity;
import com.project.bebudgeting.service.annuali.usciteservice.AltreUsciteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltreUsciteServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltreUsciteService altreUsciteService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltreUsciteEntity entityToDelete = new AltreUsciteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreUsciteEntity entitySaved = altreUsciteService.save(entityToDelete);
        assertNotNull(altreUsciteService.findById(entitySaved.getId()).get());
        assertTrue(altreUsciteService.count() != 0);

        altreUsciteService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltreUsciteEntity entityToSave = new AltreUsciteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreUsciteService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altreUsciteService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltreUsciteEntity entityToSave = new AltreUsciteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreUsciteService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altreUsciteService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltreUsciteEntity entityToSave = new AltreUsciteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreUsciteService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altreUsciteService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltreUsciteEntity entityToSave = new AltreUsciteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreUsciteService.save(entityToSave) != null);

        assertTrue(altreUsciteService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltreUsciteEntity entityToSave = new AltreUsciteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altreUsciteService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltreUsciteEntity entityToDelete = new AltreUsciteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreUsciteEntity entitySaved = altreUsciteService.save(entityToDelete);
        assertNotNull(altreUsciteService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altreUsciteService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreUsciteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltreUsciteEntity entityToDelete = new AltreUsciteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreUsciteEntity entitySaved = altreUsciteService.save(entityToDelete);
        assertNotNull(altreUsciteService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altreUsciteService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreUsciteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltreUsciteEntity> aList = StreamSupport.stream(altreUsciteService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltreUsciteEntity entityToDelete = new AltreUsciteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreUsciteEntity entitySaved = altreUsciteService.save(entityToDelete);
        assertNotNull(altreUsciteService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltreUsciteEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altreUsciteService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreUsciteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altreUsciteService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altreUsciteService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altreUsciteService.deleteAll(altreUsciteService.findAll());

            assertTrue(StreamSupport.stream(altreUsciteService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltreUsciteEntity entityToDelete = new AltreUsciteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreUsciteEntity entitySaved = altreUsciteService.save(entityToDelete);
        assertNotNull(altreUsciteService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altreUsciteService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreUsciteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altreUsciteService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altreUsciteService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altreUsciteService.deleteAll(altreUsciteService.findAll());
            assertTrue(StreamSupport.stream(altreUsciteService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
