package com.jesusgsdev.dtos;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    @NotBlank
    @Length(max = 140)
    private String provider;

    public BookDTO() {     }

    private BookDTO(Builder builder) {
        setId(builder.id);
        setTitle(builder.title);
        setPrice(builder.price);
        setAuthor(builder.author);
        setPages(builder.pages);
        setProvider(builder.provider);
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

        BookDTO bookDTO = (BookDTO) o;

        return new EqualsBuilder()
                .append(title, bookDTO.title)
                .append(price, bookDTO.price)
                .append(author, bookDTO.author)
                .append(pages, bookDTO.pages)
                .append(provider, bookDTO.provider)
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


    public static final class Builder {
        private Long id;
        private String title;
        private Double price;
        private String author;
        private Integer pages;
        private String provider;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder price(Double val) {
            price = val;
            return this;
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder pages(Integer val) {
            pages = val;
            return this;
        }

        public Builder provider(String val) {
            provider = val;
            return this;
        }

        public BookDTO build() {
            return new BookDTO(this);
        }
    }
}
