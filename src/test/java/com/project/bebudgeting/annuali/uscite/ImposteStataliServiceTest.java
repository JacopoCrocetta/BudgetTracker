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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteStataliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.ImposteStataliService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ImposteStataliServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    ImposteStataliService imposteStataliService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        ImposteStataliEntity entityToDelete = new ImposteStataliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteStataliEntity entitySaved = imposteStataliService.save(entityToDelete);
        assertNotNull(imposteStataliService.findById(entitySaved.getId()).get());
        assertTrue(imposteStataliService.count() != 0);

        imposteStataliService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        ImposteStataliEntity entityToSave = new ImposteStataliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(imposteStataliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(imposteStataliService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        ImposteStataliEntity entityToSave = new ImposteStataliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(imposteStataliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(imposteStataliService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        ImposteStataliEntity entityToSave = new ImposteStataliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(imposteStataliService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(imposteStataliService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        ImposteStataliEntity entityToSave = new ImposteStataliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(imposteStataliService.save(entityToSave) != null);

        assertTrue(imposteStataliService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        ImposteStataliEntity entityToSave = new ImposteStataliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(imposteStataliService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        ImposteStataliEntity entityToDelete = new ImposteStataliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteStataliEntity entitySaved = imposteStataliService.save(entityToDelete);
        assertNotNull(imposteStataliService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        imposteStataliService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            imposteStataliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        ImposteStataliEntity entityToDelete = new ImposteStataliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteStataliEntity entitySaved = imposteStataliService.save(entityToDelete);
        assertNotNull(imposteStataliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        imposteStataliService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            imposteStataliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<ImposteStataliEntity> aList = StreamSupport.stream(imposteStataliService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        ImposteStataliEntity entityToDelete = new ImposteStataliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteStataliEntity entitySaved = imposteStataliService.save(entityToDelete);
        assertNotNull(imposteStataliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<ImposteStataliEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        imposteStataliService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            imposteStataliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(imposteStataliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(imposteStataliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            imposteStataliService.deleteAll(imposteStataliService.findAll());

            assertTrue(StreamSupport.stream(imposteStataliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        ImposteStataliEntity entityToDelete = new ImposteStataliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteStataliEntity entitySaved = imposteStataliService.save(entityToDelete);
        assertNotNull(imposteStataliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        imposteStataliService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            imposteStataliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(imposteStataliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(imposteStataliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            imposteStataliService.deleteAll(imposteStataliService.findAll());
            assertTrue(StreamSupport.stream(imposteStataliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
