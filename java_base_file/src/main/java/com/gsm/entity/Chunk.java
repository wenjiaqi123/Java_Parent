package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chunk implements Serializable {

    /**
     * 每个块的唯一标识
     */
    private String identifier;
    /**
     * 文件总大小
     */
    private Long totalSize;
    /**
     * 分块大小
     */
    private Long chunkSize;
    /**
     * 当前块的大小，实际大小
     */
    private Long currentChunkSize;
    /**
     * 当前块的次序，第一个块是 1，注意不是从 0 开始的
     */
    private Integer chunkNumber;
    /**
     * 文件被分成的总数
     */
    private Integer totalChunks;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 文件夹上传的时候，文件的相对路径属性
     */
    private String relativePath;

    private MultipartFile file;
}
