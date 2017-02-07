package com.zavadsky.bl;

import java.util.List;

public class ConcatCheck {
    private List<String> list;
    private int k = 0;

    public boolean isConcat(StringBuilder inputLine) {

        if(inputLine.length() == 0)
            return true;

        StringBuilder buffer = new StringBuilder();

        for(int i = 2; i <= inputLine.length(); i++){
            buffer.append(inputLine, 0, i);
            if(list.contains(buffer.toString()) && (!buffer.toString().equals(inputLine.toString()) || k > 0)){
                inputLine.delete(0,buffer.length());
                k++;
                if(isConcat(inputLine)){
                    k = 0;
                    return true;
                } else {
                    k--;
                    inputLine.insert(0,buffer);
                    buffer.delete(0,buffer.length());
                }
            } else {
                buffer.delete(0,buffer.length());
            }
        }
        return false;
    }

    public ConcatCheck(List<String> list) {
        this.list = list;
    }
}
