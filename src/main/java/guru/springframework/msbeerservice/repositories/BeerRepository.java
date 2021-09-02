package guru.springframework.msbeerservice.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import guru.springframework.msbeerservice.domain.Beer;
import guru.springframework.msbeerservice.web.model.BeerStyleEnum;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>{
	
	Page<Beer> findAllByBeerName(String beerName, Pageable page);
	Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable page);
	Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable page);
}
  