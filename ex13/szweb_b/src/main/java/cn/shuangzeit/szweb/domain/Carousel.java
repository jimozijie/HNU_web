package cn.shuangzeit.szweb.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(of="id",callSuper=false)
@Document
public class Carousel extends BaseEntity {
    @Id
    private String id;
    private String imgUrl;
    private String  content;
    private Integer hit;
}
