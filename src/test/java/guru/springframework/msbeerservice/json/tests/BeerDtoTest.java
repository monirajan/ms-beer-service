package guru.springframework.msbeerservice.json.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.msbeerservice.web.model.BeerDto;

@JsonTest
public class BeerDtoTest extends BaseTest{
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void serialize() throws JsonProcessingException
	{
		String val = objectMapper.writeValueAsString(getDTO());
		System.out.println(val);
	}
	
	@Test
	public void deserialize() throws Exception
	{
		String val = "{\"id\":\"d050470e-95b1-4f4d-a308-77bcf0d02c5f\",\"version\":null,\"createdDate\":\"2021-06-16T12:04:00.5390496+05:30\",\"lastModifiedDate\":null,\"beerName\":\"Beer1\",\"beerStyle\":\"STYLE1\",\"upc\":\"123\",\"price\":10000,\"quantityOnHand\":null}";
		BeerDto beerDto = objectMapper.readValue(val, BeerDto.class);
		System.out.println(beerDto);
	}

}
