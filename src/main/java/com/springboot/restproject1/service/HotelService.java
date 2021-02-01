package com.springboot.restproject1.service;

import com.springboot.restproject1.model.Hotel;
import com.springboot.restproject1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* It is service class of hotels and it will talk to our repository
 and all http method will be created here */

@Service
public class HotelService {

    /* In order to communicate with repository
    we should inject repository here by creating
    an object of "HotelRepository" and use "@Autowired */

    @Autowired
    private HotelRepository repository;

    /* <--------- HTTP Methods ------------> */
    //POST --> To save a hotel data.
    public Hotel saveHotel(Hotel hotel){
        return repository.save(hotel);
    }
    //POST --> To save a list of hotels with data.
    public List<Hotel> saveHotelList(List<Hotel> hotels){
        return repository.saveAll(hotels);
    }

    //GET --> To fetch a hotel data by its id.
    public Hotel getHotelById(int id) {
        return repository.findById(id).orElse(null);
    }
    //GET --> To fetch a hotel data by its name.
    public Hotel getHotelByName(String name) {
        return repository.findByName(name);
    }
    //GET --> To fetch all hotels data.
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    //DELETE --> To delete hotel
    public String deleteHotel(int id){
        repository.deleteById(id);
        return "Hotel removed!" + id;
    }

    //UPDATE --> To update hotel data
    public Hotel updateHotel(Hotel hotel){
        Hotel currentHotel = repository.findById(hotel.getId()).orElse(null);
        currentHotel.setName(hotel.getName());
        currentHotel.setCapacity(hotel.getCapacity());
        currentHotel.setRate(hotel.getRate());
        return repository.save(currentHotel);
    }


}
