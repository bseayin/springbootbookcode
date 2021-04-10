package com.zz.info.test;

import com.zz.vo.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class DummyAPIResponse {
    public ArrayList getCategory(){
        CategoryVO categoryVO=new CategoryVO();
        categoryVO.setId(1);
        categoryVO.setName("测试类型1");

        CategoryVO categoryVO2=new CategoryVO();
        categoryVO2.setId(2);
        categoryVO2.setName("测试类型2");

        ArrayList<CategoryVO> voArrayList=new ArrayList<CategoryVO>();
        voArrayList.add(categoryVO);
        voArrayList.add(categoryVO2);
        return voArrayList;
    }
    public HashMap getindex(){
        List<IndexDetailVO> list1=new ArrayList<>();
        List<IndexDetailVO> list2=new ArrayList<>();
        List<IndexDetailVO> list3=new ArrayList<>();
        List<IndexDetailVO> list4=new ArrayList<>();
        IndexDetailVO indexDetailVO=new IndexDetailVO();
        LinkVO linkVO=new LinkVO();
        linkVO.setId(11557);
        linkVO.setType("article");
        linkVO.setUrl("");
        indexDetailVO.setLink(linkVO);
        indexDetailVO.setId(11557);
        indexDetailVO.setComment_count(1111);
        indexDetailVO.setCreate_time("2020-10-08");
        indexDetailVO.setPhoto_url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606156444000&di=3a93b42c396d4fa1d362566e38f5d02b&imgtype=0&src=http%3A%2F%2Fpic1.zhimg.com%2Fv2-0eb052ba361d98bfb15193c9f4a36ee7_1440w.jpg%3Fsource%3D172ae18b");
        indexDetailVO.setRead(14332);
        indexDetailVO.setSource("来源测试");
        indexDetailVO.setTitle("测试标题");

        IndexDetailVO indexDetailVO2=new IndexDetailVO();
        LinkVO linkVO2=new LinkVO();
        linkVO2.setId(11556);
        linkVO2.setType("article");
        linkVO2.setUrl("");
        indexDetailVO2.setLink(linkVO);
        indexDetailVO2.setId(11556);
        indexDetailVO2.setComment_count(1222);
        indexDetailVO2.setCreate_time("2020-10-08");
        indexDetailVO2.setPhoto_url("https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E9%A3%8E%E6%99%AF&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&hd=&latest=&copyright=&cs=2346282507,2171850944&os=1377445141,2277854446&simid=3553638952,469919429&pn=1&rn=1&di=189970&ln=1184&fr=&fmq=1606147336638_R&ic=&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined");
        indexDetailVO2.setRead(345);
        indexDetailVO2.setSource("来源测试");
        indexDetailVO2.setTitle("测试标题2");

        list1.add(indexDetailVO);
        list2.add(indexDetailVO);
        list3.add(indexDetailVO);
        list4.add(indexDetailVO);

        list1.add(indexDetailVO2);
        list2.add(indexDetailVO2);
        list3.add(indexDetailVO2);
        list4.add(indexDetailVO2);
        HashMap map1=new HashMap();
        HashMap map2=new HashMap();
        HashMap map3=new HashMap();
        map1.put("slider",list1);
        map1.put("hot_article",list2);

        map2.put("ad",map1);
        map2.put("slider",list3);
        map2.put("list",list4);
        map2.put("count",5454);
        map2.put("page",12);
        return map2;
    }


    public HashMap getdetail(){
        HashMap map1=new HashMap();
        HashMap map2=new HashMap();
        HashMap map3=new HashMap();
        HashMap map4=new HashMap();
        HashMap map5=new HashMap();
        HashMap map6=new HashMap();
        HashMap map7=new HashMap();
        //文章内容
        map1.put("id",11557);
        map1.put("title","测试标题文章详情api");
        map1.put("source","测试来源文章详情api");
        map1.put("create_time","2020-10-08");
        map1.put("photo_url","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606198205375&di=e0a302acdc69d8429abe7a1387067b35&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F10%2F01%2F01300000091985121196015965747.jpg");
        map1.put("content","测试内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容*****文章详情api");
        map1.put("read",456);
        map1.put("category_id",1);
        map1.put("like_count",1);
        map1.put("is_like",1);
        map1.put("is_favorite",1);
        map1.put("source_url","http:XXXX");

        //评论
        map2.put("id",472);
        map2.put("reply_count",1);
        map2.put("like_count",1);
        map2.put("reply_count",11);
        map2.put("create_time","2020-10-08");
        map2.put("nickname","微信名字测试");
        map2.put("avatar_url","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606198933610&di=cd64b28d3f3b791649c784b4cf1021d0&imgtype=0&src=http%3A%2F%2Fbbs.jooyoo.net%2Fattachment%2FMon_1007%2F24_364453_f788d3dc49b78b7.jpg");
        map2.put("content","写的好");

        //评论回复
        map3.put("id",314);
        map3.put("pid",472);
        map3.put("is_like",0);
        map3.put("like_count",111);
        map3.put("nickname","微信名字测试2");
        map3.put("parent_nickname","微信名字测试");
        map3.put("parent_avatar_url","");
        map3.put("avatar_url","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606198933610&di=cd64b28d3f3b791649c784b4cf1021d0&imgtype=0&src=http%3A%2F%2Fbbs.jooyoo.net%2Fattachment%2FMon_1007%2F24_364453_f788d3dc49b78b7.jpg");
        map3.put("content","写的好");
        List<HashMap> list1=new ArrayList<>();
        list1.add(map3);
        map4.put("list",list1);
        map4.put("count",1);
        map4.put("page",1);
        map2.put("reply",map4);
        List<HashMap> list2=new ArrayList<>();
        list2.add(map2);
        map5.put("list",list2);
        map1.put("comment",map5);
        map6.put("id",1);
        map6.put("name","测试类型1");
        map1.put("category",map6);
        ArticleVO articleVO=new ArticleVO();
        articleVO.setId(11494);
        articleVO.setTitle("文章标题测试");
        articleVO.setPhoto_url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606198933610&di=cd64b28d3f3b791649c784b4cf1021d0&imgtype=0&src=http%3A%2F%2Fbbs.jooyoo.net%2Fattachment%2FMon_1007%2F24_364453_f788d3dc49b78b7.jpg");
        articleVO.setRead(23424);
        articleVO.setCreate_time("2020-10-07");
        articleVO.setSource("测试来源2");

        LinkVO linkVO=new LinkVO();
        linkVO.setId(11557);
        linkVO.setType("article");
        linkVO.setUrl("");
        articleVO.setLink(linkVO);
        List<ArticleVO> list3=new ArrayList<>();
        list3.add(articleVO);
        map1.put("related_article",list3);
        map7.put("related_article",list3);
        map1.put("ad",map7);


        return   map1;
    }
}
