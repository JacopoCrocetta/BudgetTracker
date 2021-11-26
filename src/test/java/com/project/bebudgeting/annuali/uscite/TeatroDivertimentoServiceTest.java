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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.TeatroEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.TeatroService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TeatroDivertimentoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    TeatroService teatroService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        TeatroEntity entityToDelete = new TeatroEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TeatroEntity entitySaved = teatroService.save(entityToDelete);
        assertNotNull(teatroService.findById(entitySaved.getId()).get());
        assertTrue(teatroService.count() != 0);

        teatroService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        TeatroEntity entityToSave = new TeatroEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(teatroService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(teatroService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        TeatroEntity entityToSave = new TeatroEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(teatroService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(teatroService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        TeatroEntity entityToSave = new TeatroEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(teatroService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(teatroService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        TeatroEntity entityToSave = new TeatroEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(teatroService.save(entityToSave) != null);

        assertTrue(teatroService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        TeatroEntity entityToSave = new TeatroEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(teatroService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        TeatroEntity entityToDelete = new TeatroEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TeatroEntity entitySaved = teatroService.save(entityToDelete);
        assertNotNull(teatroService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        teatroService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            teatroService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        TeatroEntity entityToDelete = new TeatroEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TeatroEntity entitySaved = teatroService.save(entityToDelete);
        assertNotNull(teatroService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        teatroService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            teatroService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<TeatroEntity> aList = StreamSupport.stream(teatroService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        TeatroEntity entityToDelete = new TeatroEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TeatroEntity entitySaved = teatroService.save(entityToDelete);
        assertNotNull(teatroService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<TeatroEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        teatroService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            teatroService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(teatroService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(teatroService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            teatroService.deleteAll(teatroService.findAll());

            assertTrue(StreamSupport.stream(teatroService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        TeatroEntity entityToDelete = new TeatroEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        TeatroEntity entitySaved = teatroService.save(entityToDelete);
        assertNotNull(teatroService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        teatroService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            teatroService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(teatroService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(teatroService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            teatroService.deleteAll(teatroService.findAll());
            assertTrue(StreamSupport.stream(teatroService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
