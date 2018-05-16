package com.facishare.common.unittest.mongo;

import com.mongodb.*;
import com.mongodb.util.JSON;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class MongoTest {

  public void setMongo(MongoClient mongo) {
    this.mongo = mongo;
  }

  @Resource
  private MongoClient mongo;
  private DB db;
  private DBCollection col;


  @Before
  public void setup() throws Exception {
    db = mongo.getDB("test");
    col = db.getCollection("col");
    BufferedReader br = new BufferedReader(new FileReader("src/test/resources/sample.json"));
    String str;
    while ((str = br.readLine()) != null) {
      DBObject dbObject = (DBObject) JSON.parse(str);
      col.insert(dbObject);
    }
  }

  @Test
  public void insertTest() {
    DBObject user = new BasicDBObject();
    user.put("name", "test");
    user.put("age", 24);
    user.put("sex", "男");
    col.insert(user);
    assertTrue(col.count() > 0);
  }

  @Test
  public void queryTest() {
    DBObject userDocument = new BasicDBObjectBuilder().add("name", "test").get();
    col.insert(userDocument);
    DBObject userDocumentFromDb = col.findOne(new BasicDBObject("name", userDocument.get("name")));
    assertEquals(userDocumentFromDb.get("name"), "test");
  }

  @Test
  public void updateTest() {
    BasicDBObject newBasicDBObject = new BasicDBObject();
    newBasicDBObject.put("id", 2);
    newBasicDBObject.put("name", "test");
    col.update(new BasicDBObject().append("id", 1), newBasicDBObject);

  }

  @Test
  public void deleteTest() {
    DBObject userDocument = new BasicDBObjectBuilder().add("name", "test").get();
    col.insert(userDocument);
    col.remove(new BasicDBObject("name", new BasicDBObject("$gte", "test")));
    assertTrue(col.find(new BasicDBObject(("name"), "test")).count() == 0);

  }

}