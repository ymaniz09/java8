import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class SortStringLambda {

    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("my first string text");
        stringArrayList.add("another string");
        stringArrayList.add("different");

        stringArrayList.forEach(new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        stringArrayList.forEach(s -> System.out.println(s));

        stringArrayList.forEach(System.out::println);

        stringArrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                    return -1;
                if (s1.length() > s2.length())
                    return 1;
                return 0;
            }
        });

        System.out.println(stringArrayList);

        // Replacing ith lambda
        stringArrayList.sort((s1, s2) -> {
            if (s1.length() < s2.length())
                return -1;
            if (s1.length() > s2.length())
                return 1;
            return 0;
        });

        System.out.println(stringArrayList);

        // Using Integer.compare
        stringArrayList.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(stringArrayList);

        // Using Comparator.comparingInt
        stringArrayList.sort(Comparator.comparingInt(String::length));
        System.out.println(stringArrayList);

        new Thread(() -> System.out.println("Starting a Runnable")).start();
    }
}
