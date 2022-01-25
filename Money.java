package kafemashina;

public enum Money {

	FIVES(5, 50),
	TENS(10, 50),
	TWENTIES(20, 50),
	FIFTIES(50, 25),
	LEV(100, 5),
	TWO_LEVA(200, 5);
	
	final int price;
	int count;
	
	Money(int price, int count) {
		this.price = price;
		this.count = count;
	}
	
}
