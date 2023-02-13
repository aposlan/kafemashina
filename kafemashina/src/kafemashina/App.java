package kafemashina;

import java.util.Scanner;
import java.util.ArrayList;

public class App {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Drink> drinks = new ArrayList<>();
    static int balance = 0;
    static int resto;

    static {
    	
        drinks.add(new Drink(50, "Топъл шоколад"));
        drinks.add(new Drink(60, "Топъл шоколад с мляко"));
        drinks.add(new Drink(40, "Espresso късо"));
        drinks.add(new Drink(50, "Espresso нормално"));
        drinks.add(new Drink(50, "Espresso дълго"));
        drinks.add(new Drink(70, "Кафе 3в1"));
        drinks.add(new Drink(30, "Чай"));
        drinks.add(new Drink(60, "Кафе с бейлис"));
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
        
    }

    public static void main(String[] args){


        System.out.println("  Въведете стойността на стотинката, която вкарвате в машината.");
        String input = "";

        while (!input.contains(".")) {

            input = sc.nextLine();
            int insertedMoney = 0;

            if (!input.contains(".")) {
                if (Integer.parseInt(input) == Money.FIVES.price) {
                    insertedMoney += Money.FIVES.price; //inserted money = 5
                    balance += insertedMoney; //balance = 5
                    System.out.printf("Вкарана сума : %.2f лева" + " | Сегашен баланс : %.2f лева.",
                            ((double) insertedMoney / 100), ((double) balance / 100));
                } else if (Integer.parseInt(input) == Money.TENS.price) {
                    insertedMoney += Money.TENS.price;
                    balance += insertedMoney;
                    System.out.printf("Вкарана сума : %.2f лева" + " | Сегашен баланс : %.2f лева.",
                            ((double) insertedMoney / 100), ((double) balance / 100));
                } else if (Integer.parseInt(input) == Money.TWENTIES.price) {
                    insertedMoney += Money.TWENTIES.price;
                    balance += insertedMoney;
                    System.out.printf("Вкарана сума : %.2f лева" + " | Сегашен баланс : %.2f лева.",
                            ((double) insertedMoney / 100), ((double) balance / 100));
                } else if (Integer.parseInt(input) == Money.FIFTIES.price) {
                    insertedMoney += Money.FIFTIES.price;
                    balance += insertedMoney;
                    System.out.printf("Вкарана сума : %.2f лева" + " | Сегашен баланс : %.2f лева.",
                            ((double) insertedMoney / 100), ((double) balance / 100));
                } else if (Integer.parseInt(input) == Money.LEV.price) {
                    insertedMoney += Money.LEV.price;
                    balance += insertedMoney;
                    System.out.printf("Вкарана сума : %.2f лева" + " | Сегашен баланс : %.2f лева.",
                            ((double) insertedMoney / 100), ((double) balance / 100));
                } else if (Integer.parseInt(input) == Money.TWO_LEVA.price) {
                    insertedMoney += Money.TWO_LEVA.price;
                    balance += insertedMoney;
                    System.out.printf("Вкарана сума : %.2f лева" + " | Сегашен баланс : %.2f лева.",
                            ((double) insertedMoney / 100), ((double) balance / 100));
                } else {
                    System.out.println("Невалидна сума.");
                }
                insertedMoney = 0;
                input = "";
            } else {
                continue;
            }

        }

        chooseCoffee(input);

    }

    public static void chooseCoffee(String input) {

        if (input.contains("1.")) {
            chooseDrink(0);
        } else if (input.contains("2.")) {
            chooseDrink(1);
        } else if (input.contains("3.")) {
            chooseDrink(2);
        } else if (input.contains("4.")) {
            chooseDrink(3);
        } else if (input.contains("5.")) {
            chooseDrink(4);
        } else if (input.contains("6.")) {
            chooseDrink(5);
        } else if (input.contains("7.")) {
            chooseDrink(6);
        } else if (input.contains("8.")) {
            chooseDrink(7);
        } else {
            System.out.println("Не съществува напитка, отговаряща на този номер. Опитайте отново");
            input = sc.nextLine();
            chooseCoffee(input);
        }

    }

    public static void chooseDrink(int num) {

        if (balance >= drinks.get(num).getPrice()) {
            resto = balance - drinks.get(num).getPrice();
            if (resto > 99) {
                System.out.println(
                        "Имате " + (resto / 100) + " лева и " + (resto - (resto / 100) * 100) + " стотинки ресто!"); //520 - (5(защото е int))*100 = 520 - 500 = 20 стотинки
                restoCoins();
                balance = 0;
            } else if (resto < 100) {
                System.out.println("Имате " + resto + " стотинки ресто!");
                restoCoins();
            } else if (resto == 0) {
                System.out.println("Нямате ресто.");
            }
        } else {
            System.out.println("  Недостатъчен баланс.");
            main(null);
        }
        System.out.println("Колко захар желаете? - 1,2,3,4,5");
        int sugar = Integer.parseInt(sc.nextLine());
        try {
            System.out.println(drinks.get(num).getDrinkType() + " се приготвя. Моля изчакайте.");
            Thread.sleep(2500);
            System.out.println("Моля вземете Вашата напитка.");
        } catch (Exception e) {

        }

    }

    public static void restoCoins() {

        if (resto >= Money.TWO_LEVA.price && Money.TWO_LEVA.count > 0) {
            resto -= Money.TWO_LEVA.price; // 3 - resto
            Money.TWO_LEVA.count--; // 20 -> 19
            System.out.println(Money.TWO_LEVA);
            restoCoins();
        } else if (resto >= Money.LEV.price && Money.LEV.count > 0) {
            resto -= Money.LEV.price;
            Money.LEV.count--;
            System.out.println(Money.LEV);
            restoCoins();
        } else if (resto >= Money.FIFTIES.price && Money.FIFTIES.count > 0) {
            resto -= Money.FIFTIES.price;
            Money.FIFTIES.count--;
            System.out.println(Money.FIFTIES);
            restoCoins();
        } else if (resto >= Money.TWENTIES.price && Money.TWENTIES.count > 0) {
            resto -= Money.TWENTIES.price;
            Money.TWENTIES.count--;
            System.out.println(Money.TWENTIES);
            restoCoins();
        } else if (resto >= Money.TENS.price && Money.TENS.count > 0) {
            resto -= Money.TENS.price;
            Money.TENS.count--;
            System.out.println(Money.TENS);
            restoCoins();
        } else if (resto >= Money.FIVES.price && Money.FIVES.count > 0) {
            resto -= Money.FIVES.price;
            Money.FIVES.count--;
            System.out.println(Money.FIVES);
            restoCoins();
        }

    }

}