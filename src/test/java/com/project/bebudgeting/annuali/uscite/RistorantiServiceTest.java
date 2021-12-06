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

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.RistorantiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.RistorantiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RistorantiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    RistorantiService ristorantiService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        RistorantiEntity entityToDelete = new RistorantiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RistorantiEntity entitySaved = ristorantiService.save(entityToDelete);
        assertNotNull(ristorantiService.findById(entitySaved.getId()).get());
        assertTrue(ristorantiService.count() != 0);

        ristorantiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        RistorantiEntity entityToSave = new RistorantiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(ristorantiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(ristorantiService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        RistorantiEntity entityToSave = new RistorantiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(ristorantiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(ristorantiService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        RistorantiEntity entityToSave = new RistorantiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(ristorantiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(ristorantiService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        RistorantiEntity entityToSave = new RistorantiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(ristorantiService.save(entityToSave) != null);

        assertTrue(ristorantiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        RistorantiEntity entityToSave = new RistorantiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(ristorantiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        RistorantiEntity entityToDelete = new RistorantiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RistorantiEntity entitySaved = ristorantiService.save(entityToDelete);
        assertNotNull(ristorantiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        ristorantiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            ristorantiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        RistorantiEntity entityToDelete = new RistorantiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RistorantiEntity entitySaved = ristorantiService.save(entityToDelete);
        assertNotNull(ristorantiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        ristorantiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            ristorantiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<RistorantiEntity> aList = StreamSupport
                .stream(ristorantiService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        RistorantiEntity entityToDelete = new RistorantiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RistorantiEntity entitySaved = ristorantiService.save(entityToDelete);
        assertNotNull(ristorantiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<RistorantiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        ristorantiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            ristorantiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(ristorantiService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(ristorantiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            ristorantiService.deleteAll(ristorantiService.findAll());

            assertTrue(StreamSupport.stream(ristorantiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        RistorantiEntity entityToDelete = new RistorantiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RistorantiEntity entitySaved = ristorantiService.save(entityToDelete);
        assertNotNull(ristorantiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        ristorantiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            ristorantiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(ristorantiService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(ristorantiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            ristorantiService.deleteAll(ristorantiService.findAll());
            assertTrue(StreamSupport.stream(ristorantiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
