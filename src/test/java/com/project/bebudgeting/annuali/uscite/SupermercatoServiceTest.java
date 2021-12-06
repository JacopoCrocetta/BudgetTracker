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

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.SupermercatoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.SupermercatoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SupermercatoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    SupermercatoService supermercatoService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        SupermercatoEntity entityToDelete = new SupermercatoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SupermercatoEntity entitySaved = supermercatoService.save(entityToDelete);
        assertNotNull(supermercatoService.findById(entitySaved.getId()).get());
        assertTrue(supermercatoService.count() != 0);

        supermercatoService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        SupermercatoEntity entityToSave = new SupermercatoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(supermercatoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(supermercatoService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        SupermercatoEntity entityToSave = new SupermercatoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(supermercatoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(supermercatoService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        SupermercatoEntity entityToSave = new SupermercatoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(supermercatoService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(supermercatoService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        SupermercatoEntity entityToSave = new SupermercatoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(supermercatoService.save(entityToSave) != null);

        assertTrue(supermercatoService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        SupermercatoEntity entityToSave = new SupermercatoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(supermercatoService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        SupermercatoEntity entityToDelete = new SupermercatoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SupermercatoEntity entitySaved = supermercatoService.save(entityToDelete);
        assertNotNull(supermercatoService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        supermercatoService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            supermercatoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        SupermercatoEntity entityToDelete = new SupermercatoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SupermercatoEntity entitySaved = supermercatoService.save(entityToDelete);
        assertNotNull(supermercatoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        supermercatoService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            supermercatoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<SupermercatoEntity> aList = StreamSupport.stream(supermercatoService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        SupermercatoEntity entityToDelete = new SupermercatoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SupermercatoEntity entitySaved = supermercatoService.save(entityToDelete);
        assertNotNull(supermercatoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<SupermercatoEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        supermercatoService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            supermercatoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(supermercatoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(supermercatoService.findAll().spliterator(), false)
                    .collect(Collectors.toList())
                    .size() == 0);
        } else {
            supermercatoService.deleteAll(supermercatoService.findAll());

            assertTrue(StreamSupport.stream(supermercatoService.findAll().spliterator(), false)
                    .collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        SupermercatoEntity entityToDelete = new SupermercatoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        SupermercatoEntity entitySaved = supermercatoService.save(entityToDelete);
        assertNotNull(supermercatoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        supermercatoService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            supermercatoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(supermercatoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(supermercatoService.findAll().spliterator(), false)
                    .collect(Collectors.toList())
                    .size() == 0);
        } else {
            supermercatoService.deleteAll(supermercatoService.findAll());
            assertTrue(StreamSupport.stream(supermercatoService.findAll().spliterator(), false)
                    .collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
