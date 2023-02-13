package kafemashina;

public enum Money {

	FIVES(5, 10),
	TENS(10, 1),
	TWENTIES(20, 1),
	FIFTIES(50, 15),
	LEV(100, 2),
	TWO_LEVA(200, 1);
	
	final int price;
	int count;
	
	Money(int price, int count) {
		this.price = price;
		this.count = count;
	}
	
}