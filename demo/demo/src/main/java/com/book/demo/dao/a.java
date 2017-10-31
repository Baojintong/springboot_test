package com.book.demo.dao;

import java.io.*;

public class a {
    public static void main(String[] args) throws IOException {
        StringWriter sw=new StringWriter();
        byte[] a=new byte[1024];
        while(bis.read(a)!=-1){
            bos.write(a);
        }
        bis.close();
        bos.close();
    }
}
