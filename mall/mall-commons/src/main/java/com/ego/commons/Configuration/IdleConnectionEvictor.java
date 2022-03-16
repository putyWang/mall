package com.ego.commons.Configuration;

import org.apache.http.conn.HttpClientConnectionManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/7 11:42
 * @description：处理关闭连接的线程
 * @modified By：
 * @version: $
 */
@Component
public class IdleConnectionEvictor extends Thread{

    @Resource
    private HttpClientConnectionManager manager;

    private volatile boolean shutdown;

    public IdleConnectionEvictor() {
        super();
        super.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // 关闭失效的连接
                    manager.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
    // 结束
        }
    }

    //关闭清理无效连接的线程
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
