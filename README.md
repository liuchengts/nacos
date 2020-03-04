# nacos
基于springcloud集成了 nacos
### 当前已集成的功能
* 加入 nacos 注册服务发现
* 加入 nacos 的 config 动态配置
* 加入 sentinel 监控
* 加入 openfeign 完成基于 rest 的负载均衡调用
* 加入 dubbo 调用 (注册到nacos)
* 加入 sentinel 流控、回调等处理

### 使用前准备
* [nacos入门](https://nacos.io/zh-cn/docs/quick-start.html)
* [sentinel入门](https://github.com/alibaba/Sentinel/wiki/%E6%8E%A7%E5%88%B6%E5%8F%B0#2-%E5%90%AF%E5%8A%A8%E6%8E%A7%E5%88%B6%E5%8F%B0)
* [use-nacos-with-dubbo](https://nacos.io/zh-cn/docs/use-nacos-with-dubbo.html)
* [Sentinel](https://github.com/alibaba/Sentinel/wiki/%E4%B8%BB%E6%B5%81%E6%A1%86%E6%9E%B6%E7%9A%84%E9%80%82%E9%85%8D#dubbo) 
* [SentinelResource](https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81) 

### 使用本demo测试功能
#### 1、测试 nacos config 动态配置 
* 在nacos中增加一个配置列表 

|Data Id | Group    | 配置格式  | 配置内容 |
| :----: | :----: | :----:  | :----:  |
|dev     | LC_GROUP  | YAML    | ```spring.profiles.active: dev``` |

* 访问 http://localhost:8082/config/get 或  http://localhost:8081/config/get
* 更改 原先增加 Data Id 为 dev 的配置表，将配置内容改为 ```spring.profiles.active: test``` 再重复上一步

#### 2、测试 rest 调用
* 访问 http://localhost:8082/config/rest 或 http://localhost:8081/config/rest

#### 3、测试 dubbo 调用
* 访问 http://localhost:8081/dubbo/get


#### 3、监控
* 启动 nacos 后 访问 ``` http://localhost:8848/nacos ``` 默认账户和密码是 ```nacos```
* 启动 sentinel 后 访问 ``` http://localhost:8080 ``` 默认账户和密码是 ```sentinel```

#### 4、服务降级流控
* 访问 http://localhost:8081/dubbo/get   验证 fallback与 blockHandler共存
* 访问 http://localhost:8081/dubbo/get2  在sentinel 控制台添加 流控规则后快速多次访问触发流控
* 访问 http://localhost:8081/dubbo/get3  触发 fallback


### 相关examples
* [nacos-examples](https://github.com/nacos-group/nacos-examples) 

### docker化
* [nacos docker](https://nacos.io/en-us/docs/quick-start-docker.html)  
* sentinel docker 增加基础的docker镜像及基于1.7.1的阿里云镜像
