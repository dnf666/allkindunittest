package com.facishare.common.unittest.mongo.bean;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengyuqian on 16/11/24.
 */
@Entity("customers")
@Indexes(@Index(value = "age", fields = @Field("age")))
public class Customer {

  @Id
  private ObjectId id;
  private String name;

  public Customer() {
  }

  public Integer getAge() {
    return age;
  }

  private Integer age;

  public Customer(final String name, final Integer age) {
    this.name = name;
    this.age = age;
  }

  public ObjectId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

}
