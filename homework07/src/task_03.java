import java.util.HashSet;
import java.util.Set;

public class task_03 {

    // Возвращаем пересечение двух множеств.
        public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

     // Возвращаем объединение двух множеств.
        public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    // Возвращает элементы первого множества, которых нет во втором.
        public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    // Тестирование методов
    public static void main(String[] args) {
        task_03 ps = new task_03 ();

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        set2.add(4);

        System.out.println("Пересечение: " + ps.intersection(set1, set2));
        System.out.println("Объединение: " + ps.union(set1, set2));
        System.out.println("Разница (set1 без set2): " + ps.relativeComplement(set1, set2));
    }
}