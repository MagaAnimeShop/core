package vn.mega.coreconfig.entities;

import lombok.*;
import org.springframework.data.annotation.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Id
    private String id;

    @CreatedBy
    private String createBy;

    @CreatedDate
    private Date createStamp;

    @LastModifiedBy
    private String updateBy;

    @LastModifiedDate
    private Date updateStamp;
}
