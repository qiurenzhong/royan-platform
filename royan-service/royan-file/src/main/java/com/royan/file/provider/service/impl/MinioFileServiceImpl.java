package com.royan.file.provider.service.impl;

import com.royan.file.api.pojo.vo.FileVO;
import com.royan.file.provider.config.MinioConfig;
import com.royan.file.provider.service.FileService;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.messages.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * minio文件业务存储
 */
@Service
public class MinioFileServiceImpl implements FileService {

    @Autowired
    private MinioConfig minioConfig;
    @Autowired
    private MinioClient minioClient;

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String objectName = minioConfig.getConfigDir() + "/" + fileName;
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(minioConfig.getBucketName())
                    .object(objectName)
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build();
            ObjectWriteResponse response = minioClient.putObject(args);
            return minioConfig.getEndpoint() + response.object();
        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public List<FileVO> searchAllFile() {
        List<FileVO> fileList = new ArrayList<>();
        try {
            List<Bucket> buckets = minioClient.listBuckets();

        } catch (Exception e) {

        }

        return null;
    }
}
