package com.zavadsky.main;

import com.zavadsky.bl.ConcatCheck;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        long curTime = System.currentTimeMillis();
        int i = 0, count = 0;
        String first = "";
        String second = "";
        List<String> lines = Files.readAllLines(Paths.get("E://words.txt"), StandardCharsets.UTF_8);

        ConcatCheck concatCheck = new ConcatCheck(lines);
        for(String checkedLine : lines){
//            i++;
//            if(i%1000 == 0)
//                System.out.println((System.currentTimeMillis() - curTime)/1000 + " sec");
            if (!checkedLine.equals("")){
                if(concatCheck.isConcat(new StringBuilder(checkedLine))){
                    count++;
                    if(checkedLine.length() > first.length()){
                        second = first;
                        first = checkedLine;
                    } else {
                        if(checkedLine.length() > second.length())
                            second = checkedLine;
                    }
                }
            }
        }
        curTime = System.currentTimeMillis() - curTime;
        System.out.println(curTime/1000 + " sec");
        System.out.println("1. " + first);
        System.out.println("2. " + second);
        System.out.println("3. " + count);
    }
}
