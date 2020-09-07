package com.gsm.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Component
public class FileUtil {

    /**
     * 将文件转移到指定目录
     *
     * @param fileName 指定文件名(包含路径)
     * @param toDir    目的文件夹
     * @return
     */
    @Async
    public String transferFile(String fileName, String fromDir, String toDir) throws IOException {
        long s = System.currentTimeMillis();
        File file = new File(fromDir + fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        File file1 = new File(toDir + fileName);
        FileOutputStream fos = new FileOutputStream(file1);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        int len = 0;
        while ((len = isr.read()) != -1) {
            osw.write(len);
        }
        osw.flush();
        osw.close();
        isr.close();
        fis.close();
        long e = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "\tsuccess" + "\t耗时" + (e-s)/1000 + "秒");

        String str = fileName;
        return str;
    }
}