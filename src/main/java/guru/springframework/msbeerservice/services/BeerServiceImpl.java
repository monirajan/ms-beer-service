package guru.springframework.msbeerservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msbeerservice.domain.Beer;
import guru.springframework.msbeerservice.repositories.BeerRepository;
import guru.springframework.msbeerservice.web.controller.NotFoundException;
import guru.springframework.msbeerservice.web.mappers.BeerMapper;
import guru.springframework.msbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService{

	private final BeerRepository beerRepo;
	private final BeerMapper beerMapper;
	
	@Override
	public BeerDto getById(UUID beerId) {
		return beerMapper.beerToBeerDto(
				beerRepo.findById(beerId).orElseThrow(NotFoundException::new)
				);
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {	
		Beer savedBeer = beerRepo.save(beerMapper.beerDtoToBeer(beerDto));
		return beerMapper.beerToBeerDto(savedBeer);
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		Beer beer = beerRepo.findById(beerId).orElseThrow(NotFoundException::new);
		
		beer.setBeerName(beerDto.getBeerName());
		beer.setBeerStyle(beerDto.getBeerStyle().name());
		beer.setPrice(beerDto.getPrice());
		beer.setUpc(beerDto.getUpc());
		return beerMapper.beerToBeerDto(beer);
	}

}
