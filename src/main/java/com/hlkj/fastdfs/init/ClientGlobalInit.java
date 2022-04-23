package com.hlkj.fastdfs.init;

import org.csource.fastdfs.ClientGlobal;
import org.springframework.boot.CommandLineRunner;

import java.util.Properties;

/**
 * @author Lixiangping
 * @createTime 2022年04月22日 09:55
 * @decription:
 */
public class ClientGlobalInit implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        //加载原 conf 格式文件配置：
//        ClientGlobal.init("fdfs_client.conf");
//        ClientGlobal.init("config/fdfs_client.conf");
//        ClientGlobal.init("/opt/fdfs_client.conf");
//        ClientGlobal.init("F:\\MKW架构师\\fastdfs\\fdfs_client.conf");

        //加载 properties 格式文件配置：
//        ClientGlobal.initByProperties("fastdfs-client.properties");
//        ClientGlobal.initByProperties("config/fastdfs-client.properties");
//        ClientGlobal.initByProperties("/opt/fastdfs-client.properties");
//        ClientGlobal.initByProperties("F:\\MKW架构师\\fastdfs\\fastdfs-client.properties");

        //加载 Properties 对象配置：
//        Properties props = new Properties();
//        props.put(ClientGlobal.PROP_KEY_TRACKER_SERVERS, "10.0.11.101:22122,10.0.11.102:22122");
//        props.put(ClientGlobal.PROP_KEY_TRACKER_SERVERS, "121.40.93.1:22122");
//        ClientGlobal.initByProperties(props);

        //加载 trackerServers 字符串配置：
//        String trackerServers = "10.0.11.101:22122,10.0.11.102:22122";
//        String trackerServers = "121.40.93.1:22122";
//        ClientGlobal.initByTrackers(trackerServers);
    }
}
