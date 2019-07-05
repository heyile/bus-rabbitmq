package com.rkd.bean;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.SignalType;

public class SampleSubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("hello, i'm Subscribed ");
        request(1);
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.println("hook error");
    }

    @Override
    protected void hookOnCancel() {
        System.out.println("cancel");
    }

    @Override
    protected void hookFinally(SignalType type) {
        System.out.println("finally " + type);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println("on next " + value);
        request(2);
    }
}
