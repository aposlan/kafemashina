package kafemashina;

public class Drinks {

	private final int price;
	private final String drinkType;
	
	public Drinks(int price, String drinkType) {
		this.price = price;
		this.drinkType = drinkType;
	}

	public int getPrice() {
		return price;
	}

	public String getDrinkType() {
		return drinkType;
	}
	
}
