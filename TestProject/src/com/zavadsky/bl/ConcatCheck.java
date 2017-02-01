package com.zavadsky.bl;

import java.util.List;

public class ConcatCheck {
    private List<String> list;
    private int i = 0;

    public boolean isConcat(String iLine) {
        // checking if word ended
        if(iLine.length()<1)
            return true;

        StringBuffer str = new StringBuffer(iLine);

        for (String word : list){
            if(!word.equals("")) // checking if word isn`t absent

                if(!word.equals(str.toString()) || i>0) // checking if it isn`t the same (first time)

                    if(str.toString().startsWith(word)) { // checking if str starts with word
                        str.delete(0, word.length());     // while true - delete first word
                        i++;
                        if(isConcat(str.toString())){     // checking rest parts
                            i--;
                            return true;
                        } else {
                            str.insert(0,word);           // back to previous word
                            i--;
                        }
                }
        }
        return false;
    }

    public ConcatCheck(List<String> list) {
        this.list = list;
    }
}
