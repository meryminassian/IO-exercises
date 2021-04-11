package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainPdf {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\minas\\Desktop\\CS 213");

//        try {
//            Arrays.stream(file.list())
//                    .filter(each -> each.contains(".pdf"))
//                    .forEach(each -> System.out.println(each));
//        } catch (NullPointerException e) {
//            System.out.println("exc");
//        }


        //filtering and getting only those files that are pdf type
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().contains(".pdf");
            }
        };

        File[] pdfFiles = file.listFiles(fileFilter);

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        List<Pdf> pdfObjects = Arrays.stream(pdfFiles)
                .map(each-> new Pdf(each.getName(), each.length()/ 1024 + " kb", sdf.format(each.lastModified())))
                .collect(Collectors.toList());

        File fileForPdfs = new File("textFile-forPDFs.txt");
        try (OutputStream outputStream = new FileOutputStream(fileForPdfs)) {
            String string = pdfObjects.stream()
                    .map(each -> each.toString())
                    .collect(Collectors.joining("\n "));
            byte[] bytes = string.getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(fileForPdfs));
            bufferedReader
                    .lines()
                    .forEach(each -> System.out.println(each));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

