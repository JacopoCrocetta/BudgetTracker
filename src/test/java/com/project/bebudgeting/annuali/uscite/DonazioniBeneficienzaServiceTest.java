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

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.DonazioniBeneficenzaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.regaliservice.DonazioniBeneficienzaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DonazioniBeneficienzaServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    DonazioniBeneficienzaService donazioniBeneficienzaService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        DonazioniBeneficenzaEntity entityToDelete = new DonazioniBeneficenzaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DonazioniBeneficenzaEntity entitySaved = donazioniBeneficienzaService.save(entityToDelete);
        assertNotNull(donazioniBeneficienzaService.findById(entitySaved.getId()).get());
        assertTrue(donazioniBeneficienzaService.count() != 0);

        donazioniBeneficienzaService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        DonazioniBeneficenzaEntity entityToSave = new DonazioniBeneficenzaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(donazioniBeneficienzaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(donazioniBeneficienzaService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        DonazioniBeneficenzaEntity entityToSave = new DonazioniBeneficenzaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(donazioniBeneficienzaService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(donazioniBeneficienzaService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        DonazioniBeneficenzaEntity entityToSave = new DonazioniBeneficenzaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(donazioniBeneficienzaService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(donazioniBeneficienzaService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        DonazioniBeneficenzaEntity entityToSave = new DonazioniBeneficenzaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(donazioniBeneficienzaService.save(entityToSave) != null);

        assertTrue(donazioniBeneficienzaService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        DonazioniBeneficenzaEntity entityToSave = new DonazioniBeneficenzaEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(donazioniBeneficienzaService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        DonazioniBeneficenzaEntity entityToDelete = new DonazioniBeneficenzaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DonazioniBeneficenzaEntity entitySaved = donazioniBeneficienzaService.save(entityToDelete);
        assertNotNull(donazioniBeneficienzaService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        donazioniBeneficienzaService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            donazioniBeneficienzaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        DonazioniBeneficenzaEntity entityToDelete = new DonazioniBeneficenzaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DonazioniBeneficenzaEntity entitySaved = donazioniBeneficienzaService.save(entityToDelete);
        assertNotNull(donazioniBeneficienzaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        donazioniBeneficienzaService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            donazioniBeneficienzaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<DonazioniBeneficenzaEntity> aList = StreamSupport
                .stream(donazioniBeneficienzaService.findAll().spliterator(), false).collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        DonazioniBeneficenzaEntity entityToDelete = new DonazioniBeneficenzaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DonazioniBeneficenzaEntity entitySaved = donazioniBeneficienzaService.save(entityToDelete);
        assertNotNull(donazioniBeneficienzaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<DonazioniBeneficenzaEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        donazioniBeneficienzaService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            donazioniBeneficienzaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(donazioniBeneficienzaService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(donazioniBeneficienzaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            donazioniBeneficienzaService.deleteAll(donazioniBeneficienzaService.findAll());

            assertTrue(StreamSupport.stream(donazioniBeneficienzaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        DonazioniBeneficenzaEntity entityToDelete = new DonazioniBeneficenzaEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        DonazioniBeneficenzaEntity entitySaved = donazioniBeneficienzaService.save(entityToDelete);
        assertNotNull(donazioniBeneficienzaService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        donazioniBeneficienzaService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            donazioniBeneficienzaService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(donazioniBeneficienzaService.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(donazioniBeneficienzaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            donazioniBeneficienzaService.deleteAll(donazioniBeneficienzaService.findAll());
            assertTrue(StreamSupport.stream(donazioniBeneficienzaService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
