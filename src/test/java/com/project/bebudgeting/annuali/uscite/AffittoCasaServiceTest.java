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

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.AffittoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.AffittoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AffittoCasaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AffittoService affittoService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AffittoEntity entityToDelete = new AffittoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AffittoEntity entitySaved = affittoService.save(entityToDelete);
        assertNotNull(affittoService.findById(entitySaved.getId()).get());
        assertTrue(affittoService.count() != 0);

        affittoService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AffittoEntity entityToSave = new AffittoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(affittoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(affittoService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AffittoEntity entityToSave = new AffittoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(affittoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(affittoService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AffittoEntity entityToSave = new AffittoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(affittoService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(affittoService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AffittoEntity entityToSave = new AffittoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(affittoService.save(entityToSave) != null);

        assertTrue(affittoService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AffittoEntity entityToSave = new AffittoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(affittoService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AffittoEntity entityToDelete = new AffittoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AffittoEntity entitySaved = affittoService.save(entityToDelete);
        assertNotNull(affittoService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        affittoService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            affittoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AffittoEntity entityToDelete = new AffittoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AffittoEntity entitySaved = affittoService.save(entityToDelete);
        assertNotNull(affittoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        affittoService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            affittoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AffittoEntity> aList = StreamSupport.stream(affittoService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AffittoEntity entityToDelete = new AffittoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AffittoEntity entitySaved = affittoService.save(entityToDelete);
        assertNotNull(affittoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AffittoEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        affittoService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            affittoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(affittoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(affittoService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            affittoService.deleteAll(affittoService.findAll());

            assertTrue(StreamSupport.stream(affittoService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AffittoEntity entityToDelete = new AffittoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AffittoEntity entitySaved = affittoService.save(entityToDelete);
        assertNotNull(affittoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        affittoService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            affittoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(affittoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(affittoService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            affittoService.deleteAll(affittoService.findAll());
            assertTrue(StreamSupport.stream(affittoService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
