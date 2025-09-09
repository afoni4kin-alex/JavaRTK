import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class task_01 {

     public static <T> Set<T> getUniqueElements(ArrayList<T> list) {
        // Используем HashSet для автоматического устранения дубликатов
        return new HashSet<>(list);
    }

    // Пример использования
    public static void main(String[] args) {
        ArrayList<String> sampleList = new ArrayList<>();
        sampleList.add("apple");
        sampleList.add("banana");
        sampleList.add("apple");
        sampleList.add("orange");

        Set<String> uniqueSet = getUniqueElements(sampleList);
        System.out.println("Уникальные элементы: " + uniqueSet);
    }
}