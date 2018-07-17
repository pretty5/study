package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TEST {
    public static void main(String[] args) {
        String line = "this orde  sadasd for Qt3000 OK? 12";
        String pattern = "(\\D*)(\\d+)(.*)";

        Pattern r = Pattern.compile(pattern);

        Matcher matcher = r.matcher(line);

        if (matcher.find( )){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(2));
        }

    }
}
