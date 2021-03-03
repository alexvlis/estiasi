package com.estiasi.restaurant;

import com.estiasi.restaurant.controller.RestaurantController;
import com.estiasi.restaurant.model.Restaurant;
import com.estiasi.restaurant.vo.RestaurantVO;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractRestaurantControllerTests {

    protected static final Integer RESTAURANT = 1;
    protected static final String RESTAURANT_NAME = "Le Meurice";
    protected static final String RESTAURANT_ADDRESS = "228 rue de Rivoli, 75001, Paris";
    private static boolean inited = false;

    @Autowired
    protected RestaurantController restaurantController;

    @Before
    public void before() throws Exception {
        if (inited) {
            return;
        }
        RestaurantVO restaurantVO = new RestaurantVO();
        restaurantVO.setName(RESTAURANT_NAME);
        restaurantController.createRestaurant(restaurantVO);
        inited = true;
    }

    @Test
    public void testGetRestaurantById() throws Exception {
        Restaurant restaurant = restaurantController.findById(RESTAURANT);
        Assert.assertEquals(RESTAURANT, restaurant.getId());
        Assert.assertEquals(RESTAURANT_NAME, restaurant.getName());
    }

    @Test
    public void testGetRestaurantByName() throws Exception {
        List<Restaurant> restaurants = restaurantController.findByName(RESTAURANT_NAME);
        Assert.assertEquals(1, restaurants.size());
        Restaurant restaurant = restaurants.get(0);
        Assert.assertEquals(RESTAURANT, restaurant.getId());
        Assert.assertEquals(RESTAURANT_NAME, restaurant.getName());
    }

    @Test
    public void testCreateRestaurant() throws Exception {
        RestaurantVO restaurantVO = new RestaurantVO();
        restaurantVO.setName("Test Restaurant");
        Restaurant restaurant = restaurantController.createRestaurant(restaurantVO);
        Assert.assertNotNull(restaurant.getId());
        Assert.assertEquals("Test Restaurant", restaurant.getName());
    }

}
