# car-rental-system
                                          Car Rental System

The Car Rental System is a Java application that allows users to manage a car rental agency. The application has the following features:
1. View Available Cars: Users can view the list of available cars for rent, including the car's make, model, year, and price.
2. Book a Car: Users can book a car by selecting an available car from the list and providing their personal information, such as name, age, gender, driving license number, and national ID number.
3. Display Booked Cars: Users can view the list of all the cars that have been booked, along with the customer information.
4. Exit: Users can exit the application.
The application consists of the following classes:

1. Car: Represents a car in the rental agency, with properties such as make, model, year, price, and availability.
2. Customer: Represents a customer who books a car, with properties such as name, age, gender, driving license, and national ID.
3. RentalAgency: Manages the list of cars and customers, and provides methods for booking cars and displaying booked cars.
4. CarRentalSystem: The main class that runs the application and provides the user interface.
Steps on using the car rental system:
1. Run the `CarRentalSystem` class.
2. Choose an option from the menu:
   - View Available Cars
   - Book a Car
   - Display Booked Cars
   - Exit
3. Follow the prompts and instructions for the selected option.
Example output:

Welcome to Car Rental System
1. View Available Cars
2. Book a Car
3. Display Booked Cars
4. Exit
Enter your choice: 1

Available Cars:
Make: Toyota, Model: Camry, Year: 2020, Price: $50.0
Make: Honda, Model: Civic, Year: 2019, Price: $45.0
Make: Ford, Model: Focus, Year: 2018, Price: $40.0

Enter your choice: 2

Select a car to book by entering its index:
1. Toyota Camry
2. Honda Civic
3. Ford Focus
Enter car index: 2
Enter your name: John Doe
Enter your age: 35
Enter your gender: Male
Enter your driving license number: ABC123
Enter your national ID number: 123456789
Car booked successfully!

Enter your choice: 3

Booked Cars:
Customer Name: John Doe, Car: Honda Civic

Enter your choice: 4

Thank you for using Car Rental System. Goodbye!
Conclusion
The Car Rental System demonstrates the use of object-oriented programming concepts in Java, such as classes, objects, encapsulation, and inheritance. 
