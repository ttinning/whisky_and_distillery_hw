package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskyByYear() {
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", foundWhiskies.get(0).getName());
	}

	@Test
	public void findWhiskyByRegion() {
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByRegion("Islay");
		assertEquals(2, foundDistilleries.size());
		assertEquals("Lagavulin", foundDistilleries.get(0).getName());
	}

	@Test
	public void findWhiskyFromDistilleryAtSpecificAge() {
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByDistilleryIdAndAgeGreaterThan(8L, 11);
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void findWhiskyByDistilleryLocation() {
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByDistilleryRegion("Islay");
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void findDistilleriesByWhiskyGreaterThan() {
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByWhiskiesAgeGreaterThan(12);
		assertEquals(10, foundDistilleries.size());
	}

}
