package guru.springframework.msbeerservice.services;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import guru.springframework.msbeerservice.domain.Beer;
import guru.springframework.msbeerservice.repositories.BeerRepository;
import guru.springframework.msbeerservice.web.controller.NotFoundException;
import guru.springframework.msbeerservice.web.mappers.BeerMapper;
import guru.springframework.msbeerservice.web.model.BeerDto;
import guru.springframework.msbeerservice.web.model.BeerPagedList;
import guru.springframework.msbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService{

	private final BeerRepository beerRepo;
	private final BeerMapper beerMapper;
	
	@Override
	public BeerDto getById(UUID beerId, Boolean showInventoryOnHand) {
		if(showInventoryOnHand) {
			return beerMapper.beerToBeerDtoWithInventory(
					beerRepo.findById(beerId).orElseThrow(NotFoundException::new)
					);
		}
		else {
		return beerMapper.beerToBeerDto(
				beerRepo.findById(beerId).orElseThrow(NotFoundException::new)
				);
		}
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

	@Override
	public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {
		
		BeerPagedList beerPagedList;
		Page<Beer> beerPage;
		
		if(!ObjectUtils.isEmpty(beerName) && !ObjectUtils.isEmpty(beerStyle)) {
			beerPage = beerRepo.findAllByBeerNameAndBeerStyle(beerName, beerStyle, pageRequest);
		}
		else if(!ObjectUtils.isEmpty(beerName)) {
			beerPage = beerRepo.findAllByBeerName(beerName, pageRequest);
		}
		else if(!ObjectUtils.isEmpty(beerStyle)) {
			beerPage = beerRepo.findAllByBeerStyle(beerStyle, pageRequest);
		}
		else {
			beerPage = beerRepo.findAll(pageRequest);
		}
		
		if(showInventoryOnHand) {
			beerPagedList = new BeerPagedList(beerPage
					.getContent()
					.stream()
					.map(beerMapper::beerToBeerDtoWithInventory)
					.collect(Collectors.toList()),
					PageRequest.of(beerPage.getPageable().getPageNumber(), beerPage.getPageable().getPageSize()), 
					beerPage.getTotalElements());
		}
		else {
		beerPagedList = new BeerPagedList(beerPage
								.getContent()
								.stream()
								.map(beerMapper::beerToBeerDto)
								.collect(Collectors.toList()),
								PageRequest.of(beerPage.getPageable().getPageNumber(), beerPage.getPageable().getPageSize()), 
								beerPage.getTotalElements());
		}
		return beerPagedList;
	}

}
