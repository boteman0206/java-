package com.example.demo.sh256Salt;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;

public class demo {
    public static void main(String[] args) {
        String salt = RandomStringUtils.randomAlphanumeric(20);
        System.out.println(salt);
        salt = "YzcmCZNvbXocrsz9dm8e";
        String admin = new Sha256Hash("admin", salt).toHex();
        System.out.println(admin);

    }
}




