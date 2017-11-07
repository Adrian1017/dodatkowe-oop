
public class PaperclipSale {
	private String clipsColor;
	private float boxPrice;
	private int boxSoldNumber;
	
	public PaperclipSale( String clipsColor, float boxPrice, int boxSoldNumber) {
		this.clipsColor = clipsColor;
		this.boxPrice = boxPrice;
		this.boxSoldNumber = boxSoldNumber;
	}
	public String getClipsColor() {
		return this.clipsColor;
	}
	public float getBoxPrice() {
		return this.getBoxPrice();
	}
	public int getBoxSoldNumber() {
		return this.boxSoldNumber;
	}
	public float finalCost() {
		return boxSoldNumber * boxPrice;
	}
	@Override
	public String toString() {
		return "Clips color:" + this.clipsColor +"\nPer-box price:" + this.boxPrice +"\nSold boxes:" 
	+ this.boxSoldNumber +"\nFinal cost:" + this.finalCost();
	}
}
