package com.gsm.consumer;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Component
@RabbitListener(queues = "fastDFSQueue")
public class FastDfsConsumer {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @RabbitHandler
    public void fanoutQueueZero(String file){
        System.out.println("我是FastDFS消费者");
        String fileUrl = "";
        try {
            //StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
            //fileUrl = "106.15.238.19:8888/" + storePath.getGroup() + "/" + storePath.getPath();
            System.out.println(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(fileUrl);
    }
}
