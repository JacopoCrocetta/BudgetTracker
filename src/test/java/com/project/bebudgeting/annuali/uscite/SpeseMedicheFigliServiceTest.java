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

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.SpeseMedicheFigliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.SpeseMedicheFigliService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpeseMedicheFigliServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    SpeseMedicheFigliService speseMedicheFigliService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        SpeseMedicheFigliEntity entityToDelete = new SpeseMedicheFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SpeseMedicheFigliEntity entitySaved = speseMedicheFigliService.save(entityToDelete);
        assertNotNull(speseMedicheFigliService.findById(entitySaved.getId()).get());
        assertTrue(speseMedicheFigliService.count() != 0);

        speseMedicheFigliService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        SpeseMedicheFigliEntity entityToSave = new SpeseMedicheFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(speseMedicheFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(speseMedicheFigliService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        SpeseMedicheFigliEntity entityToSave = new SpeseMedicheFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(speseMedicheFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(speseMedicheFigliService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        SpeseMedicheFigliEntity entityToSave = new SpeseMedicheFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(speseMedicheFigliService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(speseMedicheFigliService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        SpeseMedicheFigliEntity entityToSave = new SpeseMedicheFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(speseMedicheFigliService.save(entityToSave) != null);

        assertTrue(speseMedicheFigliService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        SpeseMedicheFigliEntity entityToSave = new SpeseMedicheFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(speseMedicheFigliService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        SpeseMedicheFigliEntity entityToDelete = new SpeseMedicheFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SpeseMedicheFigliEntity entitySaved = speseMedicheFigliService.save(entityToDelete);
        assertNotNull(speseMedicheFigliService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        speseMedicheFigliService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            speseMedicheFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        SpeseMedicheFigliEntity entityToDelete = new SpeseMedicheFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SpeseMedicheFigliEntity entitySaved = speseMedicheFigliService.save(entityToDelete);
        assertNotNull(speseMedicheFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        speseMedicheFigliService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            speseMedicheFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<SpeseMedicheFigliEntity> aList = StreamSupport
                .stream(speseMedicheFigliService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        SpeseMedicheFigliEntity entityToDelete = new SpeseMedicheFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SpeseMedicheFigliEntity entitySaved = speseMedicheFigliService.save(entityToDelete);
        assertNotNull(speseMedicheFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<SpeseMedicheFigliEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        speseMedicheFigliService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            speseMedicheFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(speseMedicheFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(speseMedicheFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            speseMedicheFigliService.deleteAll(speseMedicheFigliService.findAll());

            assertTrue(StreamSupport.stream(speseMedicheFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        SpeseMedicheFigliEntity entityToDelete = new SpeseMedicheFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SpeseMedicheFigliEntity entitySaved = speseMedicheFigliService.save(entityToDelete);
        assertNotNull(speseMedicheFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        speseMedicheFigliService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            speseMedicheFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(speseMedicheFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(speseMedicheFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            speseMedicheFigliService.deleteAll(speseMedicheFigliService.findAll());
            assertTrue(StreamSupport.stream(speseMedicheFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
