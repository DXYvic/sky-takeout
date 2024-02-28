package com.sky.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


@Data
@AllArgsConstructor
@Slf4j
@Component
public class AliOssUtil {

//    private String endpoint;
//    private String accessKeyId;
//    private String accessKeySecret;
//    private String bucketName;


    /**
     * 文件上传
     * @param file
     * @param objectName
     * @return
     * @throws IOException
     */
    public String upload(MultipartFile file, String objectName) throws IOException {

       /* // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(bytes));
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }*/

        //文件访问路径规则 https://BucketName.Endpoint/ObjectName
        //下面没有使用阿里云oss，使用的是本地上传

        StringBuilder stringBuilder = new StringBuilder("D:\\skyFile_UploadTest\\");
        stringBuilder
//                .append(bucketName)
//                .append(".")
//                .append(endpoint)
//                .append("/")
                .append(objectName);
        file.transferTo(new File(stringBuilder.toString()));
        log.info("文件上传到:{}", stringBuilder.toString());

        return stringBuilder.toString();
    }
}
