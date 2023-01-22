package com.springbootrest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "author", nullable = false, length = 180)
  private String author;

  @Column(name = "launch_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date launchDate;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "title", nullable = false, length = 250)
  private String title;

  public Book() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

    Book book = (Book) o;

    if (getId() != book.getId()) {
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
    int result = (int) (getId() ^ (getId() >>> 32));
    result = 31 * result + getAuthor().hashCode();
    result = 31 * result + getLaunchDate().hashCode();
    result = 31 * result + getPrice().hashCode();
    result = 31 * result + getTitle().hashCode();
    return result;
  }
}
