package org.alliance;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    AtmOperIntf atmOper = new AtmOperImpl();
    int atmnumber = 123;
    int atmpin = 128;

    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to ATM machine");
    System.out.println("Enter atm number: ");
    int atmNumber = in.nextInt();
    System.out.println("Enter pin number: ");
    int atmPin = in.nextInt();

    if (atmNumber == atmnumber && atmPin == atmpin) {
      while (true) {
        System.out.println("1.View balance \n 2.Withdraw Amount \n 3.Deposit Amount \n 4.View Mini statement");
        System.out.println("Enter choice");
        int ch = in.nextInt();
        switch (ch) {
          case 1 -> atmOper.viewBalance();
          case 2 -> {
            System.out.println("Enter the withdraw amount: ");
            double wAmount = in.nextDouble();
            atmOper.withdrawAmount(wAmount);
          }
          case 3 -> {
            System.out.println("Enter the deposit amount: ");
            double dAmount = in.nextDouble();
            atmOper.depositAmount(dAmount);
          }
          case 4 -> atmOper.viewMiniStatement();
          case 5 -> {
            System.out.println("Collect your ATM card. \n Thank you for using ATM.");
            System.exit(0);
          }
          default -> System.out.println("Enter right choice!!");
        }
      }
    } else {
      System.out.println("Validation failed. Please enter correct credentials");
    }
  }
}
