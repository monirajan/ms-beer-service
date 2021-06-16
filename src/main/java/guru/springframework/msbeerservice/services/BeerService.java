package guru.springframework.msbeerservice.services;

import java.util.UUID;

import org.springframework.util.MultiValueMap;

import guru.springframework.msbeerservice.web.model.BeerDto;

public interface BeerService {

	BeerDto getById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

}
