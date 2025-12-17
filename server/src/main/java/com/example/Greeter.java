package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  /**
   * Greets someone with a friendly message.
   * 
   * @param someone the name of the person to greet
   * @return a greeting message
   */
  public String greet(String someone) {
    return String.format("Hello, %s!", someone);
  }
}
