import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Певоре задание:

        // Тестирование MyHashSet
        MyHashSet<String> set = new MyHashSet<>();
        set.add("Яблоко");
        set.add("Банан");
        set.add("Яблоко");
        System.out.println("Множество: " + set);
        set.remove("Банан");
        System.out.println("Множество после удаления \"Банан\": " + set);


        // Тестирование MyArrayList
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(1, 15);
        System.out.println("Лист: " + list);
        list.remove(0);
        System.out.println("Лист после удаления: " + list);
        System.out.println("Элемент листа с индексом \"1\": " + list.get(1));

        //Второе задание:

        List<Student> students = List.of(
                new Student("Иван", List.of(
                        new Book("Java Basics", 2010, 300),
                        new Book("Advanced Java", 2015, 450),
                        new Book("Design Patterns", 1999, 400),
                        new Book("Clean Code", 2008, 350),
                        new Book("Effective Java", 2017, 380)
                )),
                new Student("Мария", List.of(
                        new Book("Spring in Action", 2018, 420),
                        new Book("Hibernate", 2015, 380),
                        new Book("Java Concurrency", 2006, 500),
                        new Book("Kotlin in Action", 2019, 320),
                        new Book("Effective Java", 2017, 380)
                )),
                new Student("Алексей", List.of(
                        new Book("Java Performance", 2012, 400),
                        new Book("Microservices", 2016, 450),
                        new Book("Refactoring", 2002, 350),
                        new Book("Test Driven Development", 2003, 280),
                        new Book("Domain Driven Design", 2005, 520)
                ))
        );

        students.stream()
                .peek(System.out::println) // Выводим каждого студента
                .flatMap(student -> student.getBooks().stream()) // Получаем все книги
                .distinct() // Оставляем только уникальные книги
                .sorted(Comparator.comparingInt(Book::getPages)) // Сортируем по страницам
                .filter(book -> book.getYear() > 2000) // Фильтруем по году выпуска
                .limit(3) // Ограничиваем 3 элементами
                .map(Book::getYear) // Получаем годы выпуска
                .findFirst() // Получаем Optional (первый элемент)
                .ifPresentOrElse( // Обрабатываем Optional
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Книга не найдена")
                );

    }
}