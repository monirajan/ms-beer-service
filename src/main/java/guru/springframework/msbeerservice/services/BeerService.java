package guru.springframework.msbeerservice.services;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.util.MultiValueMap;

import guru.springframework.msbeerservice.web.model.BeerDto;
import guru.springframework.msbeerservice.web.model.BeerPagedList;
import guru.springframework.msbeerservice.web.model.BeerStyleEnum;

public interface BeerService {
	
	BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

	BeerDto getById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

}
