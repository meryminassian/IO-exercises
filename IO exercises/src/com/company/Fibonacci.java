package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Fibonacci {
    public static void main(String[] args) {

        File file = new File("fibonacci.txt");

        try (FileOutputStream output = new FileOutputStream(file)) {

            String f = fibBeforeNth(10).toString();
            byte[] bytes2 = (f + "\n").getBytes();
            output.write(bytes2);

            String s = fiblessThanNumber(10).toString();
            byte[] bytes3 = s.getBytes();
            output.write(bytes3);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int fibonachi(int number){
        if(number == 1 || number==2)
            return 1;
        if(number == 0)
            return 0;
        return fibonachi(number-1) + fibonachi(number -2);
    }

    public static ArrayList<Integer> fibBeforeNth(int number){
        ArrayList<Integer> array = new ArrayList<>();
        while(number > 0){
            array.add(fibonachi(number));
            number--;
        }
        Collections.reverse(array);
        return array;
    }

    public static List<Integer> fiblessThanNumber(int number){
        ArrayList<Integer> array = new ArrayList<>();
        array = fibBeforeNth(number);
        return array.stream()
                .filter(each -> each < number)
                .collect(Collectors.toList());


    }
}

