import  java.util.Scanner;

public class task_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //Создание объекта для ввода данных

        System.out.print("Введите имя_пользователя:"); //Запрос имени
        String user = scanner.nextLine();

        System.out.println("Привет, " + user); //Вывод


    }


}
