package com.gsm.controller;

import com.gsm.entity.Chunk;
import com.gsm.entity.Result;
import com.gsm.service.BigFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/bFile")
public class BigFileController {
    @Autowired
    private BigFileService bigFileService;

    /**
     * @param chunk
     * @return
     */
    @PostMapping("/chunk")
    public Result insertChunk(Chunk chunk, HttpServletResponse resp) throws IOException {
        Result result = bigFileService.insertChunk(chunk);
        return result;
    }

    /**
     * @param chunk
     * @return
     */
    @PostMapping("/merge")
    public Result selectChunkToFile(@RequestBody Chunk chunk) throws IOException {
        Result result = bigFileService.selectChunkToFile(chunk);
        return result;
    }
}