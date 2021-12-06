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

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.AsiloFigliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.AsiloService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AsiloServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AsiloService asiloService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AsiloFigliEntity entityToDelete = new AsiloFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AsiloFigliEntity entitySaved = asiloService.save(entityToDelete);
        assertNotNull(asiloService.findById(entitySaved.getId()).get());
        assertTrue(asiloService.count() != 0);

        asiloService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AsiloFigliEntity entityToSave = new AsiloFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(asiloService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(asiloService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AsiloFigliEntity entityToSave = new AsiloFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(asiloService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(asiloService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AsiloFigliEntity entityToSave = new AsiloFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(asiloService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(asiloService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AsiloFigliEntity entityToSave = new AsiloFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(asiloService.save(entityToSave) != null);

        assertTrue(asiloService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AsiloFigliEntity entityToSave = new AsiloFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(asiloService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AsiloFigliEntity entityToDelete = new AsiloFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AsiloFigliEntity entitySaved = asiloService.save(entityToDelete);
        assertNotNull(asiloService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        asiloService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            asiloService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AsiloFigliEntity entityToDelete = new AsiloFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AsiloFigliEntity entitySaved = asiloService.save(entityToDelete);
        assertNotNull(asiloService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        asiloService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            asiloService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AsiloFigliEntity> aList = StreamSupport
                .stream(asiloService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AsiloFigliEntity entityToDelete = new AsiloFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AsiloFigliEntity entitySaved = asiloService.save(entityToDelete);
        assertNotNull(asiloService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AsiloFigliEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        asiloService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            asiloService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(asiloService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(asiloService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            asiloService.deleteAll(asiloService.findAll());

            assertTrue(StreamSupport.stream(asiloService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AsiloFigliEntity entityToDelete = new AsiloFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AsiloFigliEntity entitySaved = asiloService.save(entityToDelete);
        assertNotNull(asiloService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        asiloService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            asiloService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(asiloService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(asiloService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            asiloService.deleteAll(asiloService.findAll());
            assertTrue(StreamSupport.stream(asiloService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
