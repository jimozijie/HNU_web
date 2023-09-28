package cn.shuangzeit.szweb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class BaseEntity {
    private String title;
    private LocalDateTime updateTime;
    private String updateUser;
}
