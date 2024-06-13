package tp.msk.msscbreweyclient.web.client;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tp.msk.msscbreweyclient.web.model.BeerDTO;
import tp.msk.msscbreweyclient.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "msk.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private final String CUSTOMER_PATH_V1  = "/api/v1/customer/";
    @Setter
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID beerId){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + beerId.toString(), BeerDTO.class);
    }

    public URI saveNewBeer(BeerDTO beerDTO){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDTO);
    }

    public void updateBeer(UUID beerId, BeerDTO beerDTO){
        restTemplate.put(apihost + BEER_PATH_V1 + beerId.toString(), beerDTO);
    }

    public void deleteBeer(UUID beerId){
        restTemplate.delete(apihost + BEER_PATH_V1 + beerId.toString());
    }

    public CustomerDTO getCustomerById(UUID customerId){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDTO.class);
    }

    public URI saveNewCustomer(CustomerDTO customerDTO){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDTO);
    }

    public void updateCustomer(UUID customerId, CustomerDTO customerDTO){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId.toString(), customerDTO);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId.toString());
    }
}
