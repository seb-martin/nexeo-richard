package fr.nexeo.hello;

import java.util.Random;

class HelloGenerics<T> {
    private static Random random = new Random();

    private T genericProperty;

    HelloGenerics(T genericProperty) {
        this.genericProperty = genericProperty;
    }

    public T getGenericProperty() {
        return genericProperty;
    }

    public static <E> E random(E e1, E e2) {
        return random.nextBoolean() ? e1 : e2;
    }
}
