
public class CarSale {
	private String carModel;
	private float carPrice;
	private float carDiscount;
	
	public CarSale( String carModel, float carPrice, float carDiscount) {
		this.carModel = carModel;
		this.carPrice = carPrice;
		this.carDiscount = carDiscount;
	}
	public String getCarModel() {
		return this.carModel;
	}
	public float getCarPrice() {
		return this.carPrice;
	}
	public float getCarDiscout() {
		return this.carDiscount;
	}
	public float finalCost() {
		return carPrice - ( ( carDiscount * carPrice) / 100);
	}
	@ Override
	public String toString() {
		return "Model:" + carModel + "\nPrice:" + carPrice + "\nDiscout:" + carDiscount 
				+ "\nFinal cost:" + finalCost();
	}
}
