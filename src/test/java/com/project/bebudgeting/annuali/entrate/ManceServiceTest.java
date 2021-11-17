package com.project.bebudgeting.annuali.entrate;

import org.junit.jupiter.api.Test;
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

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.ManceEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.ManceService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ManceServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    ManceService manceService;

    // COUNT TEST
    @Test
    void countAllAltroSalarioEntitiesTest() {
        ManceEntity entityToDelete = new ManceEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManceEntity entitySaved = manceService.save(entityToDelete);
        assertNotNull(manceService.findById(entitySaved.getId()).get());
        assertTrue(manceService.count() != 0);

        manceService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        ManceEntity entityToSave = new ManceEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(manceService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(manceService.findAll() != null);
    }

    @Test
    void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        ManceEntity entityToSave = new ManceEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(manceService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(manceService.findById(entityToSave.getId()) != null);
    }

    @Test
    void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        ManceEntity entityToSave = new ManceEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(manceService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(manceService.findAllById(ids) != null);
    }

    @Test
    void findById() {
        // SAVE ONE ENTITY
        ManceEntity entityToSave = new ManceEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(manceService.save(entityToSave) != null);

        assertTrue(manceService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        ManceEntity entityToSave = new ManceEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(manceService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        ManceEntity entityToDelete = new ManceEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManceEntity entitySaved = manceService.save(entityToDelete);
        assertNotNull(manceService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        manceService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            manceService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        ManceEntity entityToDelete = new ManceEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManceEntity entitySaved = manceService.save(entityToDelete);
        assertNotNull(manceService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        manceService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            manceService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<ManceEntity> aList = StreamSupport.stream(manceService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        ManceEntity entityToDelete = new ManceEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManceEntity entitySaved = manceService.save(entityToDelete);
        assertNotNull(manceService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<ManceEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        manceService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            manceService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(manceService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(manceService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            manceService.deleteAll(manceService.findAll());

            assertTrue(StreamSupport.stream(manceService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    void deleteAllByIdsTest() {
        ManceEntity entityToDelete = new ManceEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        ManceEntity entitySaved = manceService.save(entityToDelete);
        assertNotNull(manceService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        manceService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            manceService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(manceService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(manceService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            manceService.deleteAll(manceService.findAll());
            assertTrue(StreamSupport.stream(manceService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
