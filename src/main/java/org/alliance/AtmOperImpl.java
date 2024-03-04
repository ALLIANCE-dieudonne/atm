package org.alliance;

import java.util.HashMap;
import java.util.Map;

public class AtmOperImpl implements AtmOperIntf {
  private final ATM atm = new ATM();
  private final Map<Double, String> ministat = new HashMap<>();

  @Override
  public void viewBalance() {
    System.out.println("The available balance is:  " + " " + atm.getBalance());
  }

  @Override
  public void withdrawAmount(double withdrawAmount) {
    if (atm.getBalance() <= withdrawAmount) {
      System.out.println("No enough funds to withdraw!!");
    } else {
      System.out.println(withdrawAmount + "Withdrawn successfully");
      atm.setBalance(atm.getBalance() - withdrawAmount);
      ministat.put(withdrawAmount, "amount withdrawn.");
      System.out.println("New balance is: " + " " + atm.getBalance());
    }
  }

  @Override
  public void depositAmount(double depositAmount) {
    System.out.println(depositAmount + " Deposited successfully!");
    atm.setBalance(depositAmount + atm.getBalance());
    ministat.put(depositAmount, "amount deposited.");
    System.out.println("New balance is: " + " " + atm.getBalance());
  }

  @Override
  public void viewMiniStatement() {
    for (Map.Entry<Double, String> m : ministat.entrySet()) {
      if (m != null){
        System.out.println(m.getKey() + " " + m.getValue());
      }else {
        System.out.println("No transaction yet!!");
      }
    }
  }
}
