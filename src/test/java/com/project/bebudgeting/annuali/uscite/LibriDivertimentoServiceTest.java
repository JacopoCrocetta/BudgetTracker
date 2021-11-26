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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.LibriDivertimentoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.LibriDivertimentoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LibriDivertimentoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    LibriDivertimentoService libriDivertimentoService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        LibriDivertimentoEntity entityToDelete = new LibriDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriDivertimentoEntity entitySaved = libriDivertimentoService.save(entityToDelete);
        assertNotNull(libriDivertimentoService.findById(entitySaved.getId()).get());
        assertTrue(libriDivertimentoService.count() != 0);

        libriDivertimentoService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        LibriDivertimentoEntity entityToSave = new LibriDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(libriDivertimentoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(libriDivertimentoService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        LibriDivertimentoEntity entityToSave = new LibriDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(libriDivertimentoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(libriDivertimentoService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        LibriDivertimentoEntity entityToSave = new LibriDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(libriDivertimentoService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(libriDivertimentoService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        LibriDivertimentoEntity entityToSave = new LibriDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(libriDivertimentoService.save(entityToSave) != null);

        assertTrue(libriDivertimentoService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        LibriDivertimentoEntity entityToSave = new LibriDivertimentoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(libriDivertimentoService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        LibriDivertimentoEntity entityToDelete = new LibriDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriDivertimentoEntity entitySaved = libriDivertimentoService.save(entityToDelete);
        assertNotNull(libriDivertimentoService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        libriDivertimentoService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            libriDivertimentoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        LibriDivertimentoEntity entityToDelete = new LibriDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriDivertimentoEntity entitySaved = libriDivertimentoService.save(entityToDelete);
        assertNotNull(libriDivertimentoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        libriDivertimentoService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            libriDivertimentoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<LibriDivertimentoEntity> aList = StreamSupport
                .stream(libriDivertimentoService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        LibriDivertimentoEntity entityToDelete = new LibriDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriDivertimentoEntity entitySaved = libriDivertimentoService.save(entityToDelete);
        assertNotNull(libriDivertimentoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<LibriDivertimentoEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        libriDivertimentoService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            libriDivertimentoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(libriDivertimentoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(libriDivertimentoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            libriDivertimentoService.deleteAll(libriDivertimentoService.findAll());

            assertTrue(StreamSupport.stream(libriDivertimentoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        LibriDivertimentoEntity entityToDelete = new LibriDivertimentoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriDivertimentoEntity entitySaved = libriDivertimentoService.save(entityToDelete);
        assertNotNull(libriDivertimentoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        libriDivertimentoService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            libriDivertimentoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(libriDivertimentoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(libriDivertimentoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            libriDivertimentoService.deleteAll(libriDivertimentoService.findAll());
            assertTrue(StreamSupport.stream(libriDivertimentoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
