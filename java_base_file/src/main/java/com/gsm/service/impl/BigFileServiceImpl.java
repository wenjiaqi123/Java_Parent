package com.gsm.service.impl;

import com.gsm.entity.Chunk;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.service.BigFileService;
import com.gsm.utils.FileStoreUtils;
import com.gsm.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class BigFileServiceImpl implements BigFileService {
    @Autowired
    private IdUtils idUtils;

    @Override
    public Result insertChunk(Chunk chunk) throws IOException {
        String dir = "D://a";
        String name = new StringBuilder()
                .append(chunk.getIdentifier())
                .append("_")
                .append(chunk.getChunkNumber())
                .toString();
        FileStoreUtils.storeFileByName(chunk.getFile(), dir, name);

        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result selectChunkToFile(Chunk chunk) throws IOException {
        String dir = "D://a";
        String identifier = chunk.getIdentifier();
        Integer totalChunks = chunk.getTotalChunks();

        FileOutputStream fos = new FileOutputStream(dir + File.separator + identifier, true);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= totalChunks; i++) {
            sb.append(dir)
                    .append(File.separator)
                    .append(identifier)
                    .append("_")
                    .append(i);
            FileInputStream fis = new FileInputStream(sb.toString());

            int len = 0;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }
            sb.delete(0, sb.length());
            fis.close();
        }

        fos.close();
        Result result = new Result(true, StatusCode.OK, "", idUtils.nextId());
        return result;
    }
}
