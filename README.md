# nacos
基于springcloud集成了 nacos
### 当前已集成的功能
* 加入 nacos 注册服务发现
* 加入 nacos 的 config 动态配置
* 加入 sentinel 监控
* 加入 openfeign 完成基于 rest 的负载均衡调用

### 使用前准备
* [nacos入门](https://nacos.io/zh-cn/docs/quick-start.html)
* [sentinel入门](https://github.com/alibaba/Sentinel/wiki/%E6%8E%A7%E5%88%B6%E5%8F%B0#2-%E5%90%AF%E5%8A%A8%E6%8E%A7%E5%88%B6%E5%8F%B0)
* 在nacos中增加一个配置列表 

|Data Id | Group    | 配置格式  | 配置内容 |
| :----: | :----: | :----:  | :----:  |
|dev     | LC_GROUP  | YAML    | ```spring.profiles.active: dev``` |

### 相关examples
* [nacos-examples](https://github.com/nacos-group/nacos-examples) 

### 使用本demo测试功能
#### 测试 nacos config 动态配置 
* http://localhost:8082/config/get 或  http://localhost:8081/config/get
* 更改 原先增加 Data Id 为 dev 的配置表，将配置内容改为 ```spring.profiles.active: test``` 再重复上一步

#### 测试 rest 调用
* http://localhost:8082/config/rest 或 http://localhost:8081/config/rest

#### 监控
* 启动 nacos 后 访问 ``` http://localhost:8848/nacos ``` 默认账户和密码是 ```nacos```
* 启动 sentinel 后 访问 ``` http://localhost:8080 ``` 默认账户和密码是 ```sentinel```

