package com.springbootrest.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import java.io.Serializable;
import java.util.Date;
import org.springframework.hateoas.RepresentationModel;

@JsonPropertyOrder({"id", "author", "launchDate", "price", "title"})
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

  @JsonProperty("id")
  @Mapping("id")
  private long key;

  private String author;
  private Date launchDate;
  private Double price;
  private String title;

  public BookVO() {
  }

  public long getKey() {
    return key;
  }

  public void setKey(long key) {
    this.key = key;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(Date launchDate) {
    this.launchDate = launchDate;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    BookVO book = (BookVO) o;

    if (getKey() != book.getKey()) {
      return false;
    }
    if (!getAuthor().equals(book.getAuthor())) {
      return false;
    }
    if (!getLaunchDate().equals(book.getLaunchDate())) {
      return false;
    }
    if (!getPrice().equals(book.getPrice())) {
      return false;
    }
    return getTitle().equals(book.getTitle());
  }

  @Override
  public int hashCode() {
    int result = (int) (getKey() ^ (getKey() >>> 32));
    result = 31 * result + getAuthor().hashCode();
    result = 31 * result + getLaunchDate().hashCode();
    result = 31 * result + getPrice().hashCode();
    result = 31 * result + getTitle().hashCode();
    return result;
  }
}
