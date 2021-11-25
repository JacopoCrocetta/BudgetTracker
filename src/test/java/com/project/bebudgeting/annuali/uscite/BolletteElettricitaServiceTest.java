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

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteElettricitaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteElettricitaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BolletteElettricitaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    BolletteElettricitaService bolletteElettricitaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        BolletteElettricitaEntity entityToDelete = new BolletteElettricitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteElettricitaEntity entitySaved = bolletteElettricitaService.save(entityToDelete);
        assertNotNull(bolletteElettricitaService.findById(entitySaved.getId()).get());
        assertTrue(bolletteElettricitaService.count() != 0);

        bolletteElettricitaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteElettricitaEntity entityToSave = new BolletteElettricitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteElettricitaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bolletteElettricitaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteElettricitaEntity entityToSave = new BolletteElettricitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteElettricitaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bolletteElettricitaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteElettricitaEntity entityToSave = new BolletteElettricitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteElettricitaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(bolletteElettricitaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        BolletteElettricitaEntity entityToSave = new BolletteElettricitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteElettricitaService.save(entityToSave) != null);

        assertTrue(bolletteElettricitaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        BolletteElettricitaEntity entityToSave = new BolletteElettricitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(bolletteElettricitaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        BolletteElettricitaEntity entityToDelete = new BolletteElettricitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteElettricitaEntity entitySaved = bolletteElettricitaService.save(entityToDelete);
        assertNotNull(bolletteElettricitaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bolletteElettricitaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteElettricitaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        BolletteElettricitaEntity entityToDelete = new BolletteElettricitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteElettricitaEntity entitySaved = bolletteElettricitaService.save(entityToDelete);
        assertNotNull(bolletteElettricitaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bolletteElettricitaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteElettricitaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<BolletteElettricitaEntity> aList = StreamSupport
                .stream(bolletteElettricitaService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        BolletteElettricitaEntity entityToDelete = new BolletteElettricitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteElettricitaEntity entitySaved = bolletteElettricitaService.save(entityToDelete);
        assertNotNull(bolletteElettricitaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<BolletteElettricitaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        bolletteElettricitaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteElettricitaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bolletteElettricitaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bolletteElettricitaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            bolletteElettricitaService.deleteAll(bolletteElettricitaService.findAll());

            assertTrue(StreamSupport.stream(bolletteElettricitaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        BolletteElettricitaEntity entityToDelete = new BolletteElettricitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteElettricitaEntity entitySaved = bolletteElettricitaService.save(entityToDelete);
        assertNotNull(bolletteElettricitaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        bolletteElettricitaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteElettricitaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bolletteElettricitaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bolletteElettricitaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            bolletteElettricitaService.deleteAll(bolletteElettricitaService.findAll());
            assertTrue(StreamSupport.stream(bolletteElettricitaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}