package com.jdk8;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaCase {

    /**
     * 函数式接口是一种包含单一抽象方法（singleabstractmethod）的接口。
     * 类通过为接口中的所有方法提供实现来实现任何接口，这可以通过顶级类（toplevelclass）、内部类甚至匿名内部类完成。
     * <p>
     * 语法：
     * 方法引用包括以下三种形式，其中一种存在一定的误导性。
     * object::instanceMethod　　引用特定对象的实例方法，如System.out::println。
     * Class::staticMethod      引用静态方法，如Math::max。
     * Class::instanceMethod　　调用特定类型的任意对象的实例方法，如String::length。
     */


    public static void main(String[] args) {
        Stream.of("this", "is", "a", "stream", "of", "strings").map(String::length).forEach(System.out::println);

        List<People> peoples = Arrays.asList(new People("aa", "male"), new People("bb", "female"));


        //筛选list集合
        List<String> peopleNames = peoples.stream().map(people -> people.getName()).collect(Collectors.toList());
        peopleNames = peoples.stream().map(People::getName).collect(Collectors.toList());

        //扩充list集合
        List<People> peopleNews = peopleNames.stream().map(s -> new People(s)).collect(Collectors.toList());
        peopleNews = peopleNames.stream().map(People::new).collect(Collectors.toList());


        //构造函数
        peopleNames.stream().map(name -> name.split(" ")).map(People::new).collect(Collectors.toList());


        //字符串排序,自然顺序
        List<String> bonds = Arrays.asList("akk", "wm", "zxl");
        List<String> sorted = bonds.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(sorted);

        //反相顺序
        sorted = bonds.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorted);

        //按小写名称排序
        sorted = bonds.stream().sorted(Comparator.comparing(String::toUpperCase)).collect(Collectors.toList());
        System.out.println(sorted);

        //按姓名长度排序
        sorted = bonds.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println(sorted);

        //按姓名长度排序，如果长度相同按字典排序
        sorted = bonds.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).collect(Collectors.toList());
        System.out.println(sorted);


    }

}

class People {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public People(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public People(String name) {
        this.name = name;
    }

    public People(String[] names) {

    }
}

