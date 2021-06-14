package guru.springframework.msbeerservice.web.mappers;

import org.mapstruct.Mapper;

import guru.springframework.msbeerservice.domain.Beer;
import guru.springframework.msbeerservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	
	Beer beerDtoToBeer(BeerDto beerDto);
	BeerDto beerToBeerDto(Beer beer);

}
