package com.zavadsky.main;

import com.zavadsky.bl.ConcatCheck;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        int count = 0;
        String first = "";
        String second = "";
        List<String> lines = Files.readAllLines(Paths.get("/words.txt"), StandardCharsets.UTF_8);
        ConcatCheck concatCheck = new ConcatCheck(lines);

        for(String checkedLine : lines){
            if (!checkedLine.equals("")){
                if(concatCheck.isConcat(checkedLine)){
                    count++;
                    if(checkedLine.length()>first.length()){
                        second = first;
                        first = checkedLine;
                    } else {
                        if(checkedLine.length()>second.length())
                            second = checkedLine;
                    }
                }
            }
        }
        System.out.println("1. " + first);
        System.out.println("2. " + second);
        System.out.println("3. " + count);
    }
}
