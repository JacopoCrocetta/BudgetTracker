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

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteTelefonoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteTelefonoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BolletteTelefonoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    BolletteTelefonoService bolletteTelefonoService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        BolletteTelefonoEntity entityToDelete = new BolletteTelefonoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTelefonoEntity entitySaved = bolletteTelefonoService.save(entityToDelete);
        assertNotNull(bolletteTelefonoService.findById(entitySaved.getId()).get());
        assertTrue(bolletteTelefonoService.count() != 0);

        bolletteTelefonoService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteTelefonoEntity entityToSave = new BolletteTelefonoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteTelefonoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bolletteTelefonoService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteTelefonoEntity entityToSave = new BolletteTelefonoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteTelefonoService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bolletteTelefonoService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteTelefonoEntity entityToSave = new BolletteTelefonoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteTelefonoService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(bolletteTelefonoService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        BolletteTelefonoEntity entityToSave = new BolletteTelefonoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteTelefonoService.save(entityToSave) != null);

        assertTrue(bolletteTelefonoService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        BolletteTelefonoEntity entityToSave = new BolletteTelefonoEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(bolletteTelefonoService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        BolletteTelefonoEntity entityToDelete = new BolletteTelefonoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTelefonoEntity entitySaved = bolletteTelefonoService.save(entityToDelete);
        assertNotNull(bolletteTelefonoService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bolletteTelefonoService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteTelefonoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        BolletteTelefonoEntity entityToDelete = new BolletteTelefonoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTelefonoEntity entitySaved = bolletteTelefonoService.save(entityToDelete);
        assertNotNull(bolletteTelefonoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bolletteTelefonoService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteTelefonoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<BolletteTelefonoEntity> aList = StreamSupport
                .stream(bolletteTelefonoService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        BolletteTelefonoEntity entityToDelete = new BolletteTelefonoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTelefonoEntity entitySaved = bolletteTelefonoService.save(entityToDelete);
        assertNotNull(bolletteTelefonoService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<BolletteTelefonoEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        bolletteTelefonoService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteTelefonoService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bolletteTelefonoService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bolletteTelefonoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            bolletteTelefonoService.deleteAll(bolletteTelefonoService.findAll());

            assertTrue(StreamSupport.stream(bolletteTelefonoService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        BolletteTelefonoEntity entityToDelete = new BolletteTelefonoEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTelefonoEntity entitySaved = bolletteTelefonoService.save(entityToDelete);
        assertNotNull(bolletteTelefonoService.findById(entitySaved.getId()).get());

        assertNotNull(entitySaved);

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        bolletteTelefonoService.deleteAllById(ids);

        List<BolletteTelefonoEntity> aFornitureAnimaliDomesticiEntities = StreamSupport
                .stream(bolletteTelefonoService.findAll().spliterator(), false).collect(Collectors.toList());

        if (aFornitureAnimaliDomesticiEntities.size() == 0) {
            assertTrue(aFornitureAnimaliDomesticiEntities.size() == 0);
        } else {
            bolletteTelefonoService.deleteAll(bolletteTelefonoService.findAll());
            aFornitureAnimaliDomesticiEntities = StreamSupport
                    .stream(bolletteTelefonoService.findAll().spliterator(), false).collect(Collectors.toList());
            assertTrue(aFornitureAnimaliDomesticiEntities.size() == 0);
        }
    }
}
