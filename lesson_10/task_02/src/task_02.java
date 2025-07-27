import java.util.Scanner;

public class task_02 {

    public static void main(String[] args) {
        System.out.println("Введите символы: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int count = 0;
        int n = s.length();


        for (int i = 0; i <= n - 5; i++) {
            // Проверяем, является ли текущая строка одной из стрелок
            if (s.charAt(i) == '>' && s.charAt(i + 1) == '>' && s.charAt(i + 2) == '-' &&
                    s.charAt(i + 3) == '-' && s.charAt(i + 4) == '>') {
                count++; // Стрелка ">>-->"
            } else if (s.charAt(i) == '<' && s.charAt(i + 1) == '-' && s.charAt(i + 2) == '-' &&
                    s.charAt(i + 3) == '<' && s.charAt(i + 4) == '<') {
                count++; // Стрелка "<--<<"
            }
        }

        System.out.println(count);
    }
}
