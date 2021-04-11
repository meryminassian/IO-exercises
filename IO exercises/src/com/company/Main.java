package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Circle circle1 = new Circle(41, "Circle 1");
        Circle circle2 = new Circle(21, "Circle 2");
        Circle circle3 = new Circle(43, "Circle 3");

        Stream<Circle> stream = Stream.of(circle1, circle2, circle3);
        File file = new File("circles.txt");

        try (OutputStream outputStream = new FileOutputStream(file)) {
            String string = stream.map(circle -> circle.toString())
                    .collect(Collectors.joining("\n "));

            byte[] bytes = string.getBytes();
            outputStream.write(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Circle> circles = new ArrayList<>();
        //creating objects from a file
        try {
            List<String> names = Files.lines(Path.of("circles.txt")).
                    filter(each -> each.contains("name")).
                    map(each -> each.split(":")).
                    map(each -> each[1])
                    .collect(Collectors.toList());
            List<Double> radius = Files.lines(Path.of("circles.txt")).
                    filter(each -> each.contains("radius")).
                    map(each -> each.split(":")).
                    map(each -> Double.parseDouble(each[1]))
                    .collect(Collectors.toList());

            for (int i = 0; i < names.size(); i++) {
                circles.add(new Circle(radius.get(i), names.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        circles.forEach(circle -> System.out.println(circle));




    }
}