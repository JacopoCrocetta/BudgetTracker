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

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.IgienePersonaleEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.IgienePersonaleService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IgienePersonaleServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    IgienePersonaleService igienePersonaleService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        IgienePersonaleEntity entityToDelete = new IgienePersonaleEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        IgienePersonaleEntity entitySaved = igienePersonaleService.save(entityToDelete);
        assertNotNull(igienePersonaleService.findById(entitySaved.getId()).get());
        assertTrue(igienePersonaleService.count() != 0);

        igienePersonaleService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        IgienePersonaleEntity entityToSave = new IgienePersonaleEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(igienePersonaleService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(igienePersonaleService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        IgienePersonaleEntity entityToSave = new IgienePersonaleEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(igienePersonaleService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(igienePersonaleService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        IgienePersonaleEntity entityToSave = new IgienePersonaleEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(igienePersonaleService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(igienePersonaleService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        IgienePersonaleEntity entityToSave = new IgienePersonaleEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(igienePersonaleService.save(entityToSave) != null);

        assertTrue(igienePersonaleService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        IgienePersonaleEntity entityToSave = new IgienePersonaleEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(igienePersonaleService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        IgienePersonaleEntity entityToDelete = new IgienePersonaleEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        IgienePersonaleEntity entitySaved = igienePersonaleService.save(entityToDelete);
        assertNotNull(igienePersonaleService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        igienePersonaleService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            igienePersonaleService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        IgienePersonaleEntity entityToDelete = new IgienePersonaleEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        IgienePersonaleEntity entitySaved = igienePersonaleService.save(entityToDelete);
        assertNotNull(igienePersonaleService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        igienePersonaleService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            igienePersonaleService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<IgienePersonaleEntity> aList = StreamSupport
                .stream(igienePersonaleService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        IgienePersonaleEntity entityToDelete = new IgienePersonaleEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        IgienePersonaleEntity entitySaved = igienePersonaleService.save(entityToDelete);
        assertNotNull(igienePersonaleService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<IgienePersonaleEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        igienePersonaleService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            igienePersonaleService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(igienePersonaleService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(igienePersonaleService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            igienePersonaleService.deleteAll(igienePersonaleService.findAll());

            assertTrue(StreamSupport.stream(igienePersonaleService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        IgienePersonaleEntity entityToDelete = new IgienePersonaleEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        IgienePersonaleEntity entitySaved = igienePersonaleService.save(entityToDelete);
        assertNotNull(igienePersonaleService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        igienePersonaleService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            igienePersonaleService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(igienePersonaleService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(igienePersonaleService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            igienePersonaleService.deleteAll(igienePersonaleService.findAll());
            assertTrue(StreamSupport.stream(igienePersonaleService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
