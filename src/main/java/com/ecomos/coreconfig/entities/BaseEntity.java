package com.ecomos.coreconfig.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public abstract class BaseEntity {

    @Id
    private String id;

    private String createBy;

    @CreatedDate
    private String createStamp;

    private String updateBy;

    private String updateStamp;
}
