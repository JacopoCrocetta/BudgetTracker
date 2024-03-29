package com.project.bebudgeting.annuali.entrate;

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

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.CommissioniEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.CommissioniService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommissioniServiceTest {
    private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
    private static final String DESCRIZIONE = "Descrizione test";
    private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

    @Autowired
    CommissioniService commissioniService;

    // COUNT TEST
    @Test
    public void countAllAltroSalarioEntitiesTest() {
        CommissioniEntity entityToDelete = new CommissioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        CommissioniEntity entitySaved = commissioniService.save(entityToDelete);
        assertNotNull(commissioniService.findById(entitySaved.getId()).get());
        assertTrue(commissioniService.count() != 0);

        commissioniService.delete(entityToDelete);
    }

    // FIND TEST
    @Test
    public void findAllAltroSalarioEntitiesTest() {
        // SAVING SOME ENTITY TO TEST
        CommissioniEntity entityToSave = new CommissioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(commissioniService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(commissioniService.findAll() != null);
    }

    @Test
    public void findBySalarioIdTest() {
        // SAVING SOME ENTITY TO TEST
        CommissioniEntity entityToSave = new CommissioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(commissioniService.save(entityToSave) != null);

        // TEST THE FIND
        assertTrue(commissioniService.findById(entityToSave.getId()) != null);
    }

    @Test
    public void findAllByIdTest() {
        // SAVING SOME ENTITY TO TEST
        CommissioniEntity entityToSave = new CommissioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(commissioniService.save(entityToSave) != null);

        // TEST THE FIND
        Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

        assertTrue(commissioniService.findAllById(ids) != null);
    }

    @Test
    public void findById() {
        // SAVE ONE ENTITY
        CommissioniEntity entityToSave = new CommissioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);

        assertTrue(commissioniService.save(entityToSave) != null);

        assertTrue(commissioniService.findById(entityToSave.getId()) != null);
    }

    // SAVE TEST
    @Test
    public void saveTest() {
        CommissioniEntity entityToSave = new CommissioniEntity();
        entityToSave.setData_inserimento(LOCAL_DATE);
        entityToSave.setDescrizione(DESCRIZIONE);
        entityToSave.setTotale_mensile(TOTALE_MENSILE);
        entityToSave.setId(10);

        assertTrue(commissioniService.save(entityToSave) != null);
    }

    // DELETE
    @Test
    public void deleteTests() {
        CommissioniEntity entityToDelete = new CommissioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        CommissioniEntity entitySaved = commissioniService.save(entityToDelete);
        assertNotNull(commissioniService.findById(entitySaved.getId()).get());

        // add a rigorous compare method to make sure contents are the same, i.e.
        // nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        commissioniService.delete(entityToDelete);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            commissioniService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void deleteAllTest() {
        CommissioniEntity entityToDelete = new CommissioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        CommissioniEntity entitySaved = commissioniService.save(entityToDelete);
        assertNotNull(commissioniService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        // remove the entity
        commissioniService.deleteAll();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            commissioniService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        List<CommissioniEntity> aList = StreamSupport.stream(commissioniService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(aList.size() == 0);
    }

    @Test
    public void deleteAllEntitiesTest() {

        CommissioniEntity entityToDelete = new CommissioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        CommissioniEntity entitySaved = commissioniService.save(entityToDelete);
        assertNotNull(commissioniService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<CommissioniEntity> aIterable = Arrays.asList(entityToDelete);
        // remove the entity
        commissioniService.deleteAll(aIterable);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            commissioniService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(commissioniService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(commissioniService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            commissioniService.deleteAll(commissioniService.findAll());

            assertTrue(StreamSupport.stream(commissioniService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }

    @Test
    public void deleteAllByIdsTest() {
        CommissioniEntity entityToDelete = new CommissioniEntity();
        entityToDelete.setData_inserimento(LOCAL_DATE);
        entityToDelete.setDescrizione(DESCRIZIONE);
        entityToDelete.setTotale_mensile(TOTALE_MENSILE);

        // add the entity
        CommissioniEntity entitySaved = commissioniService.save(entityToDelete);
        assertNotNull(commissioniService.findById(entitySaved.getId()).get());

        assertEquals(entityToDelete, entitySaved);

        Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

        // remove the entity
        commissioniService.deleteAllById(ids);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            commissioniService.findById(entityToDelete.getId()).get();
        });
        assertNotNull(exception.getMessage());

        if (StreamSupport.stream(commissioniService.findAll().spliterator(), false).collect(Collectors.toList())
                .size() == 0) {
            assertTrue(StreamSupport.stream(commissioniService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        } else {
            commissioniService.deleteAll(commissioniService.findAll());
            assertTrue(StreamSupport.stream(commissioniService.findAll().spliterator(), false)
                    .collect(Collectors.toList()).size() == 0);
        }
    }
}
