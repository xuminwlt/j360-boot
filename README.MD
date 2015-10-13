j360-boot
==============

j360系列集成spring-boot



##Spring-boot快速上手指南##
- Spring Boot使开发独立的，产品级别的基于Spring的应用变得非常简单，你只需"just run"。 我们为Spring平台及第三方库提
供开箱即用的设置，这样你就可以有条不紊地开始。多数Spring Boot应用需要很少的Spring配置。
- 你可以使用Spring Boot创建Java应用，并使用 java -jar 启动它或采用传统的war部署方式。我们也提供了一个运行"spring
脚本"的命令行工具。

- **目标**
    - 为所有的Spring开发提供一个从根本上更快的和广泛使用的入门经验。
    - 开箱即用，但你可以通过不采用默认设置来摆脱这种方式。
    - 提供一系列大型项目常用的非功能性特征（比如，内嵌服务器，安全，指标，健康检测，外部化配置）。
    - 绝对不需要代码生成及XML配置。
- **容器**
    - 下列内嵌容器支持开箱即用（out of the box）：
    - 名称Servlet版本Java版本
    - Tomcat 8 3.1 Java 7+
    - Tomcat 7 3.0 Java 6+
    - Jetty 9 3.1 Java 7+
    - Jetty 8 3.0 Java 6+
    - Undertow 1.1 3.1 Java 7+
    - 你也可以将Spring Boot应用部署到任何兼容Servlet 3.0+的容器。

## 构建 ##
- Java 1.7+(官方建议1.8)
- Maven 3.2+

- Spring 4.1.3
- Spring-boot 1.3.0.BUILD-SNAPSHOT
- j360 1.0.0.BUILD-SNAPSHOT

## 模块 ##
- j360-simple：quickstart，直接继承spring-boot并简单封装
- j360-simplewar：直接继承spring-boot并修改生成为war格式
- j360-standard：标准maven依赖，继承自己定义的parent并封装
- j360-advance：标准maven依赖，继承并依赖自定义的module
- j360-production:Spring Boot包含很多其他的特性，它们可以帮你监控和管理发布到生产环境的应用。你可以选择使用HTTP端点，JMX或远
                  程shell（SSH或Telnet）来管理和监控应用。审计（Auditing），健康（health）和数据采集（metrics gathering）会自动应
                  用到你的应用。
### j360-simple ###

- **开发顺序**
    - pom.xml
        - 继承parent
        - 设置spring-boot官方源
        - 设置spring-web依赖（web开发基本依赖）
        - 设置maven打包插件，打包成可执行的jar
    - 编写入口Application.java（配置java也可以合并到这里）
    - 编写配置Configuration.java（独立便于定制）
    - （可选）如果是个web工程 增加Index.java（用于执行后测试）
- **测试**
    - 单元测试
        -   普通的restTemplate测试/hello的输出结果
        -   通过gzip编码压缩的restTemplate测试/hello的结果
    
- **演示**
    - 执行spring-boot:run（也可以直接在IDE中执行Application.java main方法）
    - 输入localhost:8080/index
    

### j360-simplewar ###
- **打包成war格式的设置**
    - 只需要将pom.xml的package改成war即可
    
### j360-standard ###
- 标准maven依赖，继承自己定义的parent并封装，j360-standard属于典型的标准的工程，尽量不受制于spring boot在工程搭建的时候的限制，比如自定义的parent，集成自己的modules，可打包成war包，并且在开发场景中嵌入spring loaded实现热加载提高开发效率等。
- j360-standard实现常规项目中实体类、方法、消息、缓存、会话和页面，该工程使用spring另一个框架spring-session实现集群的会话同步功能，无需再去配置nginx或者apache+tomcat的会话同步，可谓功劳不小，配合docker容器的发布，在比如做活动等高并发请求时可以增加若干容器集群达到增加服务器的承载力。
- **包含：**
    - jpa
    - activemq（采用内置环境）
    - redis（需要安装redis服务器）
    - session（springsession）
    - jsp
    - logback
    - rabbitmq(需要rabbitmq服务器)
    
    - **测试**
        - 单元测试
            -   普通的restTemplate测试/hello的输出结果
            -   通过gzip编码压缩的restTemplate测试/hello的结果
        
    - **演示**
        - 执行spring-boot:run（也可以直接在IDE中执行Application.java main方法）
        - 输入localhost:8080/index
        
### j360-advance ###
- 标准maven依赖，继承自己定义的parent并封装，进一步升级标准配置，应对开发过程中的各种复杂要求，比如多场景控制，老的项目用到的hibernate datasource，shiro，mongodb等。
  - **包含：**
  - 自定义的hibernate配置
  - activemq（采用内置环境）
  - redis（需要安装redis服务器）
  - session（springsession）
  - jsp
  - logback
  - mongodb
  - shiro
  - webservice-cxf
  - spring loaded热部署
  - 分布式事务 XA
  - docker支持（见 j360-docker https://github.com/xuminwlt/j360-docker）
  
### j360-produciton ###
- spring-boot-actuator模块提供了Spring Boot所有的production-ready特性。启用该特性的最简单方式就是添加对spring-bootstarter-
  actuator ‘Starter POM’的依赖。
  