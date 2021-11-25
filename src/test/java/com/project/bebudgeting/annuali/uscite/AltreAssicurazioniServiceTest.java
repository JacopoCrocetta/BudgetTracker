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

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice.AltreAssicurazioniService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltreAssicurazioniServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltreAssicurazioniService altreAssicurazioniService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltreAssicurazioniEntity entityToDelete = new AltreAssicurazioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreAssicurazioniEntity entitySaved = altreAssicurazioniService.save(entityToDelete);
        assertNotNull(altreAssicurazioniService.findById(entitySaved.getId()).get());
        assertTrue(altreAssicurazioniService.count() != 0);

        altreAssicurazioniService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltreAssicurazioniEntity entityToSave = new AltreAssicurazioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreAssicurazioniService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altreAssicurazioniService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltreAssicurazioniEntity entityToSave = new AltreAssicurazioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreAssicurazioniService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altreAssicurazioniService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltreAssicurazioniEntity entityToSave = new AltreAssicurazioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreAssicurazioniService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altreAssicurazioniService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltreAssicurazioniEntity entityToSave = new AltreAssicurazioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altreAssicurazioniService.save(entityToSave) != null);

        assertTrue(altreAssicurazioniService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltreAssicurazioniEntity entityToSave = new AltreAssicurazioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altreAssicurazioniService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltreAssicurazioniEntity entityToDelete = new AltreAssicurazioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreAssicurazioniEntity entitySaved = altreAssicurazioniService.save(entityToDelete);
        assertNotNull(altreAssicurazioniService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altreAssicurazioniService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreAssicurazioniService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltreAssicurazioniEntity entityToDelete = new AltreAssicurazioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreAssicurazioniEntity entitySaved = altreAssicurazioniService.save(entityToDelete);
        assertNotNull(altreAssicurazioniService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altreAssicurazioniService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreAssicurazioniService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltreAssicurazioniEntity> aList = StreamSupport
                .stream(altreAssicurazioniService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltreAssicurazioniEntity entityToDelete = new AltreAssicurazioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreAssicurazioniEntity entitySaved = altreAssicurazioniService.save(entityToDelete);
        assertNotNull(altreAssicurazioniService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltreAssicurazioniEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altreAssicurazioniService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreAssicurazioniService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altreAssicurazioniService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altreAssicurazioniService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altreAssicurazioniService.deleteAll(altreAssicurazioniService.findAll());

            assertTrue(StreamSupport.stream(altreAssicurazioniService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltreAssicurazioniEntity entityToDelete = new AltreAssicurazioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltreAssicurazioniEntity entitySaved = altreAssicurazioniService.save(entityToDelete);
        assertNotNull(altreAssicurazioniService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altreAssicurazioniService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altreAssicurazioniService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altreAssicurazioniService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altreAssicurazioniService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altreAssicurazioniService.deleteAll(altreAssicurazioniService.findAll());
            assertTrue(StreamSupport.stream(altreAssicurazioniService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
