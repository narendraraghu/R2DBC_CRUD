package com.narendra.r2dbc;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("public.categories")
public class Category {

    @Id
    private Integer id;
    private String name;
}
