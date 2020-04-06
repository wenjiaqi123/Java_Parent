package com.gsm.service;

import com.gsm.entity.Chunk;
import com.gsm.entity.Result;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BigFileService {
    Result insertChunk(Chunk chunk) throws IOException;

    Result selectChunkToFile(Chunk chunk) throws IOException;
}
