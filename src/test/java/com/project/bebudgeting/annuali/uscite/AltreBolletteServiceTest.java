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

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.AltreBolletteEntity;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.AltreBolletteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltreBolletteServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltreBolletteService altreBolletteService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltreBolletteEntity entityToDelete = new AltreBolletteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreBolletteEntity entitySaved = altreBolletteService.save(entityToDelete);
        assertNotNull(altreBolletteService.findById(entitySaved.getId()).get());
        assertTrue(altreBolletteService.count() != 0);

        altreBolletteService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltreBolletteEntity entityToSave = new AltreBolletteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreBolletteService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altreBolletteService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltreBolletteEntity entityToSave = new AltreBolletteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreBolletteService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altreBolletteService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltreBolletteEntity entityToSave = new AltreBolletteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreBolletteService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altreBolletteService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltreBolletteEntity entityToSave = new AltreBolletteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreBolletteService.save(entityToSave) != null);

        assertTrue(altreBolletteService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltreBolletteEntity entityToSave = new AltreBolletteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altreBolletteService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltreBolletteEntity entityToDelete = new AltreBolletteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreBolletteEntity entitySaved = altreBolletteService.save(entityToDelete);
        assertNotNull(altreBolletteService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altreBolletteService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreBolletteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltreBolletteEntity entityToDelete = new AltreBolletteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreBolletteEntity entitySaved = altreBolletteService.save(entityToDelete);
        assertNotNull(altreBolletteService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altreBolletteService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreBolletteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltreBolletteEntity> aList = StreamSupport.stream(altreBolletteService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltreBolletteEntity entityToDelete = new AltreBolletteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreBolletteEntity entitySaved = altreBolletteService.save(entityToDelete);
        assertNotNull(altreBolletteService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltreBolletteEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altreBolletteService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreBolletteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altreBolletteService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altreBolletteService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altreBolletteService.deleteAll(altreBolletteService.findAll());

            assertTrue(StreamSupport.stream(altreBolletteService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltreBolletteEntity entityToDelete = new AltreBolletteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreBolletteEntity entitySaved = altreBolletteService.save(entityToDelete);
        assertNotNull(altreBolletteService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altreBolletteService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreBolletteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altreBolletteService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altreBolletteService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altreBolletteService.deleteAll(altreBolletteService.findAll());
            assertTrue(StreamSupport.stream(altreBolletteService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
