package com.dtb.mymoneyappapi.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtb.mymoneyappapi.model.entity.BillingCycles;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BillingCyclesRepositoryTest {
	@Autowired
	private BillingCyclesRepository repository;
	
	@Test
	public void testFindAll() {
		List<BillingCycles> cycles = repository.findAll();
		cycles.forEach(System.out::println);
		assertNotNull(cycles);
	}
	@Test
	public void testDeleteAll() {
		repository.deleteAll();
		assertTrue(repository.findAll().isEmpty());
	}
}
