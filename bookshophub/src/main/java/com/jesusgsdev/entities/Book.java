package com.jesusgsdev.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
@Table(name = "book")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(max = 140)
    @Column(length = 140)
    private String title;

    @DecimalMax("199.99")
    @DecimalMin("0.0")
    private Double price;

    @NotBlank
    @Length(max = 155)
    @Column(length = 155)
    private String author;

    @Min(1)
    private Integer pages;

    @NotBlank
    @Length(max = 140)
    @Column(length = 140)
    private String provider;

    public Book() { }

    public Book(String title, Double price, String author, Integer pages, String provider) {
        super();
        this.title = title;
        this.price = price;
        this.author = author;
        this.pages = pages;
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return new EqualsBuilder()
                .append(title, book.title)
                .append(price, book.price)
                .append(author, book.author)
                .append(pages, book.pages)
                .append(provider, book.provider)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(title)
                .append(price)
                .append(author)
                .append(pages)
                .append(provider)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("price", price)
                .append("author", author)
                .append("pages", pages)
                .append("provider", provider)
                .toString();
    }
}
