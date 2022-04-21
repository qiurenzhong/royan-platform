package com.royan.file.api.service;

import com.royan.file.api.pojo.vo.FileVO;
import com.royan.framework.api.entity.ResponseData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileRemoteService {

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    ResponseData<FileVO> upload(MultipartFile file);

    /**
     * 下载文件
     *
     * @param fileName
     * @return
     */
    @RequestMapping(value = "/file/download", method = RequestMethod.POST)
    ResponseData<FileVO> download(@RequestBody String fileName);


    /**
     * 删除文件
     *
     * @param fileName
     * @return
     */
    @RequestMapping(value = "/file/delete", method = RequestMethod.POST)
    ResponseData delete(String fileName);

    /**
     * 获取所有文件
     *
     * @return
     */
    @RequestMapping(value = "/file/getAllFile", method = RequestMethod.POST)
    ResponseData<List<FileVO>> getAllFile();

}
