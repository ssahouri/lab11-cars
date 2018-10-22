import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarLotApp {

	// making a static variable outside main means it
	// can be shared by all methods
	private static List<Car> list = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		list.add(new Car("Chevy", "Cruz", 2017, 10000.99));
		list.add(new Car("Ford", "Escape", 2015, 8000.79));
		list.add(new Car("GMC", "Terrain", 2016, 15000));
		list.add(new Car("Jeep", "Wrangler", 2013, 17000));
		list.add(new UsedCar("Chevy", "Cruz", 2012, 8000.99, 78000));
		list.add(new UsedCar("Ford", "Fusion", 2016, 10000, 32000));
		list.add(new UsedCar("Chevy", "Malibu", 2012, 7500, 102000));
		list.add(new UsedCar("Lincoln", "Navigator", 2011, 11000, 124000));

		boolean done = false;
		while (!done) {
			System.out.println("Select an option: (list, select, add, quit)");
			String option = sc.next();
			switch (option) {
			case "list":
				doListOption();
				break;
			case "select":
				doSelectOption();
				break;
			case "add":
				doAddOption();
				break;
			case "quit":
				done = true;
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice...");
			}
		}

	}

	private static void doListOption() {
		int carNum = 1;
		for (Car cars : list) {
			System.out.print(carNum + ". " + cars);
			carNum = carNum + 1;
		}
		System.out.println();
	}

	private static void doSelectOption() {
		System.out.println("Select a car from between 1 and " + list.size());
		int select = sc.nextInt();
		System.out.println(list.get(select - 1));
		System.out.println("Would you like to buy this car? (yes/no): ");
		String buyCar = sc.next();
		if (buyCar.equals("yes")) {
			list.remove(select - 1);
		}
		System.out.println();
	}

	private static void doAddOption() {
		System.out.println("Is the car new or used?");
		String typeOfCar = sc.next();
		System.out.println("Enter Make: ");
		String make = sc.next();
		System.out.println("Enter Model: ");
		String model = sc.next();
		System.out.println("Enter Year: ");
		int year = sc.nextInt();
		System.out.println("Enter Price: ");
		double price = sc.nextDouble();
		if (typeOfCar.equals("new")) {

			list.add(new Car(make, model, year, price));
		} else {

			System.out.println("Enter Mileage: ");
			double mileage = sc.nextDouble();

			list.add(new UsedCar(make, model, year, price, mileage));

		}
	}

}
