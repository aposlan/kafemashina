package kafemashina;

import java.util.Scanner;
import java.util.ArrayList;

public class App {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Drinks> drinks = new ArrayList<>();
	static int balance = 0;
	
	static {
		drinks.add(new Drinks(50, "Топъл шоколад"));
		drinks.add(new Drinks(60, "Топъл шоколад с мляко"));
		drinks.add(new Drinks(40, "Espresso късо"));
		drinks.add(new Drinks(50, "Espresso нормално"));
		drinks.add(new Drinks(50, "Espresso дълго"));
		drinks.add(new Drinks(70, "Кафе 3в1"));
		drinks.add(new Drinks(30, "Чай"));
		drinks.add(new Drinks(60, "Кафе с бейлис"));
		System.out.println("Машината приема монети от 5, 10, 20, 50, 1лв, 2лв");
		System.out.println("1. " + drinks.get(0).getDrinkType() + " | Цена : " + drinks.get(0).getPrice());
		System.out.println("2. " + drinks.get(1).getDrinkType() + " | Цена : " + drinks.get(1).getPrice());
		System.out.println("3. " + drinks.get(2).getDrinkType() + " | Цена : " + drinks.get(2).getPrice());
		System.out.println("4. " + drinks.get(3).getDrinkType() + " | Цена : " + drinks.get(3).getPrice());
		System.out.println("5. " + drinks.get(4).getDrinkType() + " | Цена : " + drinks.get(4).getPrice());
		System.out.println("6. " + drinks.get(5).getDrinkType() + " | Цена : " + drinks.get(5).getPrice());
		System.out.println("7. " + drinks.get(6).getDrinkType() + " | Цена : " + drinks.get(6).getPrice());
		System.out.println("8. " + drinks.get(7).getDrinkType() + " | Цена : " + drinks.get(7).getPrice());
		System.out.println("  За да изберете напитка, запишете номера й с точка след него.");
		System.out.println("  Въвеждайте стойността, която вкарвате в машината.");
	}

	public static void main(String[] args) {

		String input = "";

		while (!input.contains(".")) {

			input = sc.nextLine();
			int insertedMoney = 0;

			if (!input.contains(".")) {
				if (Integer.parseInt(input) == Money.FIVES.price) {
					insertedMoney += Money.FIVES.price;
					balance += insertedMoney;
					System.out.println("Вкарана сума : " + (double)insertedMoney/100 + " лева" + " | Сегашен баланс : " + (double)balance/100 + " лева.");
				} else if (Integer.parseInt(input) == Money.TENS.price) {
					insertedMoney += Money.TENS.price;
					balance += insertedMoney;
					System.out.println("Вкарана сума : " + (double)insertedMoney/100 + " лева" + " | Сегашен баланс : " + (double)balance/100 + " лева.");
				} else if (Integer.parseInt(input) == Money.TWENTIES.price) {
					insertedMoney += Money.TWENTIES.price;
					balance += insertedMoney;
					System.out.println("Вкарана сума : " + (double)insertedMoney/100 + " лева" + " | Сегашен баланс : " + (double)balance/100 + " лева.");
				} else if (Integer.parseInt(input) == Money.FIFTIES.price) {
					insertedMoney += Money.FIFTIES.price;
					balance += insertedMoney;
					System.out.println("Вкарана сума : " + (double)insertedMoney/100 + " лева" + " | Сегашен баланс : " + (double)balance/100 + " лева.");
				} else if (Integer.parseInt(input) == Money.LEV.price) {
					insertedMoney += Money.LEV.price;
					balance += insertedMoney;
					System.out.println("Вкарана сума : " + (double)insertedMoney/100 + " лева" + " | Сегашен баланс : " + (double)balance/100 + " лева.");
				} else if (Integer.parseInt(input) == Money.TWO_LEVA.price) {
					insertedMoney += Money.TWO_LEVA.price;
					balance += insertedMoney;
					System.out.println("Вкарана сума : " + (double)insertedMoney/100 + " лева" + " | Сегашен баланс : " + (double)balance/100 + " лева.");
				}
				insertedMoney = 0;
				input = "";
			} else {
				continue;
			}

		}

		chooseCoffee(input);

	}

	public static void menu() {
		System.out.println("1. Топъл Шоколад");
		System.out.println("2. Топъл Шоколад С Мляко");
		System.out.println("3. Кафе Еспресо Дълго");
		System.out.println("4. Кафе Еспресо Нормално");
		System.out.println("5. Кафе Еспресо Късо");
		System.out.println("6. Кафе 3в1");
		System.out.println("7. Чай");
		System.out.println("8. Кафе С Бейлис");
	}

	public static void chooseCoffee(String input) {

		if (input.contains("1.") && balance >= drinks.get(0).getPrice()) {
			resto(0);
		} else if (input.contains("2.") && balance >= drinks.get(0).getPrice()) {
			resto(1);
		} else if (input.contains("3.") && balance >= drinks.get(0).getPrice()) {
			resto(2);
		} else if (input.contains("4.") && balance >= drinks.get(0).getPrice()) {
			resto(3);
		} else if (input.contains("5.") && balance >= drinks.get(0).getPrice()) {
			resto(4);
		} else if (input.contains("6.") && balance >= drinks.get(0).getPrice()) {
			resto(5);
		} else if (input.contains("7.") && balance >= drinks.get(0).getPrice()) {
			resto(6);
		} else if (input.contains("8.") && balance >= drinks.get(0).getPrice()) {
			resto(7);
		} else {
			System.out.println("Не съществува напитка, отговаряща на този номер. Опитайте отново");
			input = sc.nextLine();
			chooseCoffee(input);
		}

	}
	
	public static void resto(int num) {
		System.out.println("Колко захар желаете? - 1,2,3,4,5");
		int sugar = Integer.parseInt(sc.nextLine());
		int resto;
		try{
			System.out.println(drinks.get(num).getDrinkType() + " се приготвя. Моля изчакайте.");
			Thread.sleep(2500);
			System.out.println("Моля вземете Вашата напитка.");
		} catch(Exception e) {
			
		}
		if(balance > drinks.get(num).getPrice()) {
			resto = balance - drinks.get(num).getPrice();
			if(resto > 99) {
				System.out.println("Имате " + (resto/100) + " лев и " + (resto-(resto/100)*100) + " стотинки ресто!");
			}
		}
	}

}
