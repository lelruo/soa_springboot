package com.example.mydemo.controller;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.server.HttpServerResponse;
import com.example.mydemo.service.impl.FileServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileServiceImpl fileService;


    @CrossOrigin
    @PostMapping("/upload")
    public boolean upload(MultipartFile file,String userID,String courseID,String experimentID,String fileName) throws IOException {
        String originalFilename = file.getOriginalFilename();
        //定义文件的唯一标识
        String flag = IdUtil.fastSimpleUUID();
        //String rootFilePath = "D:/IDEAproject/mydemo/src/main/resources/file/"+originalFilename;
        String rootFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\file\\"+flag+"_"+originalFilename;
        System.out.println(rootFilePath);
        FileUtil.writeBytes(file.getBytes(),rootFilePath);

        String fileURL="http://localhost:8080/files/"+flag;

        return fileService.pushMyFile(userID,courseID,experimentID,fileName,fileURL);
    }


    @CrossOrigin
    @GetMapping("/{flag}")
    public void getFiles(HttpServletResponse response, @PathVariable String flag) throws IOException {
        OutputStream os;
        String basePath = System.getProperty("user.dir")+"\\src\\main\\resources\\file\\";
        List<String> fileNames=FileUtil.listFileNames(basePath);
        String avatar = fileNames.stream().filter(name->name.contains(flag)).findAny().orElse("");
        try {
            if(StrUtil.isNotEmpty(avatar)){
                response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(avatar,"UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes=FileUtil.readBytes(basePath+avatar);
                os=response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            System.out.println("文件下载失败");
        }
    }

    @CrossOrigin
    @GetMapping(value = "/getURL")
    public String getFileURL(String courseID,String experimentID){
        return fileService.getFile(courseID,experimentID);
    }

}
