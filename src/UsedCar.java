
public class UsedCar extends Car {
	private double mileage;

	public UsedCar() {

	}

	public UsedCar(String make, String model, int year, double price, double mileage) {
		super(make, model, year, price);
		this.mileage = mileage;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {

		return getMake()  + "\t"+ getModel()  + "\t"+ getYear()  + "\t"+ getPrice() + "\t"+"(Used)"  + mileage 
				+ "\n";
	}

}
