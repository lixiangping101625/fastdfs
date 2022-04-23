package com.hlkj.fastdfs.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadFileStream;
import com.github.tobato.fastdfs.service.DefaultGenerateStorageClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Lixiangping
 * @createTime 2022年04月23日 23:13
 * @decription:
 */
@Service
public class FdfsServiceImpl implements FdfsService {

    @Resource
    @Qualifier("defaultGenerateStorageClient")
    private DefaultGenerateStorageClient storageClient;

    @Override
    public String upload(MultipartFile file, String fileExtName) throws Exception {
        StorePath storePath = storageClient.uploadFile("group1", file.getInputStream(), file.getSize(), fileExtName);
        String fullPath = storePath.getFullPath();
        System.out.println("上传地址" + fullPath);
        return fullPath;
    }

    @Override
    public byte[] download(String fullPath) throws Exception {
        byte[] bytes = null;
        if (StringUtils.isNotBlank(fullPath)) {
            String group = fullPath.substring(0, fullPath.indexOf("/"));
            String path = fullPath.substring(fullPath.indexOf("/") + 1);
            DownloadByteArray byteArray = new DownloadByteArray();
            bytes = storageClient.downloadFile(group, path, byteArray);
        }
//        String s = new String(bytes, "gbk");
//        System.out.println(s);
        return bytes;
    }

}
