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
		String val = "{\"version\":null,\"createdDate\":\"2021-06-16T13:13:22+0530\",\"lastModifiedDate\":\"2021-06-16T13:13:22.9129979+05:30\",\"beerName\":\"Beer1\",\"beerStyle\":\"STYLE1\",\"upc\":\"123\",\"price\":\"10000\",\"quantityOnHand\":null,\"locDate\":\"2021-06-16\",\"beerId\":\"b4543c07-f344-4402-ae2c-a0fc751510ea\"}";
		BeerDto beerDto = objectMapper.readValue(val, BeerDto.class);
		System.out.println(beerDto);
	}

}
