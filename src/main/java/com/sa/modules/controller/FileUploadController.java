package com.sa.modules.controller;

import com.sa.common.utils.FileUtil;
import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.ParsesDao;
import com.sa.modules.entity.ParsesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/parses")
public class FileUploadController extends AbstractController {

    @Autowired
    private ParsesDao parsesDao;

    /**
     * 列出文件 根据值
     */
    @RequestMapping("/list")
//    @RequiresPermissions("midd:list")
    public R list(@RequestParam Map<String, Object> params,String fileClassify, String fileId) {
        //查询列表数据
        Query query = new Query(params);
        //条数和数据
        int total = parsesDao.queryTotal(params);
        List<ParsesEntity> list = parsesDao.queryList(query);
        return R.ok().put("count", total).put("data", list);
    }

    /**
     * 判断文件是否存在
     */
    @GetMapping(value = "/isFile")
    @ResponseBody
    public R isFile(String fileName,String fileClassify, long fileId){

        List<ParsesEntity> isfile = parsesDao.queryFile(fileName,fileId,fileClassify);
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
public R uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, long fileId, String fileClassify) {

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
     List<ParsesEntity> isfile = parsesDao.queryFile(fileName,fileId,fileClassify);
    if (isfile.size() != 0){
            isfile.get(0).setUpdateTime(getTime());
            parsesDao.edit(isfile.get(0));
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

    /**
     * 下载
     */
    @RequestMapping(value = "/dow")
    @ResponseBody
    public R dow(HttpServletResponse response,String urlSite,String fileName) throws Exception{
        String filePath = urlSite+fileName;

        if (filePath != null) {
            //设置文件路径
            File file = new File(filePath);
            response.reset();
            if (file.exists()) {
                // 设置强制下载不打开
                response.setContentType("application/force-download");
                // 设置文件名
                response.setContentType("application/octet-stream");
                response.setContentType("application/x-msdownload");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + "\"");
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return R.ok();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return R.error("文件下载失败");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public R delParse(ParsesEntity parses) {
        //删除数据库记录
        int p = parsesDao.delete(parses);
        if (p != 0) {

            //设置路径 并删除本地文件
            String filePath = parses.getUrlSite()+parses.getFileName();
            File file=new File(filePath);
            if(file.exists()&&file.isFile()){
                file.delete();
            }
        } else {
            return R.error("文件删除错误");
        }
        return R.ok();
    }

}
