package com.project.bebudgeting.annuali.entrate;

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

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.RegaliAltreEntrateEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.RegaliAltreEntrateService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RegaliAltreEntrateServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    RegaliAltreEntrateService regaliAltreEntrateService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        RegaliAltreEntrateEntity entityToDelete = new RegaliAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RegaliAltreEntrateEntity entitySaved = regaliAltreEntrateService.save(entityToDelete);
        assertNotNull(regaliAltreEntrateService.findById(entitySaved.getId()).get());
        assertTrue(regaliAltreEntrateService.count() != 0);

        regaliAltreEntrateService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        RegaliAltreEntrateEntity entityToSave = new RegaliAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(regaliAltreEntrateService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(regaliAltreEntrateService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        RegaliAltreEntrateEntity entityToSave = new RegaliAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(regaliAltreEntrateService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(regaliAltreEntrateService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        RegaliAltreEntrateEntity entityToSave = new RegaliAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(regaliAltreEntrateService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(regaliAltreEntrateService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        RegaliAltreEntrateEntity entityToSave = new RegaliAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(regaliAltreEntrateService.save(entityToSave) != null);

        assertTrue(regaliAltreEntrateService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        RegaliAltreEntrateEntity entityToSave = new RegaliAltreEntrateEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(regaliAltreEntrateService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        RegaliAltreEntrateEntity entityToDelete = new RegaliAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RegaliAltreEntrateEntity entitySaved = regaliAltreEntrateService.save(entityToDelete);
        assertNotNull(regaliAltreEntrateService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        regaliAltreEntrateService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            regaliAltreEntrateService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        RegaliAltreEntrateEntity entityToDelete = new RegaliAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RegaliAltreEntrateEntity entitySaved = regaliAltreEntrateService.save(entityToDelete);
        assertNotNull(regaliAltreEntrateService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        regaliAltreEntrateService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            regaliAltreEntrateService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<RegaliAltreEntrateEntity> aList = StreamSupport
                .stream(regaliAltreEntrateService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        RegaliAltreEntrateEntity entityToDelete = new RegaliAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RegaliAltreEntrateEntity entitySaved = regaliAltreEntrateService.save(entityToDelete);
        assertNotNull(regaliAltreEntrateService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<RegaliAltreEntrateEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        regaliAltreEntrateService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            regaliAltreEntrateService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(regaliAltreEntrateService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(regaliAltreEntrateService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            regaliAltreEntrateService.deleteAll(regaliAltreEntrateService.findAll());

            assertTrue(StreamSupport.stream(regaliAltreEntrateService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        RegaliAltreEntrateEntity entityToDelete = new RegaliAltreEntrateEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        RegaliAltreEntrateEntity entitySaved = regaliAltreEntrateService.save(entityToDelete);
        assertNotNull(regaliAltreEntrateService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        regaliAltreEntrateService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            regaliAltreEntrateService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(regaliAltreEntrateService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(regaliAltreEntrateService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            regaliAltreEntrateService.deleteAll(regaliAltreEntrateService.findAll());
            assertTrue(StreamSupport.stream(regaliAltreEntrateService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
