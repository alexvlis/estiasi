package com.estiasi.restaurant;

import com.estiasi.restaurant.model.Restaurant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"management.server.port=0", "management.context-path=/admin"})
public class RestaurantControllerIntegrationTests extends AbstractRestaurantControllerTests {

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    @LocalServerPort
    private int port;

    @Test
    public void testGetById() {
        Restaurant restaurant = restTemplate.getForObject("http://localhost:" + port + "/v1/restaurants/?id=1",
                Restaurant.class);
        Assert.assertNotNull(restaurant);
        Assert.assertNotNull(restaurant.getId());
        Assert.assertEquals("Le Meurice", restaurant.getName());
        Assert.assertNotNull(restaurant.getCreated());
        Assert.assertNotNull(restaurant.getTables());
        Assert.assertEquals(0, restaurant.getTables().size());
    }

    @Test
    public void testGetByIdNonExisting() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate
                .exchange("http://localhost:" + port + "/v1/restaurants/99", HttpMethod.GET, entity,
                        Map.class);

        Assert.assertNotNull(response);
        // Should return no content as there is no restaurant with id 99
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
