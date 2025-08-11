import java.util.*;

class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Имя не может быть пустым");
            throw new IllegalArgumentException();
        }
        if (name.length() < 3) {
            System.out.println("Имя не может быть короче 3 символов");
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            System.out.println("Деньги не могут быть отрицательными");
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean buyProduct(Product product) {
        if (product.getPrice() <= this.money) {
            products.add(product);
            this.money -= product.getPrice();
            return true;
        } else {
            return false;
        }
    }


    public String toString() {
        if (products.isEmpty()) {
            return name + " - Ничего не куплено";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ");
        for (int i = 0; i < products.size(); i++) {
            sb.append(products.get(i).getName());
            if (i != products.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Double.compare(person.money, money) == 0 &&
                name.equals(person.name) &&
                products.equals(person.products);
    }


    public int hashCode() {
        return Objects.hash(name, money, products);
    }
}