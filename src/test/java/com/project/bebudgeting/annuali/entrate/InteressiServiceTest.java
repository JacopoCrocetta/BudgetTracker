package com.project.bebudgeting.annuali.entrate;

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

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.InteressiEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.InteressiService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InteressiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    InteressiService interessiService;

    // COUNT TEST
    @Test
    void countAllAltroSalarioEntitiesTest() {
        InteressiEntity entityToDelete = new InteressiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        InteressiEntity entitySaved = interessiService.save(entityToDelete);
        assertNotNull(interessiService.findById(entitySaved.getId()).get());
        assertTrue(interessiService.count() != 0);

        interessiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        InteressiEntity entityToSave = new InteressiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(interessiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(interessiService.findAll() != null);
    }

    @Test
    void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        InteressiEntity entityToSave = new InteressiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(interessiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(interessiService.findById(entityToSave.getId()) != null);
    }

    @Test
    void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        InteressiEntity entityToSave = new InteressiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(interessiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(interessiService.findAllById(ids) != null);
    }

    @Test
    void findById() {
        // SAVE ONE ENTITY
        InteressiEntity entityToSave = new InteressiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(interessiService.save(entityToSave) != null);

        assertTrue(interessiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        InteressiEntity entityToSave = new InteressiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(interessiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        InteressiEntity entityToDelete = new InteressiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        InteressiEntity entitySaved = interessiService.save(entityToDelete);
        assertNotNull(interessiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        interessiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            interessiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        InteressiEntity entityToDelete = new InteressiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        InteressiEntity entitySaved = interessiService.save(entityToDelete);
        assertNotNull(interessiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        interessiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            interessiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<InteressiEntity> aList = StreamSupport.stream(interessiService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        InteressiEntity entityToDelete = new InteressiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        InteressiEntity entitySaved = interessiService.save(entityToDelete);
        assertNotNull(interessiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<InteressiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        interessiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            interessiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(interessiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(interessiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            interessiService.deleteAll(interessiService.findAll());

            assertTrue(StreamSupport.stream(interessiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    void deleteAllByIdsTest() {
        InteressiEntity entityToDelete = new InteressiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        InteressiEntity entitySaved = interessiService.save(entityToDelete);
        assertNotNull(interessiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        interessiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            interessiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(interessiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(interessiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            interessiService.deleteAll(interessiService.findAll());

            assertTrue(StreamSupport.stream(interessiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
