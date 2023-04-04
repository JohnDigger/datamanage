package com.datamanage.datamanage.controller;

import com.datamanage.datamanage.utils.R;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author 贾佳
 * @date 2023/4/4 15:36
 */
@RestController
@RequestMapping("/back/file")
public class FileController {

    @Value("${file.uploadFolder}")
    private String localPath;
    @Value("${file.imageStaticAccessPath}")
    private String imageStaticAccessPath;

    @PostMapping("/uploadimages")
    public R fileUpload(@RequestPart("file") MultipartFile file) throws IOException {
        List<String> stringList = new ArrayList<>();

        if (file == null || file.isEmpty()) {
            return R.error("上传文件为空");
        }
        String imageSuffix = FilenameUtils.getExtension(file.getOriginalFilename());
        assert imageSuffix != null;
        if (imageSuffix.equals("jpg") || imageSuffix.equals("png") || imageSuffix.equals("jpeg") || imageSuffix.equals("JPG")) {
            String fileName = ((String) Objects.<String>requireNonNull(file.getOriginalFilename())).replace(" ", "");
            fileName = UUID.randomUUID().toString().replace("-", "") + "." + imageSuffix;
            String realpath = localPath + "image/" + fileName;
            File dest = new File(realpath);
            if (!dest.getParentFile().exists()) {
                boolean mksucess;
                mksucess = dest.getParentFile().mkdirs();
                if (!mksucess) {
                    R.error("directory made failed");
                }
            }
            file.transferTo(dest);
            String url = imageStaticAccessPath + fileName;
            stringList.add(url);
        }

        return R.ok().put("fileList", stringList);
    }
}
