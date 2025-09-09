import java.util.Arrays;
import java.util.Scanner;

public class task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение двух строк
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        // Проверка анаграммы
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
        // Удаляем пробелы и делаем строки строчными для игнорирования регистра
        String sClean = s.replaceAll("\\s", "").toLowerCase();
        String tClean = t.replaceAll("\\s", "").toLowerCase();

        // Проверяем длину
        if (sClean.length() != tClean.length()) {
            return false;
        }

        // Преобразуем строки в массивы символов
        char[] sChars = sClean.toCharArray();
        char[] tChars = tClean.toCharArray();

        // Сортируем массивы
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        // Сравниваем отсортированные массивы
        return Arrays.equals(sChars, tChars);
    }
}