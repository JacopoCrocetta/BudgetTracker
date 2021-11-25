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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.PrestitiPerStudiareEntity;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.PrestitiPerStudioService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PrestitiPerStudioServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    PrestitiPerStudioService prestitiPerStudioService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        PrestitiPerStudiareEntity entityToDelete = new PrestitiPerStudiareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PrestitiPerStudiareEntity entitySaved = prestitiPerStudioService.save(entityToDelete);
        assertNotNull(prestitiPerStudioService.findById(entitySaved.getId()).get());
        assertTrue(prestitiPerStudioService.count() != 0);

        prestitiPerStudioService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        PrestitiPerStudiareEntity entityToSave = new PrestitiPerStudiareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(prestitiPerStudioService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(prestitiPerStudioService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        PrestitiPerStudiareEntity entityToSave = new PrestitiPerStudiareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(prestitiPerStudioService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(prestitiPerStudioService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        PrestitiPerStudiareEntity entityToSave = new PrestitiPerStudiareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(prestitiPerStudioService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(prestitiPerStudioService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        PrestitiPerStudiareEntity entityToSave = new PrestitiPerStudiareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(prestitiPerStudioService.save(entityToSave) != null);

        assertTrue(prestitiPerStudioService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        PrestitiPerStudiareEntity entityToSave = new PrestitiPerStudiareEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(prestitiPerStudioService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        PrestitiPerStudiareEntity entityToDelete = new PrestitiPerStudiareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PrestitiPerStudiareEntity entitySaved = prestitiPerStudioService.save(entityToDelete);
        assertNotNull(prestitiPerStudioService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        prestitiPerStudioService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            prestitiPerStudioService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        PrestitiPerStudiareEntity entityToDelete = new PrestitiPerStudiareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PrestitiPerStudiareEntity entitySaved = prestitiPerStudioService.save(entityToDelete);
        assertNotNull(prestitiPerStudioService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        prestitiPerStudioService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            prestitiPerStudioService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<PrestitiPerStudiareEntity> aList = StreamSupport
                .stream(prestitiPerStudioService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        PrestitiPerStudiareEntity entityToDelete = new PrestitiPerStudiareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PrestitiPerStudiareEntity entitySaved = prestitiPerStudioService.save(entityToDelete);
        assertNotNull(prestitiPerStudioService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<PrestitiPerStudiareEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        prestitiPerStudioService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            prestitiPerStudioService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(prestitiPerStudioService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(prestitiPerStudioService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            prestitiPerStudioService.deleteAll(prestitiPerStudioService.findAll());

            assertTrue(StreamSupport.stream(prestitiPerStudioService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        PrestitiPerStudiareEntity entityToDelete = new PrestitiPerStudiareEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PrestitiPerStudiareEntity entitySaved = prestitiPerStudioService.save(entityToDelete);
        assertNotNull(prestitiPerStudioService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        prestitiPerStudioService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            prestitiPerStudioService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(prestitiPerStudioService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(prestitiPerStudioService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            prestitiPerStudioService.deleteAll(prestitiPerStudioService.findAll());
            assertTrue(StreamSupport.stream(prestitiPerStudioService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
