package test;

import model.Car;
import repository.CarsRepository;
import repository.CarsRepositoryImpl;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // Константы
    private static final String CONST_COLOR = "Black";
    private static final long CONST_MILEAGE = 0L;
    private static final long RANGE_N = 700_000L;
    private static final long RANGE_M = 800_000L;
    private static final String MODEL_1 = "Toyota";
    private static final String MODEL_2 = "Volvo"; // в базе отсутствует, чтобы показать 0

    public static void main(String[] args) {
        String inputFile = "cars.txt";
        String outputFile = "/home/GD.RT.RU/aleksandr.afonichkin/IdeaProjects/JavaRTK/homework011/src/data/output.txt";

        CarsRepository repo = new CarsRepositoryImpl();

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
            List<Car> cars = repo.getAllCars();

            // Вывод всей базы
            writer.write("Автомобили в базе:\n");
            writer.write(" Number Model Color Mileage Cost\n");
            for (Car c : cars) {
                writer.write(" " + c.toString() + "\n");
            }
            writer.write("\n");

            // Номера по цвету или пробегу
            List<String> filteredNumbers = cars.stream()
                    .filter(c -> c.getColor().equalsIgnoreCase(CONST_COLOR) || c.getMileage() == CONST_MILEAGE)
                    .map(Car::getNumber)
                    .collect(Collectors.toList());

            writer.write("Номера автомобилей по цвету \"" + CONST_COLOR + "\" или пробегу " + CONST_MILEAGE + ":\n");
            for (String number : filteredNumbers) {
                writer.write(number + "\n");
            }
            writer.write("\n");

            // Количество уникальных моделей в диапазоне
            long countModelsInRange = cars.stream()
                    .filter(c -> c.getCost() >= RANGE_N && c.getCost() <= RANGE_M)
                    .map(Car::getModel)
                    .distinct()
                    .count();

            writer.write("Количество уникальных моделей в диапазоне " + RANGE_N/1000 + "k - " + RANGE_M/1000 + "k: " + countModelsInRange + "\n");
            writer.write("\n");

            // Цвет с минимальной стоимостью
            Optional<Car> minCostCar = cars.stream().min(Comparator.comparingInt(Car::getCost));
            String minCostColor = minCostCar.isPresent() ? minCostCar.get().getColor() : "Не найдено";

            writer.write("Цвет автомобиля с минимальной стоимостью: " + minCostColor + "\n");
            writer.write("\n");

            // Средняя стоимость моделей
            String modelToFind = MODEL_1;
            double avgCostModel1 = cars.stream()
                    .filter(c -> c.getModel().equalsIgnoreCase(modelToFind))
                    .collect(Collectors.averagingInt(Car::getCost));

            String modelToFind2 = MODEL_2;
            double avgCostModel2 = cars.stream()
                    .filter(c -> c.getModel().equalsIgnoreCase(modelToFind2))
                    .collect(Collectors.averagingInt(Car::getCost));

            writer.write("Средняя стоимость модели " + modelToFind + ": " + String.format("%.2f", avgCostModel1) + "\n");
            // если модель не найдена, возвращается 0.00
            writer.write("Средняя стоимость модели " + modelToFind2 + ": " + String.format("%.2f", avgCostModel2) + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}