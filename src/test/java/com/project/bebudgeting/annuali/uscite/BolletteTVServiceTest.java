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

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteTVEntity;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteTVService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BolletteTVServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    BolletteTVService bolletteTVService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        BolletteTVEntity entityToDelete = new BolletteTVEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTVEntity entitySaved = bolletteTVService.save(entityToDelete);
        assertNotNull(bolletteTVService.findById(entitySaved.getId()).get());
        assertTrue(bolletteTVService.count() != 0);

        bolletteTVService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteTVEntity entityToSave = new BolletteTVEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteTVService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bolletteTVService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteTVEntity entityToSave = new BolletteTVEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteTVService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(bolletteTVService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        BolletteTVEntity entityToSave = new BolletteTVEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteTVService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(bolletteTVService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        BolletteTVEntity entityToSave = new BolletteTVEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(bolletteTVService.save(entityToSave) != null);

        assertTrue(bolletteTVService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        BolletteTVEntity entityToSave = new BolletteTVEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(bolletteTVService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        BolletteTVEntity entityToDelete = new BolletteTVEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTVEntity entitySaved = bolletteTVService.save(entityToDelete);
        assertNotNull(bolletteTVService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bolletteTVService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteTVService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        BolletteTVEntity entityToDelete = new BolletteTVEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTVEntity entitySaved = bolletteTVService.save(entityToDelete);
        assertNotNull(bolletteTVService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        bolletteTVService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteTVService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<BolletteTVEntity> aList = StreamSupport.stream(bolletteTVService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        BolletteTVEntity entityToDelete = new BolletteTVEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTVEntity entitySaved = bolletteTVService.save(entityToDelete);
        assertNotNull(bolletteTVService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<BolletteTVEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        bolletteTVService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bolletteTVService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(bolletteTVService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(bolletteTVService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            bolletteTVService.deleteAll(bolletteTVService.findAll());

            assertTrue(StreamSupport.stream(bolletteTVService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        BolletteTVEntity entityToDelete = new BolletteTVEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        BolletteTVEntity entitySaved = bolletteTVService.save(entityToDelete);
        assertNotNull(bolletteTVService.findById(entitySaved.getId()).get());

        assertNotNull(entitySaved);

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        bolletteTVService.deleteAllById(ids);

        List<BolletteTVEntity> aFornitureAnimaliDomesticiEntities = StreamSupport
                .stream(bolletteTVService.findAll().spliterator(), false).collect(Collectors.toList());

        if (aFornitureAnimaliDomesticiEntities.size() == 0) {
            assertTrue(aFornitureAnimaliDomesticiEntities.size() == 0);
        } else {
            bolletteTVService.deleteAll(bolletteTVService.findAll());
            aFornitureAnimaliDomesticiEntities = StreamSupport.stream(bolletteTVService.findAll().spliterator(), false)
                    .collect(Collectors.toList());
            assertTrue(aFornitureAnimaliDomesticiEntities.size() == 0);
        }
    }
}
