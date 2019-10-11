import java.util.*;
import java.util.stream.Collectors;

class Course {
    private String name;
    private int numberStudents;

    public Course(String name, int numberStudents) {
        this.name = name;
        this.numberStudents = numberStudents;
    }

    public String getName() {
        return name;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Python", 45));
        courses.add(new Course("JavaScript", 150));
        courses.add(new Course("Java 8", 113));
        courses.add(new Course("C", 55));
        courses.add(new Course("Angular", 300));
        courses.add(new Course("React", 10));
        courses.add(new Course("Android", 100));

        courses.sort(Comparator.comparing(Course::getNumberStudents));

        // Can't call getName
        System.out.println("Printing courses, toString is not implemented:");
        courses.forEach(System.out::println);

        System.out.println("\nPrinting courses names:");
        courses.forEach(c -> System.out.println(c.getName()));

        System.out.println("\nPrinting courses with more than 100 students:");
        courses.stream()
                .filter(c -> c.getNumberStudents() > 100)
                .forEach(c -> System.out.println(c.getName()));

        System.out.println("\nPrinting number students for courses with more than 100 students:");
        courses.stream()
                .filter(c -> c.getNumberStudents() > 100)
                .map(Course::getNumberStudents)
                .forEach(System.out::println);

        System.out.println("\nPrinting sum of students for courses with more than 100 students:");
        final int sum = courses.stream()
                .filter(c -> c.getNumberStudents() > 100)
                .mapToInt(Course::getNumberStudents)
                .sum();
        System.out.println(sum);

        System.out.println("\nPrinting courses names:");
        courses.stream()
                .map(Course::getName)
                .forEach(System.out::println);

        System.out.println("\nCheck if there is a course with more than 200 students:");
        final Optional<Course> optionalCourse = courses.stream()
                .filter(c -> c.getNumberStudents() > 200)
                .findAny();

        optionalCourse.ifPresent(course -> System.out.println(course.getName()));

        System.out.println("\nCreating a map if there is a course with more than 100 students:");
        Map map = courses
                .stream()
                .filter(c -> c.getNumberStudents() > 100)
                .collect(Collectors.toMap(Course::getName, Course::getNumberStudents));

        System.out.println(map);

        courses.stream()
                .filter(c -> c.getNumberStudents() > 100)
                .collect(Collectors.toMap(Course::getName, Course::getNumberStudents))
                .forEach((name, numberStudents) -> System.out.println(
                        String.format("\nThe course %s has %d students", name, numberStudents)));


    }
}
