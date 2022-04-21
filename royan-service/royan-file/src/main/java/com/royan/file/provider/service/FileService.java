package com.royan.file.provider.service;

import com.royan.file.api.pojo.vo.FileVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件服务接口
 */
public interface FileService {

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);

    /**
     * 查询所有文件
     *
     * @return
     */
    List<FileVO> searchAllFile();
}
