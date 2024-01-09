package vn.mega.coreconfig.controller;

import vn.mega.coreconfig.entities.Property;
import vn.mega.coreconfig.repository.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/properties")
@Slf4j
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable String id) {
        return propertyRepository.findById(id).get();
    }

    @GetMapping("/{key}")
    public Property getPropertyByKey(@PathVariable String key) {
        return propertyRepository.findByKey(key);
    }


    @PostMapping
    public Property addProperty(@ModelAttribute Property property) {
        return propertyRepository.save(property);
    }


    @PutMapping("/{id}")
    public Property updateProperty(@PathVariable String id, @RequestBody Property updatedProperty) {
        Optional<Property> property = propertyRepository.findById(id);
        if (property.isPresent()) {
            return propertyRepository.save(updatedProperty);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable String id) {
        propertyRepository.deleteById(id);
    }

}
