package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.qianxinyao.analysis.jieba.keyword.Keyword;
import com.qianxinyao.analysis.jieba.keyword.TFIDFAnalyzer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.hfutec.preprocess.WordFiltering;
import org.hfutec.preprocess.wordseg.Jieba;
import org.hfutec.preprocess.wordseg.Jieba;
import org.hfutec.preprocess.wordseg.NLPIR;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.StringUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.print.DocFlavor;
import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    String name="";
    Map<Object,String> sql_select = new HashMap();
    @Test
    public void contextLoads() {
    }


    @Test
    public void test1(){

        System.out.println(name);
        System.out.println(sql_select);


    }

    @Test
    public void UTest() {
        UUID uuid = UUID.randomUUID();
        System.out.println("++");
        System.out.println(uuid);

    }

    @Test
    public  void testCpy() {
        Map<String,String> paramMap = new HashMap<String,String>();
        paramMap.put("name", "wangzhao");
        Map<String,String> paramMap2 = new HashMap<String,String>();
        paramMap2 = paramMap;
        System.out.println("paramMap2:"+paramMap2);
        System.out.println("paramMap:"+paramMap);
        paramMap2.put("age2", "2");
        System.out.println("修改paramMap2后,paramMap值:"+paramMap);
        System.out.println("修改paramMap2后,paramMap2值:"+paramMap2);
        Map<String,String> paramMap3 = new HashMap<String,String>();
        paramMap3.putAll(paramMap);
        System.out.println(paramMap3);
        System.out.println(paramMap);
        paramMap3.put("age3", "3");
        System.out.println("修改paramMap3后,paramMap值:"+paramMap);
        System.out.println("修改paramMap3后,paramMap3值:"+paramMap3);
    }


    @Test
    public void mapTest(){
        List medicineClassfySelect = new ArrayList();
        Map map = new HashMap();
        map.put("key", "year");
        map.put("value", "年份");
        medicineClassfySelect.add(map);
//        medicineClassfySelect.put("year", "年-Year");
//        medicineClassfySelect.put("month", "月-Month");
//        medicineClassfySelect.put("province", "省份");
//        medicineClassfySelect.put("subject", "板块-Subject");
//        medicineClassfySelect.put("platform_id", "平台-Platform");
//        medicineClassfySelect.put("hlevel", "医院等级");
//        medicineClassfySelect.put("titlename", "医生职称");
//        medicineClassfySelect.put("departmentname", "科室");
//        medicineClassfySelect.put("cityregion", "地域");
//        medicineClassfySelect.put("nielsen_citytier", "城市等级-Nestle");
//        medicineClassfySelect.put("citytier", "城市等级");
        System.out.println(medicineClassfySelect);
    }


    @Test
    public  void GoodIn2Json() {

        List list = new ArrayList();
        Map<String,String> map = new HashMap<>();
        map.put("name","szy");
        map.put("num","o");
        list.add(map);
        String inventoryResultStr = JSON.toJSONString(list);
        System.out.println(inventoryResultStr);
    }


    @Test
    public  void jieaTest() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences =
                new String[] {"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
        }
    }

    @Test
    public void demo1(){

//        NLPIR nlpir = new NLPIR("d:/nlpir/lib/win64/NLPIR","d:/nlpir/");

        File input = new File("data"+File.separator+"test.txt");//待处理的中文文本数据
        File output = new File("result"+File.separator+"testSplit.txt"); //分词、去停用词后的文本数据
        try {
            File file1 = new File("data\\stopWords.txt");
            List<String> stopword= FileUtils.readLines(file1,"utf8"); //加载停用词，存储在List集合中
            BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(input),"UTF-8"));
            BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output),"UTF-8"));
            String line;
            Jieba jieba = new Jieba();
            int i = 0;
            while((line = bufr.readLine())!=null){
                //循环每一行文本进行处理
                List<String> outList = new ArrayList<String>();
                List<String> input_text_list = new ArrayList<>();
                input_text_list.add(line);
                String[] outStrings = jieba.seg(input_text_list).get(0).split("\\s+");//将每行文本用结巴进行分词，并返回分词后的String数组
                for(String word:outStrings){//将String数组转成List集
                    outList.add(word);
                }
                outList.removeAll(stopword); //去除停用词
                String seg = String.join(" ", outList); //将List集合转为字符串，中间用空格隔开
                bufw.append(seg);
                bufw.newLine();
                bufw.flush();
                System.out.println(i++);
            }
            bufw.flush();
            bufw.close();
            bufr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testJI(){
        String input_text1 = "合肥工业大学（Hefei University of Technology）简称“合工大（HFUT）”，创建于1945 年，坐落于全国四大科教城市之一，素有大湖名城、创新高地之称的江淮枢纽名城安徽省合肥市";
        String input_text2 = "学校创建于1945年，1960年被中共中央批准为全国重点大学";
        List<String> input_text_list = new ArrayList<>();
        input_text_list.add(input_text1);
        input_text_list.add(input_text2);
        for (String s : input_text_list) {
            System.out.println(s);
        }

        Jieba jieba = new Jieba();
        String sentence = "";
        List<String> outList = jieba.seg(input_text_list);
        for (String sentence1 : outList) {
            System.out.println(sentence1);
            sentence += sentence1;
        }
        String resource = DemoApplicationTests.class.getClassLoader().getResource("data/stop_words.txt").getPath();
        System.out.println(resource);
        System.out.println("=========");
        System.out.println(sentence);
        System.out.println(WordFiltering.removeSentenceStopWords(
                WordFiltering.removePOSTag(sentence, " "), " ", resource));
    }



    @Test
    public void testDemo() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences =
                new String[] {"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
        }
    }


    @Test
    public void mainquanzhong()
    {
//        String content="孩子上了幼儿园 安全防拐教育要做好";
//        int topN=5;
//        TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
//        List<Keyword> list=tfidfAnalyzer.analyze(content,topN);
//        for(Keyword word:list)
//            System.out.println(word.getName()+":"+word.getTfidfvalue()+",");
        // 防拐:0.1992,幼儿园:0.1434,做好:0.1065,教育:0.0946,安全:0.0924
        System.out.println("开始");
        try {
            System.out.println("=========");
            Thread.sleep(1*60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("====一份之后");
    }


    @Test
    public void ruableTest(){
        String content="孩子上了幼儿园 安全防拐教育要做好";
        int topN=5;
        TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
        List<Keyword> list=tfidfAnalyzer.analyze(content,topN);
        for(Keyword word:list)
            System.out.println(word.getName()+":"+word.getTfidfvalue()+",");

        String name = " asda sd * ad ";

    }

    @Test
    public void ruablefile(){

        URL resource = DemoApplicationTests.class.getClassLoader().getResource("data/stopWords");
        System.out.println(resource);
        System.out.println(0.0023* 10000);

        String str = "select * from l_motherbaby.post limit 1000";
        String reg = "limit (\\d+)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while(m.find()){
            System.out.println(m.start() + "======" + m.end());

            System.out.println(m.group(1));
        }

    }

    @Test
    public void ruablefilecopy(){

        Map ma  = new HashMap();
        List lis1 = new ArrayList();
        lis1.add("name");
        lis1.add("value");

        ma.put("name", "jack");
        lis1.add(ma);

        List list2 = new ArrayList();
        list2.addAll(lis1);
        list2.add("time");


        System.out.println("list1====修改之前=");
        for (Object o : lis1) {
            System.out.println(o);
        }



        System.out.println("list2========");
        Map map = new HashMap();
        list2.add(map);
        map.put("age", "90");
        for (Object o : list2) {
            if (o instanceof Map){
                for (Object o1 : ((Map) o).keySet()) {
                    ((Map) o).put("name","修改之后");
                }
            }


        }

        System.out.println("list1===修改之后==");
        for (Object o : lis1) {
            System.out.println(o);
        }
        int num = -15;
        System.out.println(num*30);
        System.out.println(655/30);

    }


    @Test
    public void TestTry(){

        Map map = new HashMap();
        try{
            int i = 1 / 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
        System.out.println("=====最终======");
    }

    @Test
    public void TestTry1(){
        String data = "hell + " + "\n" + "world";
        System.out.println(data);
        String data1 = data.replaceAll("\n", "").replaceAll(" ", "");
        System.out.println(data1);
        System.out.println(data.replaceAll("\n", "").replaceAll(" ", ""));
    }

    @Test
    public void TestTry12(){
        String data = " hello   ";
        System.out.println(data.length());
        data = data.trim();
        System.out.println(data.length());

        InputStream resourceAsStream = this.getClass().getResourceAsStream("/data/stop_words.txt");
        try {
            System.out.println(resourceAsStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void TestTry122(){
        Map map = new HashMap();
        map.put("name", "jack");
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));

        Map < String , Object > jsonMap = new HashMap< String , Object>();
//        jsonMap.put("a",1);
//        jsonMap.put("b","");
//        jsonMap.put("c",null);
//        jsonMap.put("d","wuzhuti.cn");

//        String str = JSONObject.toJSONString(jsonMap);
//        JSONObject jsonObject = JSON.parseObject(str);

//        格式化null
        String str=null;
        JSONObject jsonObject = JSON.parseObject(str);
        Map<String,Object> map1 = (Map<String,Object>)jsonObject;
        System.out.println("====");
        System.out.println(map1);
//        System.out.println(str);
    }



    @Test
    public void jndoTime(){

//        测试时间DateTime类和Date还有SimpleDateFormat之间的相互转换
        DateTime dateTime = new DateTime();
        // 获取指定String值的DateTime
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime d3 = DateTime.parse("2019-03-09 11:12:55", formatter);
        System.out.println(d3);
        System.out.println(d3.getYear());
        Date dayOfMonth = d3.plusDays(20).toDate();
        System.out.println(dayOfMonth);
//        DateTime dt = new DateTime(dayOfMonth);
//        System.out.println(dt);
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        String str = sdf.format(dayOfMonth);
        System.out.println(str);
    }


    @Test
    public void stringUtilTest(){
//        stringUtil 的isempty和isblank方法
//        String name = null;
        String name = null;
        System.out.println("isblank " + StringUtils.isBlank(name));

        System.out.println("isempty " + StringUtils.isEmpty(name));
//        System.out.println(name.isEmpty());

    }
}
