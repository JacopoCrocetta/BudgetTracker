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

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice.AssicurazioneCasaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssicurazioneCasaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AssicurazioneCasaService assicurazioneCasaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AssicurazioneCasaEntity entityToDelete = new AssicurazioneCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneCasaEntity entitySaved = assicurazioneCasaService.save(entityToDelete);
        assertNotNull(assicurazioneCasaService.findById(entitySaved.getId()).get());
        assertTrue(assicurazioneCasaService.count() != 0);

        assicurazioneCasaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AssicurazioneCasaEntity entityToSave = new AssicurazioneCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneCasaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(assicurazioneCasaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AssicurazioneCasaEntity entityToSave = new AssicurazioneCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneCasaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(assicurazioneCasaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AssicurazioneCasaEntity entityToSave = new AssicurazioneCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneCasaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(assicurazioneCasaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AssicurazioneCasaEntity entityToSave = new AssicurazioneCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(assicurazioneCasaService.save(entityToSave) != null);

        assertTrue(assicurazioneCasaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AssicurazioneCasaEntity entityToSave = new AssicurazioneCasaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(assicurazioneCasaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AssicurazioneCasaEntity entityToDelete = new AssicurazioneCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneCasaEntity entitySaved = assicurazioneCasaService.save(entityToDelete);
        assertNotNull(assicurazioneCasaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        assicurazioneCasaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneCasaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AssicurazioneCasaEntity entityToDelete = new AssicurazioneCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneCasaEntity entitySaved = assicurazioneCasaService.save(entityToDelete);
        assertNotNull(assicurazioneCasaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        assicurazioneCasaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneCasaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AssicurazioneCasaEntity> aList = StreamSupport
                .stream(assicurazioneCasaService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AssicurazioneCasaEntity entityToDelete = new AssicurazioneCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneCasaEntity entitySaved = assicurazioneCasaService.save(entityToDelete);
        assertNotNull(assicurazioneCasaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AssicurazioneCasaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        assicurazioneCasaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneCasaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(assicurazioneCasaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(assicurazioneCasaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            assicurazioneCasaService.deleteAll(assicurazioneCasaService.findAll());

            assertTrue(StreamSupport.stream(assicurazioneCasaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AssicurazioneCasaEntity entityToDelete = new AssicurazioneCasaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AssicurazioneCasaEntity entitySaved = assicurazioneCasaService.save(entityToDelete);
        assertNotNull(assicurazioneCasaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        assicurazioneCasaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            assicurazioneCasaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(assicurazioneCasaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(assicurazioneCasaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            assicurazioneCasaService.deleteAll(assicurazioneCasaService.findAll());
            assertTrue(StreamSupport.stream(assicurazioneCasaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
