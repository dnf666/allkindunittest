package com.facishare.common.unittest.mongo;

import com.facishare.common.unittest.mongo.bean.Customer;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;


/**
 * Created by fengyuqian on 16/11/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/testApplicationContext.xml")
public class MongoMorphiaTest {

  @Resource
  private Datastore datastore;

  public void setDatastore(Datastore datastore) {
    this.datastore = datastore;
  }

  @Before
  public void setup() throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("src/test/resources/sample.json"));
    String str;
    while ((str = br.readLine()) != null) {
      DBObject dbObject = (DBObject) JSON.parse(str);
      datastore.save(dbObject);
    }
  }

  @Test
  public void insertTest() {
    Customer customer = new Customer("test", 10);
    datastore.save(customer);
    assertTrue(datastore.getDB().getCollection("customers").count() > 0);
  }

  @Test
  public void queryTest() {
    Customer customer = new Customer("test", 20);
    datastore.save(customer);
    Query<Customer> query = datastore.createQuery(Customer.class);
    Customer customer1 = query.field("name").equal("test").get();
    assertEquals(customer1.getAge().intValue(), 20);
  }

  @Test
  public void updateTest() {
    Customer customer = new Customer("test", 30);
    datastore.save(customer);
    Query<Customer> query = datastore.createQuery(Customer.class)
        .filter("age =", 30);
    UpdateOperations<Customer> updateOperations = datastore.createUpdateOperations(Customer.class)
        .inc("age", 10);

    UpdateResults results = datastore.update(query, updateOperations);

    Assert.assertEquals(1, results.getUpdatedCount());
  }

  @Test
  public void deleteTest() {
    Customer customer = new Customer("test", 40);
    datastore.save(customer);
    Query<Customer> query = datastore.createQuery(Customer.class)
        .filter("age ", 40);
    datastore.delete(query);
    assertTrue(datastore.createQuery(Customer.class).filter("age =", 40).countAll() == 0);

  }

}