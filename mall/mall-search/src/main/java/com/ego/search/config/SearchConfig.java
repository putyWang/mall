package com.ego.search.config;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class SearchConfig {
    //solr集群地址（zk地址）
    @Value("${spring.data.solr.zk-host}")
    private String zkHost;

    //默认的collection
    @Value("${spring.data.solr.default-collection}")
    private String defaultCollection;

    /**
     * 注入cloudSolarClient
     * @return
     * */
    @Bean
    public CloudSolrClient solrClient(){
        CloudSolrClient client = new CloudSolrClient.Builder().withZkHost(zkHost).build();
        client.setDefaultCollection(defaultCollection);
        return client;
    }
}
