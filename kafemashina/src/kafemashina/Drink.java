package kafemashina;

public class Drink {

	private final int price;
	private final String drinkType;
	
	public Drink(int price, String drinkType) {
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