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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.PartiteEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.PartiteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PartiteDivertimentoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    PartiteService partiteService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        PartiteEntity entityToDelete = new PartiteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PartiteEntity entitySaved = partiteService.save(entityToDelete);
        assertNotNull(partiteService.findById(entitySaved.getId()).get());
        assertTrue(partiteService.count() != 0);

        partiteService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        PartiteEntity entityToSave = new PartiteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(partiteService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(partiteService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        PartiteEntity entityToSave = new PartiteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(partiteService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(partiteService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        PartiteEntity entityToSave = new PartiteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(partiteService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(partiteService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        PartiteEntity entityToSave = new PartiteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(partiteService.save(entityToSave) != null);

        assertTrue(partiteService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        PartiteEntity entityToSave = new PartiteEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(partiteService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        PartiteEntity entityToDelete = new PartiteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PartiteEntity entitySaved = partiteService.save(entityToDelete);
        assertNotNull(partiteService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        partiteService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            partiteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        PartiteEntity entityToDelete = new PartiteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PartiteEntity entitySaved = partiteService.save(entityToDelete);
        assertNotNull(partiteService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        partiteService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            partiteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<PartiteEntity> aList = StreamSupport.stream(partiteService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        PartiteEntity entityToDelete = new PartiteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PartiteEntity entitySaved = partiteService.save(entityToDelete);
        assertNotNull(partiteService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<PartiteEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        partiteService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            partiteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(partiteService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(partiteService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            partiteService.deleteAll(partiteService.findAll());

            assertTrue(StreamSupport.stream(partiteService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        PartiteEntity entityToDelete = new PartiteEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        PartiteEntity entitySaved = partiteService.save(entityToDelete);
        assertNotNull(partiteService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        partiteService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            partiteService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(partiteService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(partiteService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            partiteService.deleteAll(partiteService.findAll());
            assertTrue(StreamSupport.stream(partiteService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
