import java.util.Scanner;

public class task_01 {
    public static void main(String[] args) {

        // Определяем последовательность букв
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите букву: ");
        // Считываем один символ
        String input = scanner.nextLine().toLowerCase();
        char ch = input.charAt(0);

        // Находим индекс введённой буквы
        int index = keyboard.indexOf(ch);


        // Вычисляем индекс соседней слева буквы
        int leftIndex = (index - 1 + keyboard.length()) % keyboard.length();
        char leftLetter = keyboard.charAt(leftIndex);

        // Выводим результат
        System.out.println(leftLetter);
    }
}