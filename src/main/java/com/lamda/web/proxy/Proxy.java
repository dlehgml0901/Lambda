package com.lamda.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

@Component("pxy") @Lazy //지연된 로딩, 메모리에 올라갈때 실행하며, 그외에는 실행시키지 않는다.(성능 향상의 주 목적)
public class Proxy {
    public String string(Object o){
        Function<Object, String> f = String :: valueOf;
        return f.apply(o);
    }
    public int integer(String s){
        Function<String, Integer> f = Integer :: parseInt;
        return f.apply(s);
    }
    public Boolean equals(String x, String y){
        BiFunction<String, String, Boolean> f = String::equals;
        return f.apply(x, y);
    }
    public void print(String t){
        Consumer<String> c = System.out::print;
        c.accept(t);
    }
}