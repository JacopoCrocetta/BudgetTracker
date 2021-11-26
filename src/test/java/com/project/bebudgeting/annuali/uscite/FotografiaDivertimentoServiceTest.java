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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.FotografiaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.FotografiaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FotografiaDivertimentoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    FotografiaService fotografiaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        FotografiaEntity entityToDelete = new FotografiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FotografiaEntity entitySaved = fotografiaService.save(entityToDelete);
        assertNotNull(fotografiaService.findById(entitySaved.getId()).get());
        assertTrue(fotografiaService.count() != 0);

        fotografiaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        FotografiaEntity entityToSave = new FotografiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fotografiaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(fotografiaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        FotografiaEntity entityToSave = new FotografiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fotografiaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(fotografiaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        FotografiaEntity entityToSave = new FotografiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fotografiaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(fotografiaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        FotografiaEntity entityToSave = new FotografiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(fotografiaService.save(entityToSave) != null);

        assertTrue(fotografiaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        FotografiaEntity entityToSave = new FotografiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(fotografiaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        FotografiaEntity entityToDelete = new FotografiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FotografiaEntity entitySaved = fotografiaService.save(entityToDelete);
        assertNotNull(fotografiaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        fotografiaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fotografiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        FotografiaEntity entityToDelete = new FotografiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FotografiaEntity entitySaved = fotografiaService.save(entityToDelete);
        assertNotNull(fotografiaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        fotografiaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fotografiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<FotografiaEntity> aList = StreamSupport.stream(fotografiaService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        FotografiaEntity entityToDelete = new FotografiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FotografiaEntity entitySaved = fotografiaService.save(entityToDelete);
        assertNotNull(fotografiaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<FotografiaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        fotografiaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fotografiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(fotografiaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(fotografiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            fotografiaService.deleteAll(fotografiaService.findAll());

            assertTrue(StreamSupport.stream(fotografiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        FotografiaEntity entityToDelete = new FotografiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FotografiaEntity entitySaved = fotografiaService.save(entityToDelete);
        assertNotNull(fotografiaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        fotografiaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            fotografiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(fotografiaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(fotografiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            fotografiaService.deleteAll(fotografiaService.findAll());
            assertTrue(StreamSupport.stream(fotografiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}