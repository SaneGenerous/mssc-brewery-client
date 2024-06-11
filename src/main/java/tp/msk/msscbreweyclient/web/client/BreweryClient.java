package tp.msk.msscbreweyclient.web.client;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tp.msk.msscbreweyclient.web.model.BeerDTO;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "msk.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    private final String BEER_PATH_V1 = "/api/v1/beer/";
    @Setter
    private String apihost;

    private RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID beerId){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + beerId.toString(), BeerDTO.class);
    }
}
