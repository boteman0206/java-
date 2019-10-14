package com.example.demo.JieBatest;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.hfutec.preprocess.wordseg.Jieba;

import java.util.ArrayList;
import java.util.List;

public class demo {

    public static void main(String[] args) {

        List input_text_list = new ArrayList();
        input_text_list.add("我是一个震泽和的为为恶反抗罗马 迷路了为了负‘浪漫派离开那里阿简单方便加婆婆为金额负");
        input_text_list.add("do为额分为科为恶票房佳品我饿 派我饿佛");
        Jieba jieba = new Jieba();
        StringBuilder sentence = new StringBuilder();
        List<String> outList = jieba.seg(input_text_list);
        for (String sentence1 : outList) {
            System.out.println(sentence1);
            sentence.append(sentence1);
        }
        System.out.println(sentence);
    }



}
