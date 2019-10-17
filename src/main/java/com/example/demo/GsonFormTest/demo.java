package com.example.demo.GsonFormTest;


//使用 GsonForm插件 可是粘贴json格式的字符串
//然后快速的生成实体类

import java.util.List;

public class demo {


    /**
     * key1 : value1
     * key2 : value2
     * key3 : [{"key31":"value31"},{"key32":"value32"}]
     */

    private String key1;
    private String key2;
    private List<Key3Bean> key3;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public List<Key3Bean> getKey3() {
        return key3;
    }

    public void setKey3(List<Key3Bean> key3) {
        this.key3 = key3;
    }

    public static class Key3Bean {
        /**
         * key31 : value31
         * key32 : value32
         */

        private String key31;
        private String key32;

        public String getKey31() {
            return key31;
        }

        public void setKey31(String key31) {
            this.key31 = key31;
        }

        public String getKey32() {
            return key32;
        }

        public void setKey32(String key32) {
            this.key32 = key32;
        }
    }
}
