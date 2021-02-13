package io.pragra.learning.jpademo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="Table_Authors")
@Data
@NoArgsConstructor
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String company;
    private String institution;
    private Date createDate;
    private Date updateDate;
    private StatusEnum status;

    public Author(String name, String company, String institution, Date createDate, Date updateDate, StatusEnum status) {
        this.name = name;
        this.company = company;
        this.institution = institution;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }
}
