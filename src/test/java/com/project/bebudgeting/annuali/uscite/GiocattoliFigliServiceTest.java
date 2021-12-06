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

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.GiocattoliFigliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.GiocattoliFigliService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GiocattoliFigliServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    GiocattoliFigliService giocattoliFigliService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        GiocattoliFigliEntity entityToDelete = new GiocattoliFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        GiocattoliFigliEntity entitySaved = giocattoliFigliService.save(entityToDelete);
        assertNotNull(giocattoliFigliService.findById(entitySaved.getId()).get());
        assertTrue(giocattoliFigliService.count() != 0);

        giocattoliFigliService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        GiocattoliFigliEntity entityToSave = new GiocattoliFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(giocattoliFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(giocattoliFigliService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        GiocattoliFigliEntity entityToSave = new GiocattoliFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(giocattoliFigliService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(giocattoliFigliService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        GiocattoliFigliEntity entityToSave = new GiocattoliFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(giocattoliFigliService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(giocattoliFigliService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        GiocattoliFigliEntity entityToSave = new GiocattoliFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(giocattoliFigliService.save(entityToSave) != null);

        assertTrue(giocattoliFigliService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        GiocattoliFigliEntity entityToSave = new GiocattoliFigliEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(giocattoliFigliService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        GiocattoliFigliEntity entityToDelete = new GiocattoliFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        GiocattoliFigliEntity entitySaved = giocattoliFigliService.save(entityToDelete);
        assertNotNull(giocattoliFigliService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        giocattoliFigliService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            giocattoliFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        GiocattoliFigliEntity entityToDelete = new GiocattoliFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        GiocattoliFigliEntity entitySaved = giocattoliFigliService.save(entityToDelete);
        assertNotNull(giocattoliFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        giocattoliFigliService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            giocattoliFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<GiocattoliFigliEntity> aList = StreamSupport
                .stream(giocattoliFigliService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        GiocattoliFigliEntity entityToDelete = new GiocattoliFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        GiocattoliFigliEntity entitySaved = giocattoliFigliService.save(entityToDelete);
        assertNotNull(giocattoliFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<GiocattoliFigliEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        giocattoliFigliService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            giocattoliFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(giocattoliFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(giocattoliFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            giocattoliFigliService.deleteAll(giocattoliFigliService.findAll());

            assertTrue(StreamSupport.stream(giocattoliFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        GiocattoliFigliEntity entityToDelete = new GiocattoliFigliEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        GiocattoliFigliEntity entitySaved = giocattoliFigliService.save(entityToDelete);
        assertNotNull(giocattoliFigliService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        giocattoliFigliService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            giocattoliFigliService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(giocattoliFigliService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(giocattoliFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            giocattoliFigliService.deleteAll(giocattoliFigliService.findAll());
            assertTrue(StreamSupport.stream(giocattoliFigliService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
