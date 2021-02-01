package com.springboot.restproject1.controller;

import com.springboot.restproject1.model.Hotel;
import com.springboot.restproject1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//All the rest endpoint will be defined here
@RestController
public class HotelController {
    /* This controller talk to service class*/

    @Autowired
    private HotelService service;

    //POST --> Endpoints
   @PostMapping(value="/addHotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return service.saveHotel(hotel);
    }
    @PostMapping(value="/addHotelList")
    public List<Hotel> addHotelsList(@RequestBody List<Hotel> hotels){
        return service.saveHotelList(hotels);
    }

    //GET --> Endpoints
    @GetMapping(value="/hotelId/{id}")
    public Hotel getHotelById(@PathVariable int id) {
        return service.getHotelById(id);
    }
    @GetMapping(value="/hotelName/{name}")
    public Hotel getHotelByName(@PathVariable String name) {
        return service.getHotelByName(name);
    }
    @GetMapping(value="/all")
    public List<Hotel> getAllHotels() {
        return service.getAllHotels();
    }

    //PUT --> Endpoints
    @PutMapping(value="/update")
    public Hotel updateHotel(@RequestBody Hotel hotel){
        return service.updateHotel(hotel);
    }

    //DELETE --> Endpoints
    @DeleteMapping(value="/delete/{id}")
    public String deleteHotel(@PathVariable int id){
       return service.deleteHotel(id);
    }

}
