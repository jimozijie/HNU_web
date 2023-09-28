package cn.shuangzeit.szweb.domain;

import cn.shuangzeit.szweb.dto.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=false,of="id")
@Document
public class Menu extends BaseEntity implements Comparable<Menu>{
    @Id
    private String id;
    private String name;
    private String icon;
    private String parent;
    private List<Menu> items;
    private List<Role> authorities;
    @CreatedDate
    private LocalDateTime createTime;

    @Override
    public int compareTo(Menu o) {
        return createTime.compareTo(o.createTime);
    }
}
