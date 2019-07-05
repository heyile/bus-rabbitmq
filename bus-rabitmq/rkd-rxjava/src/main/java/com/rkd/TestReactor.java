package com.rkd;

import com.rkd.bean.SampleSubscriber;
import reactor.core.publisher.Flux;

public class TestReactor {
    public static void main(String[] args) {
        SampleSubscriber<Integer> integerSampleSubscriber = new SampleSubscriber<>();
        Flux<Integer> range = Flux.range(1, 4).map(integer -> {
            if (integer <= 4) {
                return integer;
            }
            throw new RuntimeException("Got 4");
        });
//        range.subscribe(System.out::println, error -> System.out.println(" Error" + error.getMessage()),
//                () -> System.out.println("Done"), s -> integerSampleSubscriber.request(10));
        range.subscribe(integerSampleSubscriber);
    }
}
