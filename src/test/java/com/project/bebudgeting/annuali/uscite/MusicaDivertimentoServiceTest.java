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

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.MusicaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.MusicaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MusicaDivertimentoServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    MusicaService musicaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        MusicaEntity entityToDelete = new MusicaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        MusicaEntity entitySaved = musicaService.save(entityToDelete);
        assertNotNull(musicaService.findById(entitySaved.getId()).get());
        assertTrue(musicaService.count() != 0);

        musicaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        MusicaEntity entityToSave = new MusicaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(musicaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(musicaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        MusicaEntity entityToSave = new MusicaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(musicaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(musicaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        MusicaEntity entityToSave = new MusicaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(musicaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(musicaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        MusicaEntity entityToSave = new MusicaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(musicaService.save(entityToSave) != null);

        assertTrue(musicaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        MusicaEntity entityToSave = new MusicaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(musicaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        MusicaEntity entityToDelete = new MusicaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        MusicaEntity entitySaved = musicaService.save(entityToDelete);
        assertNotNull(musicaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        musicaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            musicaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        MusicaEntity entityToDelete = new MusicaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        MusicaEntity entitySaved = musicaService.save(entityToDelete);
        assertNotNull(musicaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        musicaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            musicaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<MusicaEntity> aList = StreamSupport.stream(musicaService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        MusicaEntity entityToDelete = new MusicaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        MusicaEntity entitySaved = musicaService.save(entityToDelete);
        assertNotNull(musicaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<MusicaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        musicaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            musicaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(musicaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(musicaService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            musicaService.deleteAll(musicaService.findAll());

            assertTrue(StreamSupport.stream(musicaService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        MusicaEntity entityToDelete = new MusicaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        MusicaEntity entitySaved = musicaService.save(entityToDelete);
        assertNotNull(musicaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        musicaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            musicaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(musicaService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(musicaService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        } else {
            musicaService.deleteAll(musicaService.findAll());
            assertTrue(StreamSupport.stream(musicaService.findAll().spliterator(), false).collect(Collectors.toList())
                    .size() == 0);
        }
    }
}
