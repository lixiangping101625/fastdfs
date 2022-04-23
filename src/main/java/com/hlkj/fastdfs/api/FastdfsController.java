package com.hlkj.fastdfs.api;

import com.hlkj.fastdfs.service.FdfsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author Lixiangping
 * @createTime 2022年04月22日 09:58
 * @decription:
 */
@RestController
@Slf4j
public class FastdfsController {


    @Resource
    private FdfsService fdfsService;

    /**
     * 上传
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename();
        String[] split = filename.split("\\.");
        String fileExtName = split[split.length - 1];
        String path = fdfsService.upload(file, fileExtName);
        System.out.println(path);
        return path;
    }

    /**
     * 下载（浏览器中打开）
     * @param fullPath（无虚拟路径） localhost:9999/download?fullPath=group1/00/00/eShdAWJkIteAPTwdAAAs0nwP-fA018.png
     * @param response
     * @throws Exception
     */
    // localhost:9999/download?fullPath=group1/00/00/eShdAWJkIteAPTwdAAAs0nwP-fA018.png
    @GetMapping("/download")
    public void download(String fullPath, HttpServletResponse response) throws Exception {
        ServletOutputStream outputStream = null;
        try {
            byte[] bytes = fdfsService.download(fullPath);
            String fileName = "fdfs.jpg";
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            if (bytes != null) {
                outputStream = response.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
            }
        } catch (IOException e) {
            log.debug("下载文件输出流异常：{}", e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                log.debug("下载文件关闭流异常：{}", e);
            }
        }
    }



//    @GetMapping("/fastdfs")
//    public void fastdfs() {
//        System.out.println("ClientGlobal.configInfo(): " + ClientGlobal.configInfo());
//    }
//
//    @Autowired
//    private StorageClient storageClient;
//// 172.26.4.90
//    /**
//     * 文件上传
//     */
//    @RequestMapping(value = "fastUpload")
//    @ResponseBody
//    public String fastUpload(@RequestParam("head_img") MultipartFile file){
//        String url = "";
//        try {
//
//            /**
//             * 文件上传 看对应的构造方法 去根据需要调用
//             * 参数1：需要上传的文件的绝对路径/或者字节流，
//             * 参数2：需要上传的文件的扩展名
//             * 参数3：文件的属性文件（通常不用上传）
//             * 返回一个String数组，这个数据对我们非常重要必须妥善保管（建议存入数据库）
//             * 数组中的一个元素为文件所在的组名
//             * 数组中的第二个元素为文件所在远程路径名
//             */
//            String[] result = storageClient.upload_file(file.getBytes(), "jpg", null);
//            url = result[0] + "/" + result[1];
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return url;
//    }

}
