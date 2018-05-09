package com.sa.modules.controller;

import com.sa.common.utils.FileUtil;
import com.sa.common.utils.R;
import com.sa.modules.dao.ParsesDao;
import com.sa.modules.entity.ParsesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/parses")
public class FileUploadController extends AbstractController {

    @Autowired
    private ParsesDao parsesDao;

    /**
     * 判断文件是否存在
     */
    @GetMapping(value = "/isFile")
    @ResponseBody
    public R isFile(String fileName,String fileClassify, String fileId){

        List<ParsesEntity> isfile = parsesDao.queryFile(fileName);
        if (isfile.size() != 0){
            return R.error("文件已存在");
        }
        return R.ok();
    }

    /**
     * 上传文件 加入本地
     */
@PostMapping(value = "/uploadFile")
@ResponseBody
public R uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, String fileId, String fileClassify) {

    //根据不同的分类设置文件路径
    String filePath = "c:/files/" + fileClassify+"/"+fileId+"/";
    //得到上传文件的名称
    String fileName = file.getOriginalFilename();

    try {
        FileUtil.uploadFile(file.getBytes(), filePath, fileName);
    } catch (Exception e) {
        // TODO: handle exception
    }

    //查询文件是否存在
     List<ParsesEntity> isfile = parsesDao.queryFile(fileName);
    System.out.println(isfile);
    if (isfile.size() != 0){

    }else {
        //加入数据库
        ParsesEntity parsesEntity = new ParsesEntity();
        parsesEntity.setFileId(fileId);
        parsesEntity.setFileClassify(fileClassify);
        parsesEntity.setFileName(fileName);
        parsesEntity.setUrlSite(filePath);
        parsesEntity.setCreateUserId(getUserId());
        parsesEntity.setCreateTime(getTime());

        parsesDao.add(parsesEntity);
    }


    response.setContentType("text/html; charset=UTF-8");
    return R.ok();
}

}
