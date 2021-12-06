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

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HostingEntity;
import com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice.HostingService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HostingServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    HostingService hostingService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        HostingEntity entityToDelete = new HostingEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HostingEntity entitySaved = hostingService.save(entityToDelete);
        assertNotNull(hostingService.findById(entitySaved.getId()).get());
        assertTrue(hostingService.count() != 0);

        hostingService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        HostingEntity entityToSave = new HostingEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(hostingService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(hostingService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        HostingEntity entityToSave = new HostingEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(hostingService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(hostingService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        HostingEntity entityToSave = new HostingEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(hostingService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(hostingService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        HostingEntity entityToSave = new HostingEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(hostingService.save(entityToSave) != null);

        assertTrue(hostingService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        HostingEntity entityToSave = new HostingEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(hostingService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        HostingEntity entityToDelete = new HostingEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HostingEntity entitySaved = hostingService.save(entityToDelete);
        assertNotNull(hostingService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        hostingService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            hostingService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        HostingEntity entityToDelete = new HostingEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HostingEntity entitySaved = hostingService.save(entityToDelete);
        assertNotNull(hostingService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        hostingService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            hostingService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<HostingEntity> aList = StreamSupport
                .stream(hostingService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        HostingEntity entityToDelete = new HostingEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HostingEntity entitySaved = hostingService.save(entityToDelete);
        assertNotNull(hostingService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<HostingEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        hostingService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            hostingService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(hostingService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(hostingService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            hostingService.deleteAll(hostingService.findAll());

            assertTrue(StreamSupport.stream(hostingService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        HostingEntity entityToDelete = new HostingEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        HostingEntity entitySaved = hostingService.save(entityToDelete);
        assertNotNull(hostingService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        hostingService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            hostingService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(hostingService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(hostingService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            hostingService.deleteAll(hostingService.findAll());
            assertTrue(StreamSupport.stream(hostingService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
