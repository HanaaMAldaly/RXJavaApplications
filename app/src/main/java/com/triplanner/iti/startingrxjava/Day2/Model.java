package com.triplanner.iti.startingrxjava.Day2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Hanaa on 5/19/2018.
 */

public class Model {
    public ArrayList<Integer> generateData(){
        ArrayList<Integer> arr=new ArrayList();
        Random random=new Random();
        for (int i=0;i<10;i++) {
            arr.add(random.nextInt(101));
        }
        return arr;
    }
}
