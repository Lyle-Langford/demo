package com.stream8;

import com.pojo.TaskClick;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Lyle
 * @date: 2020/11/24
 * @description:
 **/
public class StreamTest1 {

    public static void main(String[] args) {
        testSort();
    }

    private static void intList(){
        new Random().ints().limit(20).forEach(System.out::println);
    }

    private static void traverse(List<Object> list){
        list.forEach(System.out::println);
    }

    static List<String> simple(){
        List<String> strlist = Arrays.asList("abc",null, "", "bc", "efg", "abcd","", "jkl");
        return strlist.stream()
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }

    static void testMap(){
        List<Integer> numberList = Arrays.asList(1, 2, 3, 2, 4, 5);
        //获取对应的平方数
        numberList.stream()
                .map(item -> item*item)
                .distinct()
                .forEach(System.out::println);
        //squaresList.forEach(System.out::println);
    }

    static void testFilter(){
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(StringUtils::isNotBlank).count();
        System.out.println(count);
    }

    static void testLimit(){
        new Random().ints().limit(10).forEach(System.out::println);
    }
//发送奖励

    static void testSort(){
        new Random().ints().limit(10).sorted()
                .forEach(System.out::println);

        List<TaskClick> clickList = Arrays.asList(new TaskClick(3, "张三"),
                new TaskClick(4, "李四"), new TaskClick(2, "王二"));
        List<TaskClick> sortList = clickList.stream().sorted(Comparator.comparingInt(TaskClick::getUserId)).collect(Collectors.toList());
        sortList.forEach(taskClick -> System.out.println(taskClick.getUserName()));

    }

    static void testParallel(){
        List<String> strList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strList.parallelStream().filter(StringUtils::isNotBlank).count();
        System.out.println(count);
    }

    static void testCollectors(){
        List<String> strList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        //流转String
        List<String> filtered = strList.stream()
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
        //合并字符串
        String mergedString = filtered.stream().collect(Collectors.joining("_"));
        System.out.println(mergedString);
    }

    static void testStatistics(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("最小值:" + stats.getMin());
        System.out.println("最大值:" + stats.getMax());
        System.out.println("和:" + stats.getSum());
        System.out.println("平均值:" + stats.getAverage());
    }

    static void testStatistics2(){
        List<TaskClick> clickList = Arrays.asList(new TaskClick(3, "张三"),
                new TaskClick(4, "李四"), new TaskClick(2, "王二"));
        IntSummaryStatistics stats = clickList.stream()
                .mapToInt(TaskClick::getUserId)
                .summaryStatistics();
        System.out.println("最小值:" + stats.getMin());
        System.out.println("最大值:" + stats.getMax());
        System.out.println("和:" + stats.getSum());
        System.out.println("平均值:" + stats.getAverage());
    }
}
