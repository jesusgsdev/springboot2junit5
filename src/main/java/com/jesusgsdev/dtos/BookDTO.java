package com.jesusgsdev.dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

public class BookDTO extends BaseDTO {

    private Long id;

    @NotBlank
    @Length(max = 140)
    private String title;

    @DecimalMax("199.99")
    @DecimalMin("0.0")
    private Double price;

    @NotBlank
    @Length(max = 155)
    private String author;

    @Min(1)
    private Integer pages;

    public BookDTO() { }

    public BookDTO(String title, Double price, String author, Integer pages) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.pages = pages;
    }

    private BookDTO(Builder builder) {
        this.id = builder.id;
        this.title = builder.name;
        this.price = builder.price;
        this.author = builder.author;
        this.pages = builder.pages;
    }

    public static Builder newBookDTO() {
        return new Builder();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDTO)) return false;

        BookDTO book = (BookDTO) o;

        if (!id.equals(book.id)) return false;
        if (!title.equals(book.title)) return false;
        if (!price.equals(book.price)) return false;
        if (!author.equals(book.author)) return false;
        return pages.equals(book.pages);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + pages.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", title)
                .append("price", price)
                .append("author", author)
                .append("pages", pages)
                .toString();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Double price;
        private String author;
        private Integer pages;

        private Builder() {
        }

        public BookDTO build() {
            return new BookDTO(this);
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder pages(Integer pages) {
            this.pages = pages;
            return this;
        }
    }
}
