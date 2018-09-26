package com.spring.study.service;

import org.junit.Assert;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {

        List<Integer> integerList= new ArrayList<>(Arrays.asList(1,2,5,8,14,55,69,523,25,47,76,89,65));

        Set<Integer> integerSet = new HashSet<>(integerList);
        integerList.remove(3);

//        integerList.add(2);
//        integerList.add(62);

        List<Integer> intersect = integerList.stream()
                .filter(((Predicate<Integer>)integerSet::contains).negate())
                .collect(Collectors.toList());


//        System.out.println(integerList.containsAll(integerSet));

        System.out.println(BigDecimal.valueOf(Double.valueOf("256.2999")).compareTo(BigDecimal.valueOf(Double.valueOf("2526.286544"))) == 0);
    }
}
