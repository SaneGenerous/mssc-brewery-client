package tp.msk.msscbreweyclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tp.msk.msscbreweyclient.web.model.BeerDTO;
import tp.msk.msscbreweyclient.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDTO beerDTO = client.getBeerById(UUID.randomUUID());

        assertNotNull(beerDTO);
    }

    @Test
    void testSaveNewBeer(){
        BeerDTO beerDTO1 = BeerDTO.builder().beerName("New Lemonade").build();
        URI uri = client.saveNewBeer(beerDTO1);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDTO beerDTO = BeerDTO.builder().beerName("New Soda").build();

        client.updateBeer(UUID.randomUUID(), beerDTO);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
    @Test
    void getCustomerById() {
        CustomerDTO customerDTO = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDTO);
    }

    @Test
    void saveNewCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder().customerName("Ali Jaber").build();
        URI uri = client.saveNewCustomer(customerDTO);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateCustomer() {
        //given
        CustomerDTO customerDTO = CustomerDTO.builder().customerName("New Customer").build();

        client.updateCustomer(UUID.randomUUID(), customerDTO);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}