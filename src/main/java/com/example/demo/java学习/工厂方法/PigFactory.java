package com.example.demo.java学习.工厂方法;

public class PigFactory extends Animal {
    @Override
    public Pig newAnimal() {
        return new Pig();
    }

    @Override
    public Pig createAnimal() {
        return new Pig();
    }
}
