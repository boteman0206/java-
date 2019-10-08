package com.example.demo.excleTest;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class demo1 {

    @GetMapping("/download")
    public void downLoadExcle(HttpServletRequest request, HttpServletResponse response){
        System.out.println("下载表格内容");

        try{
            List<StudentVo> voList = new ArrayList<StudentVo>();
            StudentVo vo = new StudentVo();
            vo.setId("1");
            vo.setSex("男");
            vo.setName("张三");
            vo.setGrade("二年级");
            voList.add(vo);

            vo = new StudentVo();
            vo.setId("2");
            vo.setSex("女");
            vo.setName("李四");
            vo.setGrade("一年级");
            voList.add(vo);

            vo = new StudentVo();
            vo.setId("3");
            vo.setSex("男");
            vo.setName("王五");
            vo.setGrade("三年级");
            voList.add(vo);

            String[] headerName = { "序号","性别", "姓名", "年级"};
            String[] headerKey = { "id","sex", "name", "grade"};
            HSSFWorkbook wb = ExcelUtils.createExcel(headerName, headerKey, "年数据管理", voList);
            if (wb == null) {
                return;
            }
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
            String str = sdf.format(date);
            String fileName = "content" + str;
            response.setHeader("Content-disposition",
                    "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO-8859-1") + ".xls");
            OutputStream ouputStream = response.getOutputStream();
            ouputStream.flush();
            wb.write(ouputStream);
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
