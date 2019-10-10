import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class SortString {
    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("my first string text");
        stringArrayList.add("another string");
        stringArrayList.add("different");

        Collections.sort(stringArrayList);
        System.out.println(stringArrayList);

        Comparator<String> comparator = new LengthComparator();
        stringArrayList.sort(comparator);
        System.out.println(stringArrayList);

        for (String string : stringArrayList) {
            System.out.println(string);
        }

        System.out.println("\nUsing forEach");
        stringArrayList.forEach(new PrintInline());
    }
}

class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        return 0;
    }
}

class PrintInline implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
