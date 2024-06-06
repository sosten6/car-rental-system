import java.util.ArrayList;
import java.util.Scanner;

class Car {
    private final String make;
    private final String model;
    private final int year;
    private final double price;
    private boolean available;

    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.available = true;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Customer {
    private final String name;
    private final int age;
    private final String gender;
    private final String drivingLicense;
    private final String nationalID;
    private Car bookedCar;

    public Customer(String name, int age, String gender, String drivingLicense, String nationalID) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.drivingLicense = drivingLicense;
        this.nationalID = nationalID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public String getNationalID() {
        return nationalID;
    }

    public Car getBookedCar() {
        return bookedCar;
    }

    public void bookCar(Car car) {
        this.bookedCar = car;
        car.setAvailable(false);
    }
}

class RentalAgency {
    private final ArrayList<Car> cars;
    private final ArrayList<Customer> customers;

    public RentalAgency(ArrayList<Car> cars) {
        this.cars = cars;
        this.customers = new ArrayList<>();
    }

    public ArrayList<Car> getAvailableCars() {
        ArrayList<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public void bookCar(Car car, Customer customer) {
        customer.bookCar(car);
        customers.add(customer);
    }

    public void displayBookedCars() {
        if (customers.isEmpty()) {
            System.out.println("No cars have been booked yet.");
        } else {
            System.out.println("Booked Cars:");
            for (Customer customer : customers) {
                Car car = customer.getBookedCar();
                System.out.println("Customer Name: " + customer.getName() + ", Car: " + car.getMake() + " " + car.getModel());
            }
        }
    }
}

public class CarRentalSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Car> cars = new ArrayList<>();
            cars.add(new Car("Toyota", "Camry", 2020, 50.0));
            cars.add(new Car("Honda", "Civic", 2019, 45.0));
            cars.add(new Car("Ford", "Focus", 2018, 40.0));
            RentalAgency rentalAgency = new RentalAgency(cars);
            
            int choice;
            do {
                System.out.println("Welcome to Car Rental System");
                System.out.println("1. View Available Cars");
                System.out.println("2. Book a Car");
                System.out.println("3. Display Booked Cars");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> displayAvailableCars(rentalAgency);
                    case 2 -> bookCar(rentalAgency, scanner);
                    case 3 -> rentalAgency.displayBookedCars();
                    case 4 -> System.out.println("Thank you for using Car Rental System. Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        }
    }

    private static void displayAvailableCars(RentalAgency rentalAgency) {
        ArrayList<Car> availableCars = rentalAgency.getAvailableCars();
        if (availableCars.isEmpty()) {
            System.out.println("No cars available for rent at the moment.");
        } else {
            System.out.println("Available Cars:");
            for (Car car : availableCars) {
                System.out.println("Make: " + car.getMake() + ", Model: " + car.getModel() + ", Year: " + car.getYear() + ", Price: $" + car.getPrice());
            }
        }
    }

    private static void bookCar(RentalAgency rentalAgency, Scanner scanner) {
        ArrayList<Car> availableCars = rentalAgency.getAvailableCars();
        if (availableCars.isEmpty()) {
            System.out.println("No cars available for rent at the moment.");
        } else {
            System.out.println("Select a car to book by entering its index:");
            for (int i = 0; i < availableCars.size(); i++) {
                System.out.println((i + 1) + ". " + availableCars.get(i).getMake() + " " + availableCars.get(i).getModel());
            }
            System.out.print("Enter car index: ");
            int carIndex = scanner.nextInt();
            if (carIndex >= 1 && carIndex <= availableCars.size()) {
                Car selectedCar = availableCars.get(carIndex - 1);
                scanner.nextLine(); // Consume newline
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter your age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter your gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter your driving license number: ");
                String drivingLicense = scanner.nextLine();
                System.out.print("Enter your national ID number: ");
                String nationalID = scanner.nextLine();
                Customer customer = new Customer(name, age, gender, drivingLicense, nationalID);
                rentalAgency.bookCar(selectedCar, customer);
                System.out.println("Car booked successfully!");
            } else {
                System.out.println("Invalid car index.");
            }
        }
    }
}