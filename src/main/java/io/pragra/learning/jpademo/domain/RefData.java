package io.pragra.learning.jpademo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@ToString
public class RefData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private String value;

    public RefData(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
