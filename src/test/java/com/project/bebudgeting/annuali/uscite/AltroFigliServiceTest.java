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

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.AltroFigliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.AltroFigliService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltroFigliServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltroFigliService altroFigliService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltroFigliEntity entityToDelete = new AltroFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroFigliEntity entitySaved = altroFigliService.save(entityToDelete);
        assertNotNull(altroFigliService.findById(entitySaved.getId()).get());
        assertTrue(altroFigliService.count() != 0);

        altroFigliService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltroFigliEntity entityToSave = new AltroFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroFigliService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroFigliEntity entityToSave = new AltroFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroFigliService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroFigliEntity entityToSave = new AltroFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroFigliService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altroFigliService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltroFigliEntity entityToSave = new AltroFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroFigliService.save(entityToSave) != null);

        assertTrue(altroFigliService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltroFigliEntity entityToSave = new AltroFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altroFigliService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltroFigliEntity entityToDelete = new AltroFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroFigliEntity entitySaved = altroFigliService.save(entityToDelete);
        assertNotNull(altroFigliService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroFigliService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltroFigliEntity entityToDelete = new AltroFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroFigliEntity entitySaved = altroFigliService.save(entityToDelete);
        assertNotNull(altroFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroFigliService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltroFigliEntity> aList = StreamSupport
                .stream(altroFigliService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltroFigliEntity entityToDelete = new AltroFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroFigliEntity entitySaved = altroFigliService.save(entityToDelete);
        assertNotNull(altroFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltroFigliEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altroFigliService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroFigliService.deleteAll(altroFigliService.findAll());

            assertTrue(StreamSupport.stream(altroFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltroFigliEntity entityToDelete = new AltroFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroFigliEntity entitySaved = altroFigliService.save(entityToDelete);
        assertNotNull(altroFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altroFigliService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroFigliService.deleteAll(altroFigliService.findAll());
            assertTrue(StreamSupport.stream(altroFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}