package com.ecomos.coreconfig.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Id
    private String id;

    private String createBy;

    @CreatedDate
    private Date createStamp;

    private String updateBy;

    @LastModifiedDate
    private Date updateStamp;
}
