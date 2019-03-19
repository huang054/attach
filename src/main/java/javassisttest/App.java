package javassisttest;

import javassisttest.javassisttest.service;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true) {
            new service().say("hello");
        }
    }
}
