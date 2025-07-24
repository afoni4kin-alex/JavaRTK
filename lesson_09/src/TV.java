public class TV {

    private boolean enable;
    private final String brand;

    //Конструктор
    public TV(String brand) {
        this.brand = brand;
        this.enable = false; //По умолчанию выключен
    }


    //Методы для управления
    public void enable() {
        if (!enable) {
            enable = true;
            System.out.println("Телевизор " + brand + " включен");
        } else {
            System.out.println("Телевизор уже выключен");
        }
    }
    public void disable() {
        if (enable) {
            enable = false;
            System.out.println("Телевизор " + brand + " выключен");
        } else {
            System.out.println("Телевизор уже выключен");
        }
    }

    //Метод отображения инф. о телевизоре
    public void info() {
        System.out.println("Состояние: " + (enable ? "Включен" : "Выключен"));
        System.out.println("Марка: " + brand);
    }
}

