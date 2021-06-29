package com.io.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author by chenYl on 2021/5/13 14:55
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class PathNioExample {

    public static void main(String[] args)throws Exception {
        Path path = Paths.get("D:\\tools\\java_pattern\\java_design\\temp.txt");
        byte[] bytes = Files.readAllBytes(path);
        String line = new String(bytes);
        System.out.println(line);

        Set<String> stringSet = new HashSet<>();
        stringSet.add("aa");
        stringSet.add("abb");
        stringSet.add("abbd");
        System.out.println(stringSet.toString());
                BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        bufferedWriter.write("aaaaa ddddd");
        if (bufferedWriter != null){
            bufferedWriter.close();
        }
        BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        if (bufferedReader != null){
            bufferedReader.close();
        }
    }

}
