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

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteAcquaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteAcquaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BolletteAcquaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    BolletteAcquaService bolletteAcquaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        BolletteAcquaEntity entityToDelete = new BolletteAcquaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteAcquaEntity entitySaved = bolletteAcquaService.save(entityToDelete);
        assertNotNull(bolletteAcquaService.findById(entitySaved.getId()).get());
        assertTrue(bolletteAcquaService.count() != 0);

        bolletteAcquaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteAcquaEntity entityToSave = new BolletteAcquaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteAcquaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bolletteAcquaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteAcquaEntity entityToSave = new BolletteAcquaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteAcquaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bolletteAcquaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteAcquaEntity entityToSave = new BolletteAcquaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteAcquaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(bolletteAcquaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        BolletteAcquaEntity entityToSave = new BolletteAcquaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteAcquaService.save(entityToSave) != null);

        assertTrue(bolletteAcquaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        BolletteAcquaEntity entityToSave = new BolletteAcquaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(bolletteAcquaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        BolletteAcquaEntity entityToDelete = new BolletteAcquaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteAcquaEntity entitySaved = bolletteAcquaService.save(entityToDelete);
        assertNotNull(bolletteAcquaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bolletteAcquaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteAcquaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        BolletteAcquaEntity entityToDelete = new BolletteAcquaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteAcquaEntity entitySaved = bolletteAcquaService.save(entityToDelete);
        assertNotNull(bolletteAcquaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bolletteAcquaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteAcquaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<BolletteAcquaEntity> aList = StreamSupport.stream(bolletteAcquaService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        BolletteAcquaEntity entityToDelete = new BolletteAcquaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteAcquaEntity entitySaved = bolletteAcquaService.save(entityToDelete);
        assertNotNull(bolletteAcquaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<BolletteAcquaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        bolletteAcquaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteAcquaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bolletteAcquaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bolletteAcquaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            bolletteAcquaService.deleteAll(bolletteAcquaService.findAll());

            assertTrue(StreamSupport.stream(bolletteAcquaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        BolletteAcquaEntity entityToDelete = new BolletteAcquaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteAcquaEntity entitySaved = bolletteAcquaService.save(entityToDelete);
        assertNotNull(bolletteAcquaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        bolletteAcquaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteAcquaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bolletteAcquaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bolletteAcquaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            bolletteAcquaService.deleteAll(bolletteAcquaService.findAll());
            assertTrue(StreamSupport.stream(bolletteAcquaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}