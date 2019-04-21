package com.dtb.mymoneyappapi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtb.mymoneyappapi.model.entity.BillingCycles;
import com.dtb.mymoneyappapi.model.entity.Credit;
import com.dtb.mymoneyappapi.model.entity.Debit;
import com.dtb.mymoneyappapi.repository.BillingCyclesRepository;
import com.dtb.mymoneyappapi.service.impl.BillingCyclesServiceImpl;

@RunWith(SpringRunner.class)
public class BillingCyclesServiceTest {
	@Mock
	private BillingCyclesRepository repository;
	@InjectMocks
	private BillingCyclesServiceImpl service;
	private BillingCycles cycles;
	private BillingCycles cycles2;
	private BillingCycles cycles3;
	
	@Before
	public void init() {
		Credit c1 = Credit.builder()._id(new ObjectId().toHexString()).name("Credit 1").value(20000).build();
		Credit c2 = Credit.builder()._id(new ObjectId().toHexString()).name("Credit 2").value(20000).build();
		Credit c3 = Credit.builder()._id(new ObjectId().toHexString()).name("Credit 3").value(20000).build();
		Debit d1 = Debit.builder()._id(new ObjectId().toHexString()).name("Debit 1").value(500).build();
		Debit d2 = Debit.builder()._id(new ObjectId().toHexString()).name("Debit 2").value(500).build();		
		cycles = BillingCycles.builder()._id(new ObjectId().toHexString()).name("Name").credits(Arrays.asList(c1,c2,c3)).debits(Arrays.asList(d1,d2)).build();
		cycles2 = BillingCycles.builder()._id(new ObjectId().toHexString()).name("Name 2").credits(Arrays.asList(c1,c3)).debits(Arrays.asList(d2)).build();
		cycles3 = BillingCycles.builder()._id(new ObjectId().toHexString()).name("Name 3").credits(Arrays.asList(c1)).build();
	}
	
	@Test
	public void testSummary() {
		when(repository.findAll()).thenReturn(Arrays.asList(cycles,cycles2,cycles3));
		
		assertEquals(service.summaryCreditsAndDebits().get("credits"), Double.valueOf(20000*6));
		assertEquals(service.summaryCreditsAndDebits().get("debits"), Double.valueOf((500*2)+(500)));
	}
}
