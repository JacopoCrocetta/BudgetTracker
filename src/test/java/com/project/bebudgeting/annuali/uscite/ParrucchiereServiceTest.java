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

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.ParrucchiereEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.ParrucchiereService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ParrucchiereServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    ParrucchiereService parrucchiereService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        ParrucchiereEntity entityToDelete = new ParrucchiereEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ParrucchiereEntity entitySaved = parrucchiereService.save(entityToDelete);
        assertNotNull(parrucchiereService.findById(entitySaved.getId()).get());
        assertTrue(parrucchiereService.count() != 0);

        parrucchiereService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        ParrucchiereEntity entityToSave = new ParrucchiereEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(parrucchiereService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(parrucchiereService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        ParrucchiereEntity entityToSave = new ParrucchiereEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(parrucchiereService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(parrucchiereService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        ParrucchiereEntity entityToSave = new ParrucchiereEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(parrucchiereService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(parrucchiereService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        ParrucchiereEntity entityToSave = new ParrucchiereEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(parrucchiereService.save(entityToSave) != null);

        assertTrue(parrucchiereService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        ParrucchiereEntity entityToSave = new ParrucchiereEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(parrucchiereService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        ParrucchiereEntity entityToDelete = new ParrucchiereEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ParrucchiereEntity entitySaved = parrucchiereService.save(entityToDelete);
        assertNotNull(parrucchiereService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        parrucchiereService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            parrucchiereService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        ParrucchiereEntity entityToDelete = new ParrucchiereEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ParrucchiereEntity entitySaved = parrucchiereService.save(entityToDelete);
        assertNotNull(parrucchiereService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        parrucchiereService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            parrucchiereService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<ParrucchiereEntity> aList = StreamSupport
                .stream(parrucchiereService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        ParrucchiereEntity entityToDelete = new ParrucchiereEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ParrucchiereEntity entitySaved = parrucchiereService.save(entityToDelete);
        assertNotNull(parrucchiereService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<ParrucchiereEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        parrucchiereService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            parrucchiereService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(parrucchiereService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(parrucchiereService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            parrucchiereService.deleteAll(parrucchiereService.findAll());

            assertTrue(StreamSupport.stream(parrucchiereService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        ParrucchiereEntity entityToDelete = new ParrucchiereEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ParrucchiereEntity entitySaved = parrucchiereService.save(entityToDelete);
        assertNotNull(parrucchiereService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        parrucchiereService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            parrucchiereService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(parrucchiereService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(parrucchiereService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            parrucchiereService.deleteAll(parrucchiereService.findAll());
            assertTrue(StreamSupport.stream(parrucchiereService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
