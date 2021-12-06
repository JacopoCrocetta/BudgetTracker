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

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.AltroTecnologiaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice.AltroTecnologiaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AltroTecnologiaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    AltroTecnologiaService altroTecnologiaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        AltroTecnologiaEntity entityToDelete = new AltroTecnologiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroTecnologiaEntity entitySaved = altroTecnologiaService.save(entityToDelete);
        assertNotNull(altroTecnologiaService.findById(entitySaved.getId()).get());
        assertTrue(altroTecnologiaService.count() != 0);

        altroTecnologiaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        AltroTecnologiaEntity entityToSave = new AltroTecnologiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroTecnologiaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroTecnologiaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroTecnologiaEntity entityToSave = new AltroTecnologiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroTecnologiaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(altroTecnologiaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        AltroTecnologiaEntity entityToSave = new AltroTecnologiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroTecnologiaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(altroTecnologiaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        AltroTecnologiaEntity entityToSave = new AltroTecnologiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(altroTecnologiaService.save(entityToSave) != null);

        assertTrue(altroTecnologiaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        AltroTecnologiaEntity entityToSave = new AltroTecnologiaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(altroTecnologiaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        AltroTecnologiaEntity entityToDelete = new AltroTecnologiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroTecnologiaEntity entitySaved = altroTecnologiaService.save(entityToDelete);
        assertNotNull(altroTecnologiaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroTecnologiaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroTecnologiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        AltroTecnologiaEntity entityToDelete = new AltroTecnologiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroTecnologiaEntity entitySaved = altroTecnologiaService.save(entityToDelete);
        assertNotNull(altroTecnologiaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        altroTecnologiaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroTecnologiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<AltroTecnologiaEntity> aList = StreamSupport
                .stream(altroTecnologiaService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        AltroTecnologiaEntity entityToDelete = new AltroTecnologiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroTecnologiaEntity entitySaved = altroTecnologiaService.save(entityToDelete);
        assertNotNull(altroTecnologiaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<AltroTecnologiaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        altroTecnologiaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroTecnologiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroTecnologiaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroTecnologiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroTecnologiaService.deleteAll(altroTecnologiaService.findAll());

            assertTrue(StreamSupport.stream(altroTecnologiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        AltroTecnologiaEntity entityToDelete = new AltroTecnologiaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        AltroTecnologiaEntity entitySaved = altroTecnologiaService.save(entityToDelete);
        assertNotNull(altroTecnologiaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        altroTecnologiaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            altroTecnologiaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(altroTecnologiaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(altroTecnologiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            altroTecnologiaService.deleteAll(altroTecnologiaService.findAll());
            assertTrue(StreamSupport.stream(altroTecnologiaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
