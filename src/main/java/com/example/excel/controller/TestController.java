package com.example.excel.controller;

import com.github.andyczy.java.excel.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Liu T on 2019/4/23.
 */
@Controller
public class TestController {

    @RequestMapping("/export")
    public void export(HttpServletResponse response){
        List<List<String[]>> dataLists = new ArrayList<>();
        List<String[]> list = new ArrayList<String[]>();
        List<String[]> list1 = new ArrayList<String[]>();
        String[] headers = {"序号","姓名","年龄"};
        list.add(headers);
        list1.add(headers);
        for (int i = 0; i < 1000; i++){
            list.add(new String[]{"111","asdsa","男"});
            list.add(new String[]{"123","uuu","女"});
        };
        for (int i = 0; i < 1000; i++){
            list1.add(new String[]{"111","张三","男"});
            list1.add(new String[]{"123","李四","女"});
        };
        dataLists.add(list);
        dataLists.add(list1);
        ExcelUtils utils = ExcelUtils.initialization();
        utils.setDataLists(dataLists);
        utils.setSheetName(new String[]{"学生列表1", "学生列表2"});
        utils.setFileName("学生列表");
        HashMap headStyle = new HashMap();
        List listStyle = new ArrayList();
        listStyle.add(new Boolean[]{true, false, false});
        listStyle.add(new Integer[]{1});
        listStyle.add(new Integer[]{10,14,null});
        headStyle.put(1, listStyle);
        utils.setRowStyles(headStyle);
        utils.setResponse(response);
        utils.exportForExcelsNoStyle();
    }
}
