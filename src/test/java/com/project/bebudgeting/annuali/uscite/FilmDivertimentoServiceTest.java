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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.FilmEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.FilmService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FilmDivertimentoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    FilmService filmService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        FilmEntity entityToDelete = new FilmEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FilmEntity entitySaved = filmService.save(entityToDelete);
        assertNotNull(filmService.findById(entitySaved.getId()).get());
        assertTrue(filmService.count() != 0);

        filmService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        FilmEntity entityToSave = new FilmEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(filmService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(filmService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        FilmEntity entityToSave = new FilmEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(filmService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(filmService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        FilmEntity entityToSave = new FilmEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(filmService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(filmService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        FilmEntity entityToSave = new FilmEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(filmService.save(entityToSave) != null);

        assertTrue(filmService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        FilmEntity entityToSave = new FilmEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(filmService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        FilmEntity entityToDelete = new FilmEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FilmEntity entitySaved = filmService.save(entityToDelete);
        assertNotNull(filmService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        filmService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            filmService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        FilmEntity entityToDelete = new FilmEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FilmEntity entitySaved = filmService.save(entityToDelete);
        assertNotNull(filmService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        filmService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            filmService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<FilmEntity> aList = StreamSupport.stream(filmService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        FilmEntity entityToDelete = new FilmEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FilmEntity entitySaved = filmService.save(entityToDelete);
        assertNotNull(filmService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<FilmEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        filmService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            filmService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(filmService.findAll().spliterator(), false).collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(filmService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            filmService.deleteAll(filmService.findAll());

            assertTrue(StreamSupport.stream(filmService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        FilmEntity entityToDelete = new FilmEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        FilmEntity entitySaved = filmService.save(entityToDelete);
        assertNotNull(filmService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        filmService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            filmService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(filmService.findAll().spliterator(), false).collect(Collectors.toList()).size() == 0) {
            assertTrue(StreamSupport.stream(filmService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            filmService.deleteAll(filmService.findAll());
            assertTrue(StreamSupport.stream(filmService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
