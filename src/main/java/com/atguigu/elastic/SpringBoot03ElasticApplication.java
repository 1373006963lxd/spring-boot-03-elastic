package com.atguigu.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*

学习更多知识-----github--jest

* SpringBoot默认支持两种技术来和ES交互
* 1.Jest（默认不生效）、
* 需要导入jest工具包

* 2.SpringData ElasticSearch
*注意镜像版本一定要和springboot的elasticsearch版本合适
spring官网--project-spring-data--下拉找Spring Data Elasticsearch--learn--点击任意一个版本的文档下拉即可找到
版本控制说明https://github.com/spring-projects/spring-data-elasticsearch

*springboot里面是6.4.3版本，所以需要下载elasticSearch也要这个版本（docker hub 中搜索 6.4.3）

操作步骤：
    1）Client节点信息clusterNodes；clusterName
    2）ElasticSearchRepository 操作es
    3）编写一个ElasticsearchRepository的子接口来操作ES
两种方法:
1)编写一个ElasticsearchRepository------------------BookRepository
2）操作一个bean -------------------------- book类  @Document(indexName = "atguigu",type = "book")

*
* */
@SpringBootApplication
public class SpringBoot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot03ElasticApplication.class, args);
    }

}
