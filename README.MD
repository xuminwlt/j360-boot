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
    
- **演示**
    - 执行spring-boot:run（也可以直接在IDE中执行Application.java main方法）
    - 输入localhost:8080/index
