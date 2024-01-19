package com.lotus.jewel.sample.reactive;

import io.reactivex.rxjava3.core.*;

public class ReactiveHelloWorld {
    public static void main(String[] args) {

//        https://github.com/ReactiveX/RxJava

        Flowable.just("Hello world").subscribe(System.out::println);

        Flowable.just("Hello", "world", "Rxjava").subscribe(System.out::println);
    }
}
