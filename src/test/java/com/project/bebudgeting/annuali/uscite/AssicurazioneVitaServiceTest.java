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

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice.AssicurazioneVitaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssicurazioneVitaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AssicurazioneVitaService assicurazioneVitaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AssicurazioneVitaEntity entityToDelete = new AssicurazioneVitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneVitaEntity entitySaved = assicurazioneVitaService.save(entityToDelete);
        assertNotNull(assicurazioneVitaService.findById(entitySaved.getId()).get());
        assertTrue(assicurazioneVitaService.count() != 0);

        assicurazioneVitaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AssicurazioneVitaEntity entityToSave = new AssicurazioneVitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneVitaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(assicurazioneVitaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AssicurazioneVitaEntity entityToSave = new AssicurazioneVitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneVitaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(assicurazioneVitaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AssicurazioneVitaEntity entityToSave = new AssicurazioneVitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneVitaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(assicurazioneVitaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AssicurazioneVitaEntity entityToSave = new AssicurazioneVitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneVitaService.save(entityToSave) != null);

        assertTrue(assicurazioneVitaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AssicurazioneVitaEntity entityToSave = new AssicurazioneVitaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(assicurazioneVitaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AssicurazioneVitaEntity entityToDelete = new AssicurazioneVitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneVitaEntity entitySaved = assicurazioneVitaService.save(entityToDelete);
        assertNotNull(assicurazioneVitaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        assicurazioneVitaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneVitaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AssicurazioneVitaEntity entityToDelete = new AssicurazioneVitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneVitaEntity entitySaved = assicurazioneVitaService.save(entityToDelete);
        assertNotNull(assicurazioneVitaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        assicurazioneVitaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneVitaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AssicurazioneVitaEntity> aList = StreamSupport
                .stream(assicurazioneVitaService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AssicurazioneVitaEntity entityToDelete = new AssicurazioneVitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneVitaEntity entitySaved = assicurazioneVitaService.save(entityToDelete);
        assertNotNull(assicurazioneVitaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AssicurazioneVitaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        assicurazioneVitaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneVitaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(assicurazioneVitaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(assicurazioneVitaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            assicurazioneVitaService.deleteAll(assicurazioneVitaService.findAll());

            assertTrue(StreamSupport.stream(assicurazioneVitaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AssicurazioneVitaEntity entityToDelete = new AssicurazioneVitaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneVitaEntity entitySaved = assicurazioneVitaService.save(entityToDelete);
        assertNotNull(assicurazioneVitaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        assicurazioneVitaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneVitaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(assicurazioneVitaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(assicurazioneVitaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            assicurazioneVitaService.deleteAll(assicurazioneVitaService.findAll());
            assertTrue(StreamSupport.stream(assicurazioneVitaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
