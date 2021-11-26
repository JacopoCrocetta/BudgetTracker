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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.AltroDivertimentoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.AltroDivertimentoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltroDivertimentoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltroDivertimentoService altroDivertimentoService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltroDivertimentoEntity entityToDelete = new AltroDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDivertimentoEntity entitySaved = altroDivertimentoService.save(entityToDelete);
        assertNotNull(altroDivertimentoService.findById(entitySaved.getId()).get());
        assertTrue(altroDivertimentoService.count() != 0);

        altroDivertimentoService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltroDivertimentoEntity entityToSave = new AltroDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroDivertimentoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroDivertimentoService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroDivertimentoEntity entityToSave = new AltroDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroDivertimentoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroDivertimentoService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroDivertimentoEntity entityToSave = new AltroDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroDivertimentoService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altroDivertimentoService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltroDivertimentoEntity entityToSave = new AltroDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroDivertimentoService.save(entityToSave) != null);

        assertTrue(altroDivertimentoService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltroDivertimentoEntity entityToSave = new AltroDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altroDivertimentoService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltroDivertimentoEntity entityToDelete = new AltroDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDivertimentoEntity entitySaved = altroDivertimentoService.save(entityToDelete);
        assertNotNull(altroDivertimentoService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroDivertimentoService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroDivertimentoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltroDivertimentoEntity entityToDelete = new AltroDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDivertimentoEntity entitySaved = altroDivertimentoService.save(entityToDelete);
        assertNotNull(altroDivertimentoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroDivertimentoService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroDivertimentoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltroDivertimentoEntity> aList = StreamSupport
                .stream(altroDivertimentoService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltroDivertimentoEntity entityToDelete = new AltroDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDivertimentoEntity entitySaved = altroDivertimentoService.save(entityToDelete);
        assertNotNull(altroDivertimentoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltroDivertimentoEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altroDivertimentoService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroDivertimentoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroDivertimentoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroDivertimentoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroDivertimentoService.deleteAll(altroDivertimentoService.findAll());

            assertTrue(StreamSupport.stream(altroDivertimentoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltroDivertimentoEntity entityToDelete = new AltroDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDivertimentoEntity entitySaved = altroDivertimentoService.save(entityToDelete);
        assertNotNull(altroDivertimentoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altroDivertimentoService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroDivertimentoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroDivertimentoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroDivertimentoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroDivertimentoService.deleteAll(altroDivertimentoService.findAll());
            assertTrue(StreamSupport.stream(altroDivertimentoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
