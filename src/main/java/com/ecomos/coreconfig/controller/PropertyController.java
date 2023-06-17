package com.ecomos.coreconfig.controller;

import com.ecomos.coreconfig.entities.Property;
import com.ecomos.coreconfig.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/properties")
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
            updatedProperty.setId(id);
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
