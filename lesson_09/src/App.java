import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TV tv1 = new TV("LG");
        TV tv2 = new TV("Philips");


        //Пример

        tv1.enable();
        tv1.info();
        tv1.disable();

        tv2.enable();
        tv2.info();
        tv2.disable();

        //Пример ввода с клавиатуры
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите бренд TV: ");
        String brand = scanner.nextLine();


        TV tv3 = new TV(brand);
        tv3.enable();
        tv3.info();
    }
}
