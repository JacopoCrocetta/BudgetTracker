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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.AltroDebitiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.AltroDebitiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltroDebitiServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltroDebitiService altroDebitiService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltroDebitiEntity entityToDelete = new AltroDebitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDebitiEntity entitySaved = altroDebitiService.save(entityToDelete);
        assertNotNull(altroDebitiService.findById(entitySaved.getId()).get());
        assertTrue(altroDebitiService.count() != 0);

        altroDebitiService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltroDebitiEntity entityToSave = new AltroDebitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroDebitiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroDebitiService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroDebitiEntity entityToSave = new AltroDebitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroDebitiService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroDebitiService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroDebitiEntity entityToSave = new AltroDebitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroDebitiService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altroDebitiService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltroDebitiEntity entityToSave = new AltroDebitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroDebitiService.save(entityToSave) != null);

        assertTrue(altroDebitiService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltroDebitiEntity entityToSave = new AltroDebitiEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altroDebitiService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltroDebitiEntity entityToDelete = new AltroDebitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDebitiEntity entitySaved = altroDebitiService.save(entityToDelete);
        assertNotNull(altroDebitiService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroDebitiService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroDebitiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltroDebitiEntity entityToDelete = new AltroDebitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDebitiEntity entitySaved = altroDebitiService.save(entityToDelete);
        assertNotNull(altroDebitiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroDebitiService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroDebitiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltroDebitiEntity> aList = StreamSupport.stream(altroDebitiService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltroDebitiEntity entityToDelete = new AltroDebitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDebitiEntity entitySaved = altroDebitiService.save(entityToDelete);
        assertNotNull(altroDebitiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltroDebitiEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altroDebitiService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroDebitiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroDebitiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroDebitiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroDebitiService.deleteAll(altroDebitiService.findAll());

            assertTrue(StreamSupport.stream(altroDebitiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltroDebitiEntity entityToDelete = new AltroDebitiEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroDebitiEntity entitySaved = altroDebitiService.save(entityToDelete);
        assertNotNull(altroDebitiService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altroDebitiService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroDebitiService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroDebitiService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroDebitiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroDebitiService.deleteAll(altroDebitiService.findAll());
            assertTrue(StreamSupport.stream(altroDebitiService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
