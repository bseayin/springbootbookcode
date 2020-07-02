package com.xsz.service;

import com.xsz.util.ResultVOUtil;
import com.xsz.vo.ResultVO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class WordService {
    @Value("${fileStoreRootPath}")
    String filePath;
    public ResultVO<Map<String, String>> createTemplate1(String docName){
        try {
            Map<String,String> dataMap = new HashMap<String,String>();
            dataMap.put("f1", "张三");
            dataMap.put("f2", "男");
            dataMap.put("f3", "1999年1月1日");
            dataMap.put("f4", "汉");
            dataMap.put("f5", "本科");
            dataMap.put("f6", "计算机");
            dataMap.put("f7", "中国");
            dataMap.put("f8", "10000");
            dataMap.put("f9", "1385664464");
            dataMap.put("f10", "今年毕业");
            dataMap.put("f11", "JAVA,数据库");
            dataMap.put("f12", "篮球，乒乓球");
            dataMap.put("f13", "努力");
            dataMap.put("f14", "1年");
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            //指定模板路径的第二种方式,我的路径是D:/      还有其他方式
            System.out.println("filePath==="+filePath);
            configuration.setDirectoryForTemplateLoading(new File(filePath));

            // 输出文档路径及名称
            File outFile = new File(filePath+File.separator+docName+".doc");
            //以utf-8的编码读取ftl文件
            Template t =  configuration.getTemplate("m2.ftl","utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
            t.process(dataMap, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("rs", "success");

        return ResultVOUtil.success(map);
    }
}
