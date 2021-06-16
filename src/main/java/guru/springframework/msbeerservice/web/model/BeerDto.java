package guru.springframework.msbeerservice.web.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

		@JsonProperty("beerId")
		@Null
	 	private UUID id;
		
		@Null
	    private Integer version;

		@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape = Shape.STRING)
		@Null
	    private OffsetDateTime createdDate;
		
		@Null
	    private OffsetDateTime lastModifiedDate;

		@NotBlank
	    private String beerName;

		@NotNull
	    private BeerStyleEnum beerStyle;

	    @NotNull
	    private String upc;

	    @NotNull
	    @Positive
	    @JsonFormat(shape = Shape.STRING)
	    private BigDecimal price;

	    private Integer quantityOnHand;
	    
//	    @JsonSerialize(using = LocalDateSerializer.class)
//	    @JsonDeserialize(using = LocalDateDeserializer.class)
//	    LocalDate locDate;
	
}
