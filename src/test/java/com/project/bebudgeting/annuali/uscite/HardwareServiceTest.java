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

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HardwareEntity;
import com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice.HardwareService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HardwareServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    HardwareService hardwareService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        HardwareEntity entityToDelete = new HardwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HardwareEntity entitySaved = hardwareService.save(entityToDelete);
        assertNotNull(hardwareService.findById(entitySaved.getId()).get());
        assertTrue(hardwareService.count() != 0);

        hardwareService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        HardwareEntity entityToSave = new HardwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(hardwareService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(hardwareService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        HardwareEntity entityToSave = new HardwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(hardwareService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(hardwareService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        HardwareEntity entityToSave = new HardwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(hardwareService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(hardwareService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        HardwareEntity entityToSave = new HardwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(hardwareService.save(entityToSave) != null);

        assertTrue(hardwareService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        HardwareEntity entityToSave = new HardwareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(hardwareService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        HardwareEntity entityToDelete = new HardwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HardwareEntity entitySaved = hardwareService.save(entityToDelete);
        assertNotNull(hardwareService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        hardwareService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            hardwareService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        HardwareEntity entityToDelete = new HardwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HardwareEntity entitySaved = hardwareService.save(entityToDelete);
        assertNotNull(hardwareService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        hardwareService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            hardwareService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<HardwareEntity> aList = StreamSupport
                .stream(hardwareService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        HardwareEntity entityToDelete = new HardwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HardwareEntity entitySaved = hardwareService.save(entityToDelete);
        assertNotNull(hardwareService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<HardwareEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        hardwareService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            hardwareService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(hardwareService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(hardwareService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            hardwareService.deleteAll(hardwareService.findAll());

            assertTrue(StreamSupport.stream(hardwareService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        HardwareEntity entityToDelete = new HardwareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HardwareEntity entitySaved = hardwareService.save(entityToDelete);
        assertNotNull(hardwareService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        hardwareService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            hardwareService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(hardwareService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(hardwareService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            hardwareService.deleteAll(hardwareService.findAll());
            assertTrue(StreamSupport.stream(hardwareService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
