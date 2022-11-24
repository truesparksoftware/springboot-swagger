package com.example.demo;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bike")
public class BikeController {
    @Autowired
    BikeRepository bikeJPARepository;

    @GetMapping("/getall/{id}")
    public Bike getData(@PathVariable Integer id) {
        Optional<Bike> b = bikeJPARepository.findById(id);
        Bike b1 = b.get();
        return b1;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Bike>> getAllData() {
        List<Bike> b = bikeJPARepository.findAll();
        return new ResponseEntity<List<Bike>>(b, HttpStatus.OK);
    }

    @PostMapping("/postdata")
    public Bike postData(@RequestBody Bike bike) {
        Bike b = bikeJPARepository.save(bike);
        return b;
    }

    @DeleteMapping("/deletedata/{id}")
    @Transactional
    public void deleteData(@PathVariable Integer id) {
        bikeJPARepository.deleteById(id);
    }

    @PutMapping("/updatedata/{id}")
    public void updateData(@PathVariable Integer id) {
        Optional<Bike> b = bikeJPARepository.findById(id);
        Bike b1 = b.get();
        b1.setName("Unknown");
        bikeJPARepository.saveAndFlush(b1);
    }
}
