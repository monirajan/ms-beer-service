package guru.springframework.msbeerservice.services.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msbeerservice.bootstrap.BeerLoader;

@Disabled
@SpringBootTest
class BeerInventoryServiceRestTemplateImplTest {
	
	@Autowired
	BeerInventoryService beerInventoryService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetOnHandInventory() {
		
		Integer qoh = beerInventoryService.getOnHandInventory(BeerLoader.BEER_1_UUID);
		System.out.println(qoh);
	}

}
