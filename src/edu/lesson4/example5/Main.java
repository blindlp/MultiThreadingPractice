package edu.lesson4.example5;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
    }
}


final class FoodStock {
    private static int burger, sandwich, salad;

    public FoodStock() {
    }

    public static synchronized boolean cookSellburger(String action) {
        if(action.equals("cook")) {
            burger++;
            return true;
        } else if (action.equals("sell")) {
            if(burger > 0) {
                burger--;
                return true;
            }
        }
        return false;
    }

    public static synchronized boolean cookSellSandwich(String action) {
        if(action.equals("cook")) {
            sandwich++;
            return true;
        } else if (action.equals("sell")) {
            sandwich--;
            return true;
        }
        return false;
    }

    public static synchronized boolean cookSellSalad(String action) {
        if(action.equals("cook")) {
            salad++;
            return true;
        } else if(action.equals("sell")) {
            salad--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\tFood Stock burger:  " + burger + " sandwich: " +  sandwich + " salad: " + salad;
    }
}

final class CustomerQueues {
    private static LinkedList<Customer> customerQueue1 = new LinkedList<Customer>();
    private static LinkedList<Customer> customerQueue2 = new LinkedList<Customer>();

    public CustomerQueues() {
    }

    /**
     * Method to manage the customer who enter to the queue
     * @param queue
     * @param customer
     */
    public static void enterCustomer(int queue, Customer customer) {
        if (queue == 0) {
            customerQueue1.addLast(customer);
        } else {
            customerQueue2.addLast(customer);
        }
    }

    /**
     * Attend a customer from the queue
     * @param queue
     * @return cusotmer
     */
    public static Customer attendCustomer(int queue) {
        if( queue == 0) {
            if(customerQueue1.size() > 0) {
               return customerQueue1.removeFirst();
            } else {
                return null;
            }
        } else {
            if (customerQueue2.size() > 0) {
                return customerQueue2.removeFirst();
            } else {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "\tQueue 1:" + customerQueue1 + "\b\tQueue 2: " + customerQueue2;
    }
}

class Customer {
    public int id, timetodecide;
    public String desitedFood;

    public Customer(int id, int timetodecide, String desitedFood) {
        this.id = id;
        this.timetodecide = timetodecide;
        this.desitedFood = desitedFood;
    }

    @Override
    public String toString() {
        return "Uustomer #" + this.id;
    }
}


class Entry extends Thread {
    Random ramdomGenerator = new Random();
    private static int IDs;
    private boolean threadLive = true;

    public Entry() {
    }

    @Override
    public void run() {
        int timeCustomerEnter = 0;
        timeCustomerEnter = 1000 + 1000*ramdomGenerator.nextInt(3);

        try {
            this.sleep(timeCustomerEnter);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
