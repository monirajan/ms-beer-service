package guru.springframework.msbeerservice.json.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.msbeerservice.web.model.BeerDto;

@ActiveProfiles("kebab")
@JsonTest
public class BeerKebabTest extends BaseTest {
	
	@Autowired
	 ObjectMapper objectMapper;

	 @Test
	 void testSnake() throws JsonProcessingException {
	        BeerDto dto = getDTO();
	        String json = objectMapper.writeValueAsString(dto);
	        System.out.println(json);
	 }

}
