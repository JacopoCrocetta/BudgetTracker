package com.project.bebudgeting.annuali.entrate;

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

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.AltroEService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltroEServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltroEService altroEService;

    // COUNT TEST
    @Test
    void countAllAltroSalarioEntitiesTest() {
        AltroAltreEntrateEntity entityToDelete = new AltroAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizioneEntrata(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAltreEntrateEntity entitySaved = altroEService.save(entityToDelete);
        assertNotNull(altroEService.findById(entitySaved.getId()).get());
        assertTrue(altroEService.count() != 0);

        altroEService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltroAltreEntrateEntity entityToSave = new AltroAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizioneEntrata(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroEService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroEService.findAll() != null);
    }

    @Test
    void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroAltreEntrateEntity entityToSave = new AltroAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizioneEntrata(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroEService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroEService.findById(entityToSave.getId()) != null);
    }

    @Test
    void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroAltreEntrateEntity entityToSave = new AltroAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizioneEntrata(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroEService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altroEService.findAllById(ids) != null);
    }

    @Test
    void findById() {
        // SAVE ONE ENTITY
        AltroAltreEntrateEntity entityToSave = new AltroAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizioneEntrata(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroEService.save(entityToSave) != null);

        assertTrue(altroEService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltroAltreEntrateEntity entityToSave = new AltroAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizioneEntrata(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altroEService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltroAltreEntrateEntity entityToDelete = new AltroAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizioneEntrata(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAltreEntrateEntity entitySaved = altroEService.save(entityToDelete);
        assertNotNull(altroEService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroEService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroEService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltroAltreEntrateEntity entityToDelete = new AltroAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizioneEntrata(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAltreEntrateEntity entitySaved = altroEService.save(entityToDelete);
        assertNotNull(altroEService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroEService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroEService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltroAltreEntrateEntity> aIterable = StreamSupport.stream(altroEService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aIterable.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltroAltreEntrateEntity entityToDelete = new AltroAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizioneEntrata(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAltreEntrateEntity entitySaved = altroEService.save(entityToDelete);
        assertNotNull(altroEService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltroAltreEntrateEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altroEService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroEService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroEService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroEService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            altroEService.deleteAll(altroEService.findAll());

            assertTrue(StreamSupport.stream(altroEService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    void deleteAllByIdsTest() {
        AltroAltreEntrateEntity entityToDelete = new AltroAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizioneEntrata(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroAltreEntrateEntity entitySaved = altroEService.save(entityToDelete);
        assertNotNull(altroEService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altroEService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroEService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroEService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroEService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            altroEService.deleteAll(altroEService.findAll());

            assertTrue(StreamSupport.stream(altroEService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
