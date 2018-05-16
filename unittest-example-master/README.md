# Java单元测试示例工程
## 重要说明
单元测试一定要做code review
## 模块介绍
### dubbo-test-example
Dubbo服务的Mock
使用的是Mockito mock的方式,主要是更改了spring的xml的配置:
1. 配置文件:http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/dubbo-test-example/src/test/resources/testApplicationContext4XmlDefineMock.xml 
2. 单元测试文件:http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/dubbo-test-example/src/test/java/com/facishare/common/unittest/dubbo/DubboMock4XmlDefineTest.java

### fcp-test-example
Fcp的服务如何测试【在Spring中Mock静态方法,MockSpring的Bean】
要想测试Fcp的服务,最重要的是要Mock从DefaultFcpServiceContextManager.getInstance().getContext()里面获取的当前用户的信息,例如EA,EID,UserId,等。
在fs-appserver-common-tools里已经封装了一个FcpUtils.java,里面针对获取这些信息做了方法上的封装。
实现的方式:
1. 使用JMockit Mock的FcpUtils静态方法的返回值。
参考类:

Java+JUnit实现:

http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/fcp-test-example/src/test/java/com/facishare/common/unittest/fcp/DataControllerByJMockitTest.java

Groovy+JUnit实现:

http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/groovy-test-example/src/test/java/com/facishare/common/unittest/groovy/junit/JUnitFcpJMockitTest.java

Groovy+Spock实现【推荐】:

http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/groovy-test-example/src/test/java/com/facishare/common/unittest/groovy/spock/SpockFcpJMockitTest.groovy
2. 使用单例的Service将FcpUtils的方法进行封装,获取EA EID等信息的时候通过这个Service来获取,使用Mockito(可以使用其他框架)mock这个service
参考类:
http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/fcp-test-example/src/test/java/com/facishare/common/unittest/fcp/DataControllerByMockitoPrimaryTest.java

3. 目前助手使用的方式是所有的service继承了一个BaseImpl,在BaseImpl里定义了获取用户信息的方法,这个方法会调用FcpUtils,实现的思路:使用Mockito(可以使用其他框架)spy所有的service,mock调用的方法。【如果项目中Service很多需要Mock的方法很多,不建议使用】
参考类:
http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/fcp-test-example/src/test/java/com/facishare/common/unittest/fcp/DataControllerByMockitoBaseImplTest.java

4.【推荐实现】不再建议使用FcpUtils的方式获取当前用户信息，需要mock静态方法很麻烦，推荐的方式是在controller的父类中实现从context获取信息的方案，在controller中直接调用。mock的时候直接mock这个Context，set回controller中。
参考具体实现：
http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/fcp-test-example/src/test/java/com/facishare/common/unittest/fcp/standard/StandardDataControllerTest.java

### groovy-test-example
### junit-test-example
### mock-test-example
### mongodb-test-example
数据库的单元测试都是基于嵌入式数据库来完成,关系型数据库主要是:
1.Flapdoodle <https://github.com/joelittlejohn/embedmongo-maven-plugin>
1.Joelittlejohn <https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo>
根据Github上的活跃度,本Demo实用Flapdoodle来实现

### mybatis-test-example
数据库的单元测试都是基于嵌入式数据库来完成,关系型数据库主要是:
1.HSQLDB
1.H2
1.Apache Derby
本Demo工程是用H2来实现的

### redis-test-example
### spring-test-example
Spring的Bean的mock
1. 通过@Primary的方式优先加载Bean, http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/spring-test-example/src/test/java/com/facishare/common/unittest/spring/MockBeanByPrimaryTest.java
2. 通过更改Xml文件, 重新定义Bean, http://git.firstshare.cn/JavaCommon/unittest-example/blob/master/spring-test-example/src/test/java/com/facishare/common/unittest/spring/MockBeanByChangeConfigFileTest.java

## 参考资料
### ~~Build Spring Unit test by using PowerMock with Mockito~~
 ~~http://sunxboy.iteye.com/blog/2005330~~ **经测试在Spring 3 以上无法使用。推荐使用JMockit**
 
### Mock&Spring集成
http://www.cnblogs.com/fangfan/p/5001149.html

https://dzone.com/articles/how-to-mock-spring-bean-version-2

https://dzone.com/articles/how-mock-spring-bean-without

### JMockito
 http://blog.csdn.net/chjttony/article/details/17838693
 
 Problem:
 
 JMockit wasn't properly initialized; check that jmockit.jar precedes junit.jar in the classpath 
 Edit POM.xml file. The jmockit.jar should be precedes junit.jar then jmockit dependency should be before of junit.
 
### Mock Static Method in Groovy
  can not mock static java class in Groovy, only use JMockit or PowerMock

### Integration testing done right with Embedded MongoDB 
https://vladmihalcea.com/2014/10/11/integration-testing-done-right-with-embedded-mongodb/

### Embedded MongoDB with Spring 
http://wbiller.bitbucket.org/blog/mongofactory/index.html