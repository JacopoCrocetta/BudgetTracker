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

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.SoftwareEntity;
import com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice.SoftwareService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SoftwareServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    SoftwareService softwareService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        SoftwareEntity entityToDelete = new SoftwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SoftwareEntity entitySaved = softwareService.save(entityToDelete);
        assertNotNull(softwareService.findById(entitySaved.getId()).get());
        assertTrue(softwareService.count() != 0);

        softwareService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        SoftwareEntity entityToSave = new SoftwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(softwareService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(softwareService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        SoftwareEntity entityToSave = new SoftwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(softwareService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(softwareService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        SoftwareEntity entityToSave = new SoftwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(softwareService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(softwareService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        SoftwareEntity entityToSave = new SoftwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(softwareService.save(entityToSave) != null);

        assertTrue(softwareService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        SoftwareEntity entityToSave = new SoftwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(softwareService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        SoftwareEntity entityToDelete = new SoftwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SoftwareEntity entitySaved = softwareService.save(entityToDelete);
        assertNotNull(softwareService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        softwareService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            softwareService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        SoftwareEntity entityToDelete = new SoftwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SoftwareEntity entitySaved = softwareService.save(entityToDelete);
        assertNotNull(softwareService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        softwareService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            softwareService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<SoftwareEntity> aList = StreamSupport
                .stream(softwareService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        SoftwareEntity entityToDelete = new SoftwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SoftwareEntity entitySaved = softwareService.save(entityToDelete);
        assertNotNull(softwareService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<SoftwareEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        softwareService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            softwareService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(softwareService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(softwareService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            softwareService.deleteAll(softwareService.findAll());

            assertTrue(StreamSupport.stream(softwareService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        SoftwareEntity entityToDelete = new SoftwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SoftwareEntity entitySaved = softwareService.save(entityToDelete);
        assertNotNull(softwareService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        softwareService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            softwareService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(softwareService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(softwareService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            softwareService.deleteAll(softwareService.findAll());
            assertTrue(StreamSupport.stream(softwareService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
