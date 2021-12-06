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

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LibriIstruzioneEntity;
import com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice.LibriIstruzioneService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LibriIstruzioneServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    LibriIstruzioneService libriIstruzioneService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        LibriIstruzioneEntity entityToDelete = new LibriIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriIstruzioneEntity entitySaved = libriIstruzioneService.save(entityToDelete);
        assertNotNull(libriIstruzioneService.findById(entitySaved.getId()).get());
        assertTrue(libriIstruzioneService.count() != 0);

        libriIstruzioneService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        LibriIstruzioneEntity entityToSave = new LibriIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(libriIstruzioneService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(libriIstruzioneService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        LibriIstruzioneEntity entityToSave = new LibriIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(libriIstruzioneService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(libriIstruzioneService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        LibriIstruzioneEntity entityToSave = new LibriIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(libriIstruzioneService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(libriIstruzioneService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        LibriIstruzioneEntity entityToSave = new LibriIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(libriIstruzioneService.save(entityToSave) != null);

        assertTrue(libriIstruzioneService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        LibriIstruzioneEntity entityToSave = new LibriIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(libriIstruzioneService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        LibriIstruzioneEntity entityToDelete = new LibriIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriIstruzioneEntity entitySaved = libriIstruzioneService.save(entityToDelete);
        assertNotNull(libriIstruzioneService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        libriIstruzioneService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            libriIstruzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        LibriIstruzioneEntity entityToDelete = new LibriIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriIstruzioneEntity entitySaved = libriIstruzioneService.save(entityToDelete);
        assertNotNull(libriIstruzioneService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        libriIstruzioneService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            libriIstruzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<LibriIstruzioneEntity> aList = StreamSupport
                .stream(libriIstruzioneService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        LibriIstruzioneEntity entityToDelete = new LibriIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriIstruzioneEntity entitySaved = libriIstruzioneService.save(entityToDelete);
        assertNotNull(libriIstruzioneService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<LibriIstruzioneEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        libriIstruzioneService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            libriIstruzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(libriIstruzioneService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(libriIstruzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            libriIstruzioneService.deleteAll(libriIstruzioneService.findAll());

            assertTrue(StreamSupport.stream(libriIstruzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        LibriIstruzioneEntity entityToDelete = new LibriIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        LibriIstruzioneEntity entitySaved = libriIstruzioneService.save(entityToDelete);
        assertNotNull(libriIstruzioneService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        libriIstruzioneService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            libriIstruzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(libriIstruzioneService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(libriIstruzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            libriIstruzioneService.deleteAll(libriIstruzioneService.findAll());
            assertTrue(StreamSupport.stream(libriIstruzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
