package com.openmind.hacadaptor.mvc;

/**
 * Created by LiuBin on 2017/6/22.
 */

public class BaseTest {
    public  class Father{
        public String getName() {
            return this.name;
        }

        String name="father";
    }
    public class Child extends Father{
        String name="child";
//        public String getName() {
//            return this.name;
//        }
    }
    public Father getFather(){
        return new Father();
    }

    public Child getChild(){
        return new Child();
    }
    public static void  main(String[] args){
        BaseTest baseTest = new BaseTest();
        Father father = baseTest.getFather();
        Child child = baseTest.getChild();
        System.out.println(father.getName());
        System.out.println(child.getName());
    }
}


