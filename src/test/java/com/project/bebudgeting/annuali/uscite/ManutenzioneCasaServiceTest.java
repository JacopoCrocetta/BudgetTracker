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

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.ManutenzioneEntity;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.ManutenzioneService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ManutenzioneCasaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    ManutenzioneService manutenzioneService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        ManutenzioneEntity entityToDelete = new ManutenzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManutenzioneEntity entitySaved = manutenzioneService.save(entityToDelete);
        assertNotNull(manutenzioneService.findById(entitySaved.getId()).get());
        assertTrue(manutenzioneService.count() != 0);

        manutenzioneService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        ManutenzioneEntity entityToSave = new ManutenzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(manutenzioneService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(manutenzioneService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        ManutenzioneEntity entityToSave = new ManutenzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(manutenzioneService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(manutenzioneService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        ManutenzioneEntity entityToSave = new ManutenzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(manutenzioneService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(manutenzioneService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        ManutenzioneEntity entityToSave = new ManutenzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(manutenzioneService.save(entityToSave) != null);

        assertTrue(manutenzioneService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        ManutenzioneEntity entityToSave = new ManutenzioneEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(manutenzioneService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        ManutenzioneEntity entityToDelete = new ManutenzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManutenzioneEntity entitySaved = manutenzioneService.save(entityToDelete);
        assertNotNull(manutenzioneService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        manutenzioneService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            manutenzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        ManutenzioneEntity entityToDelete = new ManutenzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManutenzioneEntity entitySaved = manutenzioneService.save(entityToDelete);
        assertNotNull(manutenzioneService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        manutenzioneService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            manutenzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<ManutenzioneEntity> aList = StreamSupport.stream(manutenzioneService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        ManutenzioneEntity entityToDelete = new ManutenzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManutenzioneEntity entitySaved = manutenzioneService.save(entityToDelete);
        assertNotNull(manutenzioneService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<ManutenzioneEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        manutenzioneService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            manutenzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(manutenzioneService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(manutenzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            manutenzioneService.deleteAll(manutenzioneService.findAll());

            assertTrue(StreamSupport.stream(manutenzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        ManutenzioneEntity entityToDelete = new ManutenzioneEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManutenzioneEntity entitySaved = manutenzioneService.save(entityToDelete);
        assertNotNull(manutenzioneService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        manutenzioneService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            manutenzioneService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(manutenzioneService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(manutenzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {

            manutenzioneService.deleteAll(manutenzioneService.findAll());
            assertTrue(StreamSupport.stream(manutenzioneService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}