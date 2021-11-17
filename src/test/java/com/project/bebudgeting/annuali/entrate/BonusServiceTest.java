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

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.BonusEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.BonusService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BonusServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    BonusService bonusService;

    // COUNT TEST
    @Test
    void countAllAltroSalarioEntitiesTest() {
        BonusEntity entityToDelete = new BonusEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BonusEntity entitySaved = bonusService.save(entityToDelete);
        assertNotNull(bonusService.findById(entitySaved.getId()).get());
        assertTrue(bonusService.count() != 0);

        bonusService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        BonusEntity entityToSave = new BonusEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bonusService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bonusService.findAll() != null);
    }

    @Test
    void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        BonusEntity entityToSave = new BonusEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bonusService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bonusService.findById(entityToSave.getId()) != null);
    }

    @Test
    void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        BonusEntity entityToSave = new BonusEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bonusService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(bonusService.findAllById(ids) != null);
    }

    @Test
    void findById() {
        // SAVE ONE ENTITY
        BonusEntity entityToSave = new BonusEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bonusService.save(entityToSave) != null);

        assertTrue(bonusService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        BonusEntity entityToSave = new BonusEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(bonusService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        BonusEntity entityToDelete = new BonusEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BonusEntity entitySaved = bonusService.save(entityToDelete);
        assertNotNull(bonusService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bonusService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bonusService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        BonusEntity entityToDelete = new BonusEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BonusEntity entitySaved = bonusService.save(entityToDelete);
        assertNotNull(bonusService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bonusService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bonusService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<BonusEntity> aList = StreamSupport.stream(bonusService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        BonusEntity entityToDelete = new BonusEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BonusEntity entitySaved = bonusService.save(entityToDelete);
        assertNotNull(bonusService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<BonusEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        bonusService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bonusService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bonusService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bonusService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            bonusService.deleteAll(bonusService.findAll());

            assertTrue(StreamSupport.stream(bonusService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    void deleteAllByIdsTest() {
        BonusEntity entityToDelete = new BonusEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BonusEntity entitySaved = bonusService.save(entityToDelete);
        assertNotNull(bonusService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        bonusService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bonusService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bonusService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bonusService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            bonusService.deleteAll(bonusService.findAll());
            assertTrue(StreamSupport.stream(bonusService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
