import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> productsMap = new HashMap<>();

        // Ввод покупателей
        System.out.println("Введите имя покупателя и сумму денег");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;
            String[] parts = line.split("=");
            String name = parts[0].trim();
            String moneyStr = parts[1].trim();
            try {
                if (name.isEmpty()) {
                    System.out.println("Имя не может быть пустым");
                    continue;
                }
                if (name.length() < 3) {
                    System.out.println("Имя не может быть короче 3 символов");
                    continue;
                }
                double money = Double.parseDouble(moneyStr);
                if (money < 0) {
                    System.out.println("Деньги не могут быть отрицательными");
                    continue;
                }
                Person person = new Person(name, money);
                persons.put(name, person);
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число денег");
            }
        }

        // Ввод продуктов
        System.out.println("Введите продукты и цену");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;
            String[] parts = line.split("=");
            String name = parts[0].trim();
            String priceStr = parts[1].trim();
            try {
                if (name.isEmpty()) {
                    System.out.println("Название продукта не может быть пустым");
                    continue;
                }
                double price = Double.parseDouble(priceStr);
                if (price < 0) {
                    System.out.println("Стоимость не может быть отрицательной");
                    continue;
                }
                Product product = new Product(name, price);
                productsMap.put(name, product);
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число стоимости");
            }
        }

        // Обработка покупок
        System.out.println("Покупка");
        System.out.println("Для завершения введите END");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("END")) break;
            String[] parts = line.split("-");
            String buyerName = parts[0].trim();
            String productName = parts[1].trim();

            Person buyer = persons.get(buyerName);
            Product product = productsMap.get(productName);
            if (buyer.buyProduct(product)) {
                // сообщение о покупке
                String msg = buyer.getName() + " купил " + product.getName();
                // Для "Торт" по примеру в тесте
                if (product.getName().equals("Торт")) {
                    System.out.println(buyer.getName() + " купил " + product.getName());
                } else {
                    System.out.println(msg);
                }
            } else {
                System.out.println(buyer.getName() + " не может позволить себе " + product.getName());
            }
        }

        // вывод итоговых данных
        System.out.println("\nИтог:");
        for (Person person : persons.values()) {
            System.out.println(person.toString());
        }
    }
}