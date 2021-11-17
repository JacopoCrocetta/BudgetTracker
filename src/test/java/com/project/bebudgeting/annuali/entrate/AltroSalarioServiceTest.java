package com.project.bebudgeting.annuali.entrate;

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

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.AltroSalarioEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.AltroSalarioService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AltroSalarioServiceTest {

	private static final LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 8);
	private static final String DESCRIZIONE = "Descrizione test";
	private static final BigDecimal TOTALE_MENSILE = new BigDecimal(123);

	@Autowired
	AltroSalarioService altroSalarioService;

	// COUNT TEST
	@Test
	void countAllAltroSalarioEntitiesTest() {
		AltroSalarioEntity entityToDelete = new AltroSalarioEntity();
		entityToDelete.setData_inserimento(LOCAL_DATE);
		entityToDelete.setDescrizione(DESCRIZIONE);
		entityToDelete.setTotale_mensile(TOTALE_MENSILE);

		// add the entity
		AltroSalarioEntity entitySaved = altroSalarioService.save(entityToDelete);
		assertNotNull(altroSalarioService.findById(entitySaved.getId()).get());
		assertTrue(altroSalarioService.count() != 0);

		altroSalarioService.delete(entityToDelete);
	}

	// FIND TEST
	@Test
	void findAllAltroSalarioEntitiesTest() {
		// SAVING SOME ENTITY TO TEST
		AltroSalarioEntity entityToSave = new AltroSalarioEntity();
		entityToSave.setData_inserimento(LOCAL_DATE);
		entityToSave.setDescrizione(DESCRIZIONE);
		entityToSave.setTotale_mensile(TOTALE_MENSILE);

		assertTrue(altroSalarioService.save(entityToSave) != null);

		// TEST THE FIND
		assertTrue(altroSalarioService.findAll() != null);
	}

	@Test
	void findBySalarioIdTest() {
		// SAVING SOME ENTITY TO TEST
		AltroSalarioEntity entityToSave = new AltroSalarioEntity();
		entityToSave.setData_inserimento(LOCAL_DATE);
		entityToSave.setDescrizione(DESCRIZIONE);
		entityToSave.setTotale_mensile(TOTALE_MENSILE);

		assertTrue(altroSalarioService.save(entityToSave) != null);

		// TEST THE FIND
		assertTrue(altroSalarioService.findBySalarioId(entityToSave.getId()) != null);
	}

	@Test
	void findAllByIdTest() {
		// SAVING SOME ENTITY TO TEST
		AltroSalarioEntity entityToSave = new AltroSalarioEntity();
		entityToSave.setData_inserimento(LOCAL_DATE);
		entityToSave.setDescrizione(DESCRIZIONE);
		entityToSave.setTotale_mensile(TOTALE_MENSILE);

		assertTrue(altroSalarioService.save(entityToSave) != null);

		// TEST THE FIND
		Iterable<Integer> ids = Arrays.asList(entityToSave.getId());

		assertTrue(altroSalarioService.findAllById(ids) != null);
	}

	@Test
	void findById() {
		// SAVE ONE ENTITY
		AltroSalarioEntity entityToSave = new AltroSalarioEntity();
		entityToSave.setData_inserimento(LOCAL_DATE);
		entityToSave.setDescrizione(DESCRIZIONE);
		entityToSave.setTotale_mensile(TOTALE_MENSILE);

		assertTrue(altroSalarioService.save(entityToSave) != null);

		assertTrue(altroSalarioService.findById(entityToSave.getId()) != null);
	}

	// SAVE TEST
	@Test
	public void saveTest() {
		AltroSalarioEntity entityToSave = new AltroSalarioEntity();
		entityToSave.setData_inserimento(LOCAL_DATE);
		entityToSave.setDescrizione(DESCRIZIONE);
		entityToSave.setTotale_mensile(TOTALE_MENSILE);
		entityToSave.setId(10);

		assertTrue(altroSalarioService.save(entityToSave) != null);
	}

	// DELETE
	@Test
	public void deleteTests() {
		AltroSalarioEntity entityToDelete = new AltroSalarioEntity();
		entityToDelete.setData_inserimento(LOCAL_DATE);
		entityToDelete.setDescrizione(DESCRIZIONE);
		entityToDelete.setTotale_mensile(TOTALE_MENSILE);

		// add the entity
		AltroSalarioEntity entitySaved = altroSalarioService.save(entityToDelete);
		assertNotNull(altroSalarioService.findById(entitySaved.getId()).get());

		// add a rigorous compare method to make sure contents are the same, i.e.
		// nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
		assertEquals(entityToDelete, entitySaved);

		// remove the entity
		altroSalarioService.delete(entityToDelete);

		Exception exception = assertThrows(NoSuchElementException.class, () -> {
			altroSalarioService.findById(entityToDelete.getId()).get();
		});
		assertNotNull(exception.getMessage());
	}

	@Test
	public void deleteAllTest() {
		AltroSalarioEntity entityToDelete = new AltroSalarioEntity();
		entityToDelete.setData_inserimento(LOCAL_DATE);
		entityToDelete.setDescrizione(DESCRIZIONE);
		entityToDelete.setTotale_mensile(TOTALE_MENSILE);

		// add the entity
		AltroSalarioEntity entitySaved = altroSalarioService.save(entityToDelete);
		assertNotNull(altroSalarioService.findById(entitySaved.getId()).get());

		assertEquals(entityToDelete, entitySaved);

		// remove the entity
		altroSalarioService.deleteAll();

		Exception exception = assertThrows(NoSuchElementException.class, () -> {
			altroSalarioService.findById(entityToDelete.getId()).get();
		});
		assertNotNull(exception.getMessage());

		List<AltroSalarioEntity> aIterable = StreamSupport.stream(altroSalarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		assertTrue(aIterable.size() == 0);
	}

	@Test
	public void deleteAllEntitiesTest() {

		AltroSalarioEntity entityToDelete = new AltroSalarioEntity();
		entityToDelete.setData_inserimento(LOCAL_DATE);
		entityToDelete.setDescrizione(DESCRIZIONE);
		entityToDelete.setTotale_mensile(TOTALE_MENSILE);

		// add the entity
		AltroSalarioEntity entitySaved = altroSalarioService.save(entityToDelete);
		assertNotNull(altroSalarioService.findById(entitySaved.getId()).get());

		assertEquals(entityToDelete, entitySaved);

		Iterable<AltroSalarioEntity> aIterable = Arrays.asList(entityToDelete);
		// remove the entity
		altroSalarioService.deleteAll(aIterable);

		Exception exception = assertThrows(NoSuchElementException.class, () -> {
			altroSalarioService.findById(entityToDelete.getId()).get();
		});
		assertNotNull(exception.getMessage());

		if (StreamSupport.stream(altroSalarioService.findAll().spliterator(), false).collect(Collectors.toList())
				.size() == 0) {
			assertTrue(StreamSupport.stream(altroSalarioService.findAll().spliterator(), false)
					.collect(Collectors.toList()).size() == 0);
		} else {
			altroSalarioService.deleteAll(altroSalarioService.findAll());

			assertTrue(StreamSupport.stream(altroSalarioService.findAll().spliterator(), false)
					.collect(Collectors.toList()).size() == 0);
		}
	}

	@Test
	void deleteAllByIdsTest() {
		AltroSalarioEntity entityToDelete = new AltroSalarioEntity();
		entityToDelete.setData_inserimento(LOCAL_DATE);
		entityToDelete.setDescrizione(DESCRIZIONE);
		entityToDelete.setTotale_mensile(TOTALE_MENSILE);

		// add the entity
		AltroSalarioEntity entitySaved = altroSalarioService.save(entityToDelete);
		assertNotNull(altroSalarioService.findById(entitySaved.getId()).get());

		assertEquals(entityToDelete, entitySaved);

		Iterable<Integer> ids = Arrays.asList(entityToDelete.getId());

		// remove the entity
		altroSalarioService.deleteAllById(ids);

		Exception exception = assertThrows(NoSuchElementException.class, () -> {
			altroSalarioService.findById(entityToDelete.getId()).get();
		});
		assertNotNull(exception.getMessage());

		if (StreamSupport.stream(altroSalarioService.findAll().spliterator(), false).collect(Collectors.toList())
				.size() == 0) {
			assertTrue(StreamSupport.stream(altroSalarioService.findAll().spliterator(), false)
					.collect(Collectors.toList()).size() == 0);
		} else {
			altroSalarioService.deleteAll(altroSalarioService.findAll());

			assertTrue(StreamSupport.stream(altroSalarioService.findAll().spliterator(), false)
					.collect(Collectors.toList()).size() == 0);
		}
	}
}
