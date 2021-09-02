package guru.springframework.msbeerservice.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import guru.springframework.msbeerservice.domain.Beer;
import guru.springframework.msbeerservice.services.inventory.BeerInventoryService;
import guru.springframework.msbeerservice.web.model.BeerDto;

public abstract class BeerMapperDecorator implements BeerMapper{
	
	private BeerInventoryService beerInventoryService;
	private BeerMapper beerMapper;
	
	@Autowired
	public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
		this.beerInventoryService = beerInventoryService;
	}
	
	@Autowired
	public void setBeerMapper(BeerMapper beerMapper) {
		this.beerMapper = beerMapper;
	}
	
	 @Override
	 public BeerDto beerToBeerDto(Beer beer) {
		 return beerMapper.beerToBeerDto(beer);
	 }

	 @Override
	 public Beer beerDtoToBeer(BeerDto beerDto) {
		 return beerMapper.beerDtoToBeer(beerDto);
	 }
	 
	 @Override
	public BeerDto beerToBeerDtoWithInventory(Beer beer) {
		 BeerDto dto = beerMapper.beerToBeerDto(beer);
	     dto.setQuantityOnHand(beerInventoryService.getOnHandInventory(beer.getId()));
	     return dto;
	 }

}
