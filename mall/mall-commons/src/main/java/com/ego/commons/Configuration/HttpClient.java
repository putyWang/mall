package com.ego.commons.Configuration;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/7 11:00
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class HttpClient {

    @Value("${http.maxTotal}")
    private int maxTotal;

    @Value("${http.defaultMaxPerRoute}")
    private int defaultMaxPerRoute;

    @Value("${http.connectTimeout}")
    private int connectTimeout;

    @Value("${http.connectRequestTimeout}")
    private int connectRequestTimeout;

    @Value("${http.socketTimeout}")
    private int socketTimeout;

    @Value("${http.staleConnectionCheckEnabled}")
    private boolean staleConnectionCheckEnabled;

    /**
    *@Description:首先实例化一个连接池管理器，设置最大连接数、并发连接数
    *@return: PoolingHttpClientConnectionManager
    */

    @Bean("httpClientConnectionManager")
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager(){

        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();

        //最大连接数
        poolingHttpClientConnectionManager.setMaxTotal(maxTotal);

        //设置并发数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        
        return poolingHttpClientConnectionManager;
    }
    
    /**
    *实例化连接池，设置连接池管理器。
    *这里需要以参数形式注入上面实例化的连接池管理器
    *@Param: HttpClientConnectionManager
    *@return: HttpClientBuilder
    */

    @Bean("httpClientBuilder")
    public HttpClientBuilder getHttpClientBuilder(@Qualifier("httpClientConnectionManager") PoolingHttpClientConnectionManager poolingHttpClientConnectionManager){

        //HttpClientBuilder中的构造方法被protected修饰，所以这里不能直接使用new来实例化一个HttpClientBuilder，可以使用HttpClientBuilder提供的静态方法create()来获取HttpClientBuilder对象
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);

        return httpClientBuilder;
    }

    /**
    *注入连接池，用于获取httpClient
    *@param httpClientBuilder
    *@return CloseableHttpClient
    */
    @Bean(name="closeableHttpClient")
    public CloseableHttpClient getCloseableHttpClient(@Qualifier("httpClientBuilder") HttpClientBuilder httpClientBuilder){
        return httpClientBuilder.build();
    }

    /**
     * Builder是RequestConfig的一个内部类
     * 通过RequestConfig的custom方法来获取到一个Builder对象
     * 设置builder的连接信息
     * 这里还可以设置proxy，cookieSpec等属性。有需要的话可以在此设置
     * @return
     */
    @Bean(name = "builder")
    public RequestConfig.Builder getBuilder() {
        HttpHost proxy = new HttpHost("192.168.1.8", 80, "http");
        RequestConfig.Builder builder = RequestConfig.custom();
        return builder.setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectRequestTimeout)
                .setSocketTimeout(socketTimeout)
                .setStaleConnectionCheckEnabled(staleConnectionCheckEnabled)
                .setProxy(proxy);
    }

    /**
     * 使用builder构建一个RequestConfig对象
     * @param builder
     * @return
     */
    @Bean
    public RequestConfig getRequestConfig(@Qualifier("builder") RequestConfig.Builder builder){
        return builder.build();
    }

}
