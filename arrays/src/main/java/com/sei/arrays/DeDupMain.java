package com.sei.arrays;

public class DeDupMain {

    public static void main(String[] args) {
        DeDup d = new DeDup();
        DeDupPrint dp = new DeDupPrint();
        
        dp.printUniqueArray(d.deDupNaive(d.randomIntegers));

        dp.printUniqueArray(d.deDupSet(d.randomIntegers));

        dp.printUniqueArray(d.deDupHashtable(d.randomIntegers));
    }    
}
