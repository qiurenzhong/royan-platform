package com.royan.file.provider.controller;

import cn.hutool.core.io.FileUtil;
import com.royan.file.api.pojo.vo.FileVO;
import com.royan.file.api.service.FileRemoteService;
import com.royan.file.provider.service.FileService;
import com.royan.framework.api.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件服务控制层
 */
@Slf4j
@RestController
public class FileController implements FileRemoteService {

    @Autowired
    private FileService fileService;

    @Override
    public ResponseData<FileVO> upload(MultipartFile file) {
        ResponseData<FileVO> resp = new ResponseData<>();
        String url = fileService.uploadFile(file);
        String name = FileUtil.getName(url);
        FileVO fileVO = new FileVO();
        fileVO.setName(name);
        fileVO.setUrl(url);
        resp.setData(fileVO).ok();
        return resp;
    }

    @Override
    public ResponseData<FileVO> download(@RequestBody String fileName) {

        return null;
    }

    @Override
    public ResponseData delete(String fileName) {
        return null;
    }

    @Override
    public ResponseData<List<FileVO>> getAllFile() {
        ResponseData<List<FileVO>> resp = new ResponseData<>();
        resp.setData(fileService.searchAllFile()).ok();
        return resp;
    }

}
