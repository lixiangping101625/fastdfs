package com.hlkj.fastdfs.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Lixiangping
 * @createTime 2022年04月23日 23:12
 * @decription:
 */
public interface FdfsService {


    String upload(MultipartFile file, String fileExtName) throws Exception;

    byte[] download(String fullPath) throws Exception;
}
