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

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice.AssicurazioneAutoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssicurazioneAutoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AssicurazioneAutoService assicurazioneAutoService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AssicurazioneAutoEntity entityToDelete = new AssicurazioneAutoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneAutoEntity entitySaved = assicurazioneAutoService.save(entityToDelete);
        assertNotNull(assicurazioneAutoService.findById(entitySaved.getId()).get());
        assertTrue(assicurazioneAutoService.count() != 0);

        assicurazioneAutoService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AssicurazioneAutoEntity entityToSave = new AssicurazioneAutoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneAutoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(assicurazioneAutoService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AssicurazioneAutoEntity entityToSave = new AssicurazioneAutoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneAutoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(assicurazioneAutoService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AssicurazioneAutoEntity entityToSave = new AssicurazioneAutoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneAutoService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(assicurazioneAutoService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AssicurazioneAutoEntity entityToSave = new AssicurazioneAutoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneAutoService.save(entityToSave) != null);

        assertTrue(assicurazioneAutoService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AssicurazioneAutoEntity entityToSave = new AssicurazioneAutoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(assicurazioneAutoService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AssicurazioneAutoEntity entityToDelete = new AssicurazioneAutoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneAutoEntity entitySaved = assicurazioneAutoService.save(entityToDelete);
        assertNotNull(assicurazioneAutoService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        assicurazioneAutoService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneAutoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AssicurazioneAutoEntity entityToDelete = new AssicurazioneAutoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneAutoEntity entitySaved = assicurazioneAutoService.save(entityToDelete);
        assertNotNull(assicurazioneAutoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        assicurazioneAutoService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneAutoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AssicurazioneAutoEntity> aList = StreamSupport
                .stream(assicurazioneAutoService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AssicurazioneAutoEntity entityToDelete = new AssicurazioneAutoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneAutoEntity entitySaved = assicurazioneAutoService.save(entityToDelete);
        assertNotNull(assicurazioneAutoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AssicurazioneAutoEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        assicurazioneAutoService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneAutoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(assicurazioneAutoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(assicurazioneAutoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            assicurazioneAutoService.deleteAll(assicurazioneAutoService.findAll());

            assertTrue(StreamSupport.stream(assicurazioneAutoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AssicurazioneAutoEntity entityToDelete = new AssicurazioneAutoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneAutoEntity entitySaved = assicurazioneAutoService.save(entityToDelete);
        assertNotNull(assicurazioneAutoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        assicurazioneAutoService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneAutoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(assicurazioneAutoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(assicurazioneAutoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            assicurazioneAutoService.deleteAll(assicurazioneAutoService.findAll());
            assertTrue(StreamSupport.stream(assicurazioneAutoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}