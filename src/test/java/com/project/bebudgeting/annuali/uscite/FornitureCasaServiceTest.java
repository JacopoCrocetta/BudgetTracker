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

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.FornitureCasaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.FornitureCasaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FornitureCasaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    FornitureCasaService fornitureCasaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        FornitureCasaEntity entityToDelete = new FornitureCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureCasaEntity entitySaved = fornitureCasaService.save(entityToDelete);
        assertNotNull(fornitureCasaService.findById(entitySaved.getId()).get());
        assertTrue(fornitureCasaService.count() != 0);

        fornitureCasaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        FornitureCasaEntity entityToSave = new FornitureCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fornitureCasaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(fornitureCasaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        FornitureCasaEntity entityToSave = new FornitureCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fornitureCasaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(fornitureCasaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        FornitureCasaEntity entityToSave = new FornitureCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fornitureCasaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(fornitureCasaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        FornitureCasaEntity entityToSave = new FornitureCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fornitureCasaService.save(entityToSave) != null);

        assertTrue(fornitureCasaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        FornitureCasaEntity entityToSave = new FornitureCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(fornitureCasaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        FornitureCasaEntity entityToDelete = new FornitureCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureCasaEntity entitySaved = fornitureCasaService.save(entityToDelete);
        assertNotNull(fornitureCasaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        fornitureCasaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fornitureCasaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        FornitureCasaEntity entityToDelete = new FornitureCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureCasaEntity entitySaved = fornitureCasaService.save(entityToDelete);
        assertNotNull(fornitureCasaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        fornitureCasaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fornitureCasaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<FornitureCasaEntity> aList = StreamSupport.stream(fornitureCasaService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        FornitureCasaEntity entityToDelete = new FornitureCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureCasaEntity entitySaved = fornitureCasaService.save(entityToDelete);
        assertNotNull(fornitureCasaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<FornitureCasaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        fornitureCasaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fornitureCasaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(fornitureCasaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(fornitureCasaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            fornitureCasaService.deleteAll(fornitureCasaService.findAll());

            assertTrue(StreamSupport.stream(fornitureCasaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        FornitureCasaEntity entityToDelete = new FornitureCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FornitureCasaEntity entitySaved = fornitureCasaService.save(entityToDelete);
        assertNotNull(fornitureCasaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        fornitureCasaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fornitureCasaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(fornitureCasaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(fornitureCasaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            fornitureCasaService.deleteAll(fornitureCasaService.findAll());
            assertTrue(StreamSupport.stream(fornitureCasaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
