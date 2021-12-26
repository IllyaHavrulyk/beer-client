package com.havrulyk.breweryclient.web.client;

import com.havrulyk.breweryclient.web.model.BeerDto;
import com.havrulyk.breweryclient.web.model.CustomerDto;
import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreweryClientTest {

  @Autowired
  private BreweryClient client;

  @Test
  void getBeerByIdTest() {
    BeerDto beerDto = client.getBeerById(UUID.randomUUID());
    Assertions.assertNotNull(beerDto);
  }

  @Test
  void saveNewBeerTest() {
    BeerDto beerDto = BeerDto.builder().build();
    URI saveNewBeerDtoOut = client.saveNewBeer(beerDto);
    Assertions.assertNotNull(saveNewBeerDtoOut);
  }

  @Test
  void updateBeerTest() {
    BeerDto beerDto = BeerDto.builder().build();
    UUID beerId = UUID.randomUUID();
    client.updateBeer(beerDto, beerId);
  }

  @Test
  void deleteBeerTest() {
    UUID beerId = UUID.randomUUID();
    client.deleteBeer(beerId);
  }

  @Test
  void getCustomerByIdTest(){
    UUID customerId = UUID.randomUUID();
    CustomerDto customerById = client.getCustomerById(customerId);
    Assertions.assertNotNull(customerById);
  }

  @Test
  void saveNewCustomerTest(){
    CustomerDto customerDto = CustomerDto.builder().build();
    URI customerLocation = client.saveNewCustomer(customerDto);
    Assertions.assertNotNull(customerLocation);
  }

  @Test
  void updateCustomerTest(){
    CustomerDto customerDto = CustomerDto.builder().build();
    UUID customerId = UUID.randomUUID();
    client.updateCustomer(customerDto, customerId);
  }

  @Test
  void deleteCustomerTest(){
    UUID customerId = UUID.randomUUID();
    client.deleteCustomer(customerId);
  }

}