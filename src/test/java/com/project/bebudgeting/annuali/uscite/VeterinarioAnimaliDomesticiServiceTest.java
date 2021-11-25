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

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice.VeterinarioAnimaliDomesticiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VeterinarioAnimaliDomesticiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    VeterinarioAnimaliDomesticiService veterinarioAnimaliDomesticiService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        VeterinarioAnimaliDomesticiEntity entityToDelete = new VeterinarioAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        VeterinarioAnimaliDomesticiEntity entitySaved = veterinarioAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(veterinarioAnimaliDomesticiService.findById(entitySaved.getId()).get());
        assertTrue(veterinarioAnimaliDomesticiService.count() != 0);

        veterinarioAnimaliDomesticiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        VeterinarioAnimaliDomesticiEntity entityToSave = new VeterinarioAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(veterinarioAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(veterinarioAnimaliDomesticiService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        VeterinarioAnimaliDomesticiEntity entityToSave = new VeterinarioAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(veterinarioAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(veterinarioAnimaliDomesticiService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        VeterinarioAnimaliDomesticiEntity entityToSave = new VeterinarioAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(veterinarioAnimaliDomesticiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(veterinarioAnimaliDomesticiService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        VeterinarioAnimaliDomesticiEntity entityToSave = new VeterinarioAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(veterinarioAnimaliDomesticiService.save(entityToSave) != null);

        assertTrue(veterinarioAnimaliDomesticiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        VeterinarioAnimaliDomesticiEntity entityToSave = new VeterinarioAnimaliDomesticiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(veterinarioAnimaliDomesticiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        VeterinarioAnimaliDomesticiEntity entityToDelete = new VeterinarioAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        VeterinarioAnimaliDomesticiEntity entitySaved = veterinarioAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(veterinarioAnimaliDomesticiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        veterinarioAnimaliDomesticiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            veterinarioAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        VeterinarioAnimaliDomesticiEntity entityToDelete = new VeterinarioAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        VeterinarioAnimaliDomesticiEntity entitySaved = veterinarioAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(veterinarioAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        veterinarioAnimaliDomesticiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            veterinarioAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<VeterinarioAnimaliDomesticiEntity> aList = StreamSupport
                .stream(veterinarioAnimaliDomesticiService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        VeterinarioAnimaliDomesticiEntity entityToDelete = new VeterinarioAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        VeterinarioAnimaliDomesticiEntity entitySaved = veterinarioAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(veterinarioAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<VeterinarioAnimaliDomesticiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        veterinarioAnimaliDomesticiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            veterinarioAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(veterinarioAnimaliDomesticiService.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(veterinarioAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            veterinarioAnimaliDomesticiService.deleteAll(veterinarioAnimaliDomesticiService.findAll());

            assertTrue(StreamSupport.stream(veterinarioAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        VeterinarioAnimaliDomesticiEntity entityToDelete = new VeterinarioAnimaliDomesticiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        VeterinarioAnimaliDomesticiEntity entitySaved = veterinarioAnimaliDomesticiService.save(entityToDelete);
        assertNotNull(veterinarioAnimaliDomesticiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        veterinarioAnimaliDomesticiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            veterinarioAnimaliDomesticiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(veterinarioAnimaliDomesticiService.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(veterinarioAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            veterinarioAnimaliDomesticiService.deleteAll(veterinarioAnimaliDomesticiService.findAll());
            assertTrue(StreamSupport.stream(veterinarioAnimaliDomesticiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
