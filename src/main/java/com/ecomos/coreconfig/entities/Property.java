package com.ecomos.coreconfig.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "property")
public class Property extends BaseEntity {

    private String partnerId;
    private String key;
    private String value;

}
