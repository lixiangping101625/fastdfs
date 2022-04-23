package com.hlkj.fastdfs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FastDfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastDfsApplication.class, args);
    }

//    @Bean
//    public StorageClient storageClient(){
//        StorageClient storageClient = null;
//        try{
//            Properties props = new Properties();
//            props.put(ClientGlobal.PROP_KEY_TRACKER_SERVERS, "121.40.93.1:22122");
//            props.put(ClientGlobal.PROP_KEY_CONNECT_TIMEOUT_IN_SECONDS, 30);
//            props.put(ClientGlobal.PROP_KEY_NETWORK_TIMEOUT_IN_SECONDS, 30);
//            ClientGlobal.initByProperties(props);
//
//            // 链接FastDFS服务器，创建tracker和Stroage
//            TrackerClient trackerClient = new TrackerClient();
//            TrackerServer trackerServer = trackerClient.getTrackerServer();
//            StorageServer storageServer=trackerClient.getStoreStorage(trackerServer);
//
//            //定义Stroage客户端对象，需要使用这个对象来完成具体的文件上传，下载和删除操作
//            storageClient = new StorageClient(trackerServer,storageServer);
//        }catch (Exception e){
//            log.error("加载StorageClient 异常", e);
//        }
//        return storageClient;
//    }

}
