package guru.springframework.msbeerservice.json.tests;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import guru.springframework.msbeerservice.web.model.BeerDto;
import guru.springframework.msbeerservice.web.model.BeerStyleEnum;

public class BaseTest {
	
	BeerDto getDTO()
	{
		return BeerDto.builder()
				.beerName("Beer1")
				.beerStyle(BeerStyleEnum.STYLE1)
				.createdDate(OffsetDateTime.now())
				.id(UUID.randomUUID())
				.upc("123")
				.price(new BigDecimal("10000"))
				.build();
				
	}

}
