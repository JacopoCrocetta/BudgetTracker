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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.SportEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.SportService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SportDivertimentoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    SportService sportService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        SportEntity entityToDelete = new SportEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SportEntity entitySaved = sportService.save(entityToDelete);
        assertNotNull(sportService.findById(entitySaved.getId()).get());
        assertTrue(sportService.count() != 0);

        sportService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        SportEntity entityToSave = new SportEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(sportService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(sportService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        SportEntity entityToSave = new SportEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(sportService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(sportService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        SportEntity entityToSave = new SportEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(sportService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(sportService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        SportEntity entityToSave = new SportEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(sportService.save(entityToSave) != null);

        assertTrue(sportService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        SportEntity entityToSave = new SportEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(sportService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        SportEntity entityToDelete = new SportEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SportEntity entitySaved = sportService.save(entityToDelete);
        assertNotNull(sportService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        sportService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            sportService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        SportEntity entityToDelete = new SportEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SportEntity entitySaved = sportService.save(entityToDelete);
        assertNotNull(sportService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        sportService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            sportService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<SportEntity> aList = StreamSupport.stream(sportService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        SportEntity entityToDelete = new SportEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SportEntity entitySaved = sportService.save(entityToDelete);
        assertNotNull(sportService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<SportEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        sportService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            sportService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(sportService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(sportService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            sportService.deleteAll(sportService.findAll());

            assertTrue(StreamSupport.stream(sportService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        SportEntity entityToDelete = new SportEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SportEntity entitySaved = sportService.save(entityToDelete);
        assertNotNull(sportService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        sportService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            sportService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(sportService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(sportService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            sportService.deleteAll(sportService.findAll());
            assertTrue(StreamSupport.stream(sportService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
