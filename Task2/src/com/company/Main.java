package com.company;

import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void printCarsByTypes(Map<String, List<Car>> carsByTypes)
    {
        for(Map.Entry<String, List<Car>> entry : carsByTypes.entrySet())
        {
            System.out.print(entry.getKey() + ":");
            for(Car car : entry.getValue())
            {
                System.out.print(car.getModel() + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Лада", "седан" ));
        cars.add(new Car("Лада", "хэтчбек" ));
        cars.add(new Car("Мерседес", "седан" ));
        cars.add(new Car("Бмв", "кроссовер" ));
        cars.add(new Car("Форд", "хэтчбек" ));
        cars.add(new Car("Тойота", "седан" ));
        cars.add(new Car("Пежо", "кроссовер" ));


        System.out.println("--------Plain implementation-----------");
        Map<String, List<Car>> carsByTypes = new HashMap<>();
        for(Car car : cars)
            carsByTypes.computeIfAbsent(car.getType(), (k) -> new ArrayList<Car>()).add(car);
        printCarsByTypes(carsByTypes);


        System.out.println("--------Stream implementation-----------");
        var carsByTypesStream = cars.stream().collect(Collectors.groupingBy(Car::getType));
        printCarsByTypes(carsByTypesStream);


        System.out.println("--------BufferedReader Read-----------");
        var lines = FileRead.BufferedRead(Paths.get("src/lines.txt"));
        lines.forEach(System.out::println);


        System.out.println("--------Stream Read-----------");
        lines = FileRead.StreamRead(Paths.get("src/lines.txt"));
        lines.forEach(System.out::println);


        System.out.println("--------number of unique words-----------");
        Set<String> uniqueWords = new TreeSet<String>(Comparator.comparing(String::length).thenComparing(String::compareTo));
        lines.forEach(line -> uniqueWords.addAll(Arrays.asList(line.split(" "))));
        System.out.println(uniqueWords.size());
        System.out.println("--------len lex sort-----------");
        for(String word : uniqueWords)
        {
            System.out.println(word);
        }


        System.out.println("--------words count-----------");
        Map<String, Integer> wordCounter = new HashMap<>();
        List<String> wordsList = new ArrayList<>();
        lines.forEach(line -> wordsList.addAll(Arrays.asList(line.split(" "))));
        for(String word : wordsList)
        {
            wordCounter.computeIfPresent(word, (k, v) -> v + 1);
            wordCounter.computeIfAbsent(word, (k) -> 1);
        }
        for(var entry : wordCounter.entrySet())
            System.out.println(entry.getKey() + ":" + entry.getValue());


        System.out.println("--------lines reverse order-----------");
        ListIterator<String> li = lines.listIterator(lines.size());
        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }


        System.out.println("--------custom backword iterator-----------");
        List<String> linesBackward = new BackwardIterableList<String>();
        linesBackward.addAll(lines);
        for (String s : linesBackward)
            System.out.println(s);


        System.out.println("--------user printer-----------");
        System.out.println("Write number of line to print or \"q\" to exit");
        Scanner in = new Scanner(System.in);
        String command = "";
        while(true)
        {
            command = in.next();
            try
            {
                if(command.equals("q"))
                    break;
                System.out.println(lines.get(Integer.parseInt(command)));
            }catch (IndexOutOfBoundsException e)
            {
                System.out.println("line do not exist");
            }
            catch (NumberFormatException e)
            {
                System.out.println("unknown command");
            }

        }
    }
}
