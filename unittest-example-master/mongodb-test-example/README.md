# mongodb-spring-test-example
#### mongodb单元测试基于[de.flapdoodle.embed.mongo](https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo)完成
## Usage
### Maven
```
<dependency>
    <groupId>de.flapdoodle.embed</groupId>
    <artifactId>de.flapdoodle.embed.mongo</artifactId>
    <version>1.50.5</version>
</dependency>
```
##### 可以用以下2种方式获取MongoClient
* 
```
	private MongodExecutable mongodExe;
    private MongodProcess mongod;
    private MongoClient mongo;
    ...
    //获得空闲端口，也可以指定端口
    int port=Network.getFreeServerPort();
    //如果指定数据库目录，那么在关闭后不会删除数据库
    Storage replication = new Storage("/Users/fengyuqian/custom/databaseDir",null,0);
    MongodStarter runtime = MongodStarter.getDefaultInstance();
    IMongodConfig MongodConfig = new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .replication(replication)
                .net(new Net(port, Network.localhostIsIPv6()))
                .build();
    mongodExe = runtime.prepare(MongodConfig);
    mongod = mongodExe.start();
    mongo=new MongoClient("localhost",port);
```

* 
```
	private MongodForTestsFactory factory;
	private MongoClient mongo;
	...
	factory = MongodForTestsFactory.with(Version.Main.PRODUCTION);
	//随机获取空闲端口
    mongo = factory.newMongo();
```

##### 介绍
在使用embedmongo时进行单元测试时，如果没有指定数据库存储目录，那么MongoDB的实例仅在项目生命周期存在，结束时会flush掉相关数据。如果配置指定数据库存储目录，那么后期相关测试受到前面测试数据的影响。
### 结合Spring使用
```
<bean name="TestSpring" class="TestSpring">
     <property name="mongo" ref="mongo"></property></bean>
<bean name="mongoFactory" class="impl.MongoFactory"></bean>
<bean name="mongo" factory-bean="mongoFactory" factory-method="mongo"></bean>
```
* 实例工厂的方法注入


```
//实例工厂
public class MongoFactory {
    private MongodExecutable mongodExe;
    private MongodProcess mongod;
    private MongoClient mongo;
    public MongoClient mongo() throws IOException {
        int port= Network.getFreeServerPort();
      //Storage replication = new Storage("/Users/fengyuqian/custom/databaseDir",null,0);
        MongodStarter runtime = MongodStarter.getDefaultInstance();
        IMongodConfig MongodConfig = new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
         //     .replication(replication)
                .net(new Net(port, Network.localhostIsIPv6()))
                .build();
        mongodExe = runtime.prepare(MongodConfig);
        mongod = mongodExe.start();
        mongo=new MongoClient("localhost",port);
        return mongo;
    }
}
```
```
public class TestSpring {
	／／注入对象
    @Resource
    private MongoClient mongo;
    public void setMongo(MongoClient mongo) {
        this.mongo = mongo;
    }
    ...
    
```