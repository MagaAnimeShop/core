package com.ecomos.coreconfig;

import com.ecomos.coreconfig.controller.PropertyController;
import com.ecomos.coreconfig.entities.Property;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBase {

    @Autowired
    private PropertyController propertyController;

    @Test
    public void testCreateDay(){
        propertyController.addProperty(Property.builder().key("tawat").value("123").build());

    }
}
