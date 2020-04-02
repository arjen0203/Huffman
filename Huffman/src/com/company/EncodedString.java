package com.company;

import java.util.BitSet;

public class EncodedString {
    public BitSet encoding;
    public int length;

    public EncodedString(BitSet encod, int leng){
        this.encoding = encod;
        this.length = leng;
    }

    @Override
    public String toString(){
        return encoding + "," + length;
     }
}
