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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteLocaliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.ImposteLocaliService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ImposteLocaliServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    ImposteLocaliService imposteLocaliService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        ImposteLocaliEntity entityToDelete = new ImposteLocaliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteLocaliEntity entitySaved = imposteLocaliService.save(entityToDelete);
        assertNotNull(imposteLocaliService.findById(entitySaved.getId()).get());
        assertTrue(imposteLocaliService.count() != 0);

        imposteLocaliService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        ImposteLocaliEntity entityToSave = new ImposteLocaliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(imposteLocaliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(imposteLocaliService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        ImposteLocaliEntity entityToSave = new ImposteLocaliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(imposteLocaliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(imposteLocaliService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        ImposteLocaliEntity entityToSave = new ImposteLocaliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(imposteLocaliService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(imposteLocaliService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        ImposteLocaliEntity entityToSave = new ImposteLocaliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(imposteLocaliService.save(entityToSave) != null);

        assertTrue(imposteLocaliService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        ImposteLocaliEntity entityToSave = new ImposteLocaliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(imposteLocaliService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        ImposteLocaliEntity entityToDelete = new ImposteLocaliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteLocaliEntity entitySaved = imposteLocaliService.save(entityToDelete);
        assertNotNull(imposteLocaliService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        imposteLocaliService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            imposteLocaliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        ImposteLocaliEntity entityToDelete = new ImposteLocaliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteLocaliEntity entitySaved = imposteLocaliService.save(entityToDelete);
        assertNotNull(imposteLocaliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        imposteLocaliService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            imposteLocaliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<ImposteLocaliEntity> aList = StreamSupport.stream(imposteLocaliService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        ImposteLocaliEntity entityToDelete = new ImposteLocaliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteLocaliEntity entitySaved = imposteLocaliService.save(entityToDelete);
        assertNotNull(imposteLocaliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<ImposteLocaliEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        imposteLocaliService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            imposteLocaliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(imposteLocaliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(imposteLocaliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            imposteLocaliService.deleteAll(imposteLocaliService.findAll());

            assertTrue(StreamSupport.stream(imposteLocaliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        ImposteLocaliEntity entityToDelete = new ImposteLocaliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ImposteLocaliEntity entitySaved = imposteLocaliService.save(entityToDelete);
        assertNotNull(imposteLocaliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        imposteLocaliService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            imposteLocaliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(imposteLocaliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(imposteLocaliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            imposteLocaliService.deleteAll(imposteLocaliService.findAll());
            assertTrue(StreamSupport.stream(imposteLocaliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
