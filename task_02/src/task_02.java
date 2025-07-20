import java.util.Random;

public class task_02 {
    public static void main(String[] args) {

        Random random = new Random(); //Создание объекта для генерации чисел

        int Vasya = random.nextInt(3); //Случайной число от 0 до 2
        int Petya = random.nextInt(3); //Случайной число от 0 до 2

        System.out.println("Вася выбрал: " + forma(Vasya)); //Выбор Васи
        System.out.println("Петя выбрал: " + forma(Petya)); //Выбор Пети

        int result = winner(Vasya, Petya); //Определение победителя

        //Вывод результата
        if (result == 0) {
            System.out.println("Ничья");}
        else if (result == 1) {
            System.out.println("Вася выиграл");}
        else {
            System.out.println("Петя выиграл");}

    }

    //Метод преобразования числа в фигуру
    public static String forma(int figura) {
        switch (figura) {
            case 0:
                return  "Камень";
            case 1:
                return  "Ножницы";
            case 2:
                return  "Бумага";
            default:
                return  "Ничья";}
    }

    //Метод определения победителя
    public static int winner(int Vasya, int Petya) {
        if (Vasya == Petya) {
            return  0;
        } else if ((Vasya == 0 && Petya == 1) ||
                (Vasya == 1 && Petya == 2) ||
                (Vasya == 2 && Petya == 3)) {
            return 1; //Вася выиграл
        } else {
            return -1; //Петя выиграл
        }
    }
}