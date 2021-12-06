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

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.AltroIstruzioneEntity;
import com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice.AltroIstruzioneService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltroIstruzioneServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltroIstruzioneService altroIstruzioneService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltroIstruzioneEntity entityToDelete = new AltroIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroIstruzioneEntity entitySaved = altroIstruzioneService.save(entityToDelete);
        assertNotNull(altroIstruzioneService.findById(entitySaved.getId()).get());
        assertTrue(altroIstruzioneService.count() != 0);

        altroIstruzioneService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltroIstruzioneEntity entityToSave = new AltroIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroIstruzioneService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroIstruzioneService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroIstruzioneEntity entityToSave = new AltroIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroIstruzioneService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroIstruzioneService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroIstruzioneEntity entityToSave = new AltroIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroIstruzioneService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altroIstruzioneService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltroIstruzioneEntity entityToSave = new AltroIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroIstruzioneService.save(entityToSave) != null);

        assertTrue(altroIstruzioneService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltroIstruzioneEntity entityToSave = new AltroIstruzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altroIstruzioneService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltroIstruzioneEntity entityToDelete = new AltroIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroIstruzioneEntity entitySaved = altroIstruzioneService.save(entityToDelete);
        assertNotNull(altroIstruzioneService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroIstruzioneService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroIstruzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltroIstruzioneEntity entityToDelete = new AltroIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroIstruzioneEntity entitySaved = altroIstruzioneService.save(entityToDelete);
        assertNotNull(altroIstruzioneService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroIstruzioneService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroIstruzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltroIstruzioneEntity> aList = StreamSupport
                .stream(altroIstruzioneService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltroIstruzioneEntity entityToDelete = new AltroIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroIstruzioneEntity entitySaved = altroIstruzioneService.save(entityToDelete);
        assertNotNull(altroIstruzioneService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltroIstruzioneEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altroIstruzioneService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroIstruzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroIstruzioneService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroIstruzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroIstruzioneService.deleteAll(altroIstruzioneService.findAll());

            assertTrue(StreamSupport.stream(altroIstruzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltroIstruzioneEntity entityToDelete = new AltroIstruzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroIstruzioneEntity entitySaved = altroIstruzioneService.save(entityToDelete);
        assertNotNull(altroIstruzioneService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altroIstruzioneService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroIstruzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroIstruzioneService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroIstruzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroIstruzioneService.deleteAll(altroIstruzioneService.findAll());
            assertTrue(StreamSupport.stream(altroIstruzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
