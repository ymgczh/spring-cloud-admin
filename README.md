# spring-cloud-admin
spring-cloud-admin是基于`Spring 
Cloud`微服务`开发平台`，具有统一授权，其中包含具备用户管理、资源权限管理、网关API管理等多个模块。
核心技术采用`Spring Boot 2.0.1`以及`Spring Cloud (Finchley.RELEASE)
`相关核心组件，采用`阿里巴巴nacos注册中心`，前端采用`vue-element-admin`组件。 


## 1 项目技术栈

* 数据库`mysql6.5`

* 链路追踪`zikpin`

* 服务监控`springboot-admin`

* 注册中心`nacos`

* 远程调用 `fegin`

* 服务熔断 ` Hystrix `

* 网关`spring-gateway`

* 消息队列`rabbit-mq`

* 持久化`tk-mapper-mybatis`

* 日志` log4j`

* 数据库连接池`druid`

* 序列化`jackson`

* 分页 `pagehelper`

* 数据校验 `JSR303`

* 单元测试`junit` 



## 2 架构
![image.png](https://upload-images.jianshu.io/upload_images/4157022-980f00d05d56900f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 用户鉴权
通过`JWT`的方式来完成用户权限管理。

#### 监控
利用Spring Boot Admin 来监控每个服务的运行状态。

#### 服务注册
基于nacos来实现的服务注册。

#### 熔断机制
因为采取了服务的分布，为了避免服务之间的调用“雪崩”，采用了`Hystrix`的作为熔断器，避免了服务之间的“雪崩”。

#### 链路追踪
采用zikpin和mq收集每个节点的调用信息完成链路追踪。

#### 远程调用
采用feigin完成服务与服务之间的调用。

#### 配置中心

采用nacos完成服务配置更新管理。

------

## 3 功能截图

### 3.1 基本功能

----
#### 登录界面

![image.png](https://upload-images.jianshu.io/upload_images/4157022-f182f5862c1fab66.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

----
#### 主界面

![image.png](https://upload-images.jianshu.io/upload_images/4157022-1a675917614f4bd6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


----
#### 用户管理

![image.png](https://upload-images.jianshu.io/upload_images/4157022-31be5bb132cb8682.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


----
#### 菜蛋管理

![image.png](https://upload-images.jianshu.io/upload_images/4157022-6bb327063d08ea33.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

----
#### 角色管理

![image.png](https://upload-images.jianshu.io/upload_images/4157022-8d11a8f8a41a4b5b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

----
#### 日志管理

![image.png](https://upload-images.jianshu.io/upload_images/4157022-aad2897c7c3e5453.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

----
#### 角色类型管理

![image.png](https://upload-images.jianshu.io/upload_images/4157022-b8287816c9d084f6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

----
#### nacos服务注册和配置中心

![image.png](https://upload-images.jianshu.io/upload_images/4157022-1b6f9abcaad8a44a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


----
#### zikpin链路追踪

![image.png](https://upload-images.jianshu.io/upload_images/4157022-c0c8f3cae89fee08.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


----
#### springboot-admin服务监控

![image.png](https://upload-images.jianshu.io/upload_images/4157022-d9d9367735d9907a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


----

## 4 使用说明
### 项目前提
- 安装erlang，rabbitmq   地址：（http://localhost:15672 ）  默认账号：guest 密码：guest
- 安装mysql
- 安装redis
### 项目配置
- 修改admin服务application.xml中的mysql，redis，rabbitmq账号密码 
  该服务器数据库在\ay\admin\src\main\resources\db中
- 修改auth服务application.xml中的rabbitmq账号密码
- 修改gateway服务application.xml中的rabbitmq账号密码
- 修改zipkin服务application.xml中的rabbitmq，mysql账号密码
  该服务器数据库在ay\zipkin\src\main\db中

### 项目启动说明
- 启动redis,mysql,rabbitmq   
- 启动nacos注册中心和配置中心  **地址**：[http://localhost:8848/nacos](http://localhost:8848/nacos)     - **默认账号**：nacos 密码：nacos
- 启动 auth认证服务器       端口：8763
- 启动 gateway（端口：8762）网关服务和admin 管理服务（端口：9004）    
- 启动zipkin链路追踪（端口：9411）和monoitr节点管理服务 （端口：7000）
- [前端启动地址](https://github.com/ayhyh/spring-cloud-admin-ui)




## 5 项目地址

[后端地址](https://github.com/ayhyh/spring-cloud-admin)

[前端地址](https://github.com/ayhyh/spring-cloud-admin-ui)

[项目说明](https://www.jianshu.com/p/1f59a72d5867)


## License
Apache License Version 2.0