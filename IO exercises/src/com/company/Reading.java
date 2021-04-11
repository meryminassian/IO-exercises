package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Reading {
    public static void main(String[] args) {

        File file = new File("ReadingFrom.txt");

        //by fileinputstream --> Read ALL LINES
        try (InputStream inputStream = new FileInputStream(file)) {
            System.out.println(new String(inputStream.readAllBytes()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //by bufferedReader --> ALL LINES
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(file));
            bufferedReader
                    .lines()
                    .forEach(each -> System.out.println(each));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //reading only 3 lines
        try {
            Files.lines(Path.of(String.valueOf(file)))
                    .limit(3)
                    .forEach(each -> System.out.println(each));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Files.readAllLines --> List<String> (each line as one string)
//        try {
//            Files.readAllLines(Path.of("ReadingFrom.txt"))
//                    .stream()
//                    .limit(3)
//                    .forEach(each-> System.out.println(each));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //reading only 3 lines by bufferedReader
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("ReadingFrom.txt"));
            bufferedReader
                    .lines()
                    .limit(3)
                    .forEach(each -> System.out.println(each));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //adding a new line to the ReadingFrom.txt file by bufferedWriter (by keeping the previous text)
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write("\nnew added text by bufferedWriter");
        } catch (IOException e) {
            e.printStackTrace();
        }



        //copy one file's content to another
        File file2 = new File("newFile.txt");
        try (OutputStream outputStream = new FileOutputStream(file2)){
            String string = Files.readAllLines(Path.of(String.valueOf(file)))
                    .stream()
                    .collect(Collectors.joining("\n"));
            byte[] bytes = string.getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //copying without reading lines
        File file3 = new File("usingFiles'copy.txt");
        try {
            Files.copy(Path.of(String.valueOf(file)), Path.of(String.valueOf(file3)));
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
