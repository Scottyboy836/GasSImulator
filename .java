import java.util.Scanner;
class GasRewards {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the amount of gas (in gallons): ");
    double gasAmount = scanner.nextDouble();
    System.out.print("Are you a rewards member? (y/n): ");
    char rewardsMember = scanner.next().charAt(0);
    Customer customer;
    if (rewardsMember == 'y') {
      System.out.print("Enter your reward level (1-5): ");
      int rewardLevel = scanner.nextInt();
      customer = new RewardsCustomer(rewardLevel);
    } else {
      customer = new RegularCustomer();
    }
    
    System.out.print("Enter the total miles per fill up: ");
    double milesPerFillUp = scanner.nextDouble();
    
    System.out.print("Enter the manufacturer of your vehicle: ");
    String manufacturer = scanner.next();
    
    System.out.print("Enter the model of your vehicle: ");
    String model = scanner.next();
    
    System.out.print("Enter the mileage of your vehicle: ");
    double mileage = scanner.nextDouble();
    
    Vehicle vehicle = new Vehicle(manufacturer, model, mileage);
    double pricePerGallon = customer.getDiscountedPrice();
    double totalCost = gasAmount * pricePerGallon;
    
    double totalMiles = milesPerFillUp / gasAmount;
    System.out.println("Total cost: $" + totalCost);
    System.out.println("Total miles per fill up: " + totalMiles);
    scanner.close();
  }
}
abstract class Customer {
  public abstract double getDiscountedPrice();
}
class RewardsCustomer extends Customer {
  private int rewardLevel;
  public RewardsCustomer(int rewardLevel) {
    this.rewardLevel = rewardLevel;
  }
  @Override
  public double getDiscountedPrice() {
    return 2.50 - (rewardLevel * 0.10);
  }
}
class RegularCustomer extends Customer {
  @Override
  public double getDiscountedPrice() {
    return 3.00;
  }
}
class Vehicle {
  private String manufacturer;
  private String model;
  private double mileage;
  public Vehicle(String manufacturer, String model, double mileage) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.mileage = mileage;
  }
  public double getMileage() {
    return mileage;
  }
  public void setMileage(double mileage) {
    this.mileage = mileage;
  }
}
