package io.pragra.learning.jpademo.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "table_book")
@NoArgsConstructor
@Data
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    private Long isbn;
    private String title;
    @OneToOne
    private Author author;
    private String category;
    private double price;

    public Book(Long isbn, String title, Author author, String category, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }
}
