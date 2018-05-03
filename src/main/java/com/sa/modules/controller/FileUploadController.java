package com.sa.modules.controller;

import com.sa.common.utils.FileUtil;
import com.sa.common.utils.R;
import com.sa.modules.dao.ParsesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/parses")
public class FileUploadController {

    @Autowired
    private ParsesDao parsesDao;


    /**
     * 上传文件 加入本地
     */
@PostMapping(value = "/uploadFile")
@ResponseBody
public R uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, String fileId, String fileClassify) {

    //根据不同的分类设置文件路径
    fileId = "1";
    fileClassify = "2";
    String filePath = "c:/files/" + fileClassify+"/"+fileId+"/";
    //得到上传文件的名称
    String fileName = file.getOriginalFilename();

//    String filePath = request.getSession().getServletContext().getRealPath("files/"+ fileClassify+"/"+fileId+"/");
    System.out.println(filePath);
    try {
        FileUtil.uploadFile(file.getBytes(), filePath, fileName);
    } catch (Exception e) {
        // TODO: handle exception
    }
    response.setContentType("text/html; charset=UTF-8");
    return R.ok();
}

}
