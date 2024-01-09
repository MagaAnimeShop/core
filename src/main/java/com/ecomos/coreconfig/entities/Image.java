package com.ecomos.coreconfig.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "image")
public class Image extends BaseEntity {

    private String imageName;

    private String imageUrl;

    private Integer sequence;
}
