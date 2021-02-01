package com.springboot.restproject1.repository;

import com.springboot.restproject1.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

   Hotel findByName(String name);
}
