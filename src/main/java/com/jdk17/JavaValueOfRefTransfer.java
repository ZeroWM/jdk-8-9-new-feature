package com.jdk17;

public class JavaValueOfRefTransfer {
//  public static void main(String[] args) {
//    int i = 10;
//    pass(i);
//    System.out.println("i:" + i);
//  }
//  static void pass(int j){
//    j = 20;
//    System.out.println("j:" + j);
//  }

//  public static void main(String[] args) {
//    String i = "abc";
//    pass(i);
//    System.out.println("i:" + i);
//  }
//
//  static void pass(String j){
//    j = "bcd";
//    System.out.println("j:" + j);
//  }

  public static void main(String[] args) {
    StringBuilder i = new StringBuilder("abc");
    pass(i);
    System.out.println("i:" + i);
  }
  static void pass(StringBuilder j){
    j = j.append("def");
    System.out.println("j:" + j);
  }
}
