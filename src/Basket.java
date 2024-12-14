public class Basket {

    private static int priceAllBaskets = 0;
    private static int countAllItems = 0;
    private static int countAllBaskets = 0;

    private String items;
    private int price = 0;
    private int limit;
    private double weight = 0;
    private int count;

    public Basket() {
        items = "Список товаров:";
        this.limit = 1000000;
        countAllBaskets++;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public static int getPriceAllBaskets() {
        return priceAllBaskets;
    }

    public static int getCountAllItems() {
        return countAllItems;
    }

    public static int getCountAllBaskets() {
        return countAllBaskets;
    }

    public static double getAveragePriceAllItems() {
        return (double) priceAllBaskets / countAllItems;
    }

    public static double getAveragePriceAllBaskets() {
        return (double) priceAllBaskets / countAllBaskets;
    }

    private static void changePriceAllBaskets(int price) {
        priceAllBaskets += price;
    }

    private static void changeCountItemsAllBaskets(int count) {
        countAllItems += count;
    }

    public int getCount() {
        return count;
    }

    public void add(String name, int price) {
        add(name, price, 1, 0.0);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0.0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (this.price + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " + count + " шт. - " + price + " руб/шт." + " - " + count * price + " руб.";
        this.price = this.price + count * price;
        this.weight += weight * count;
        this.count += count;

        changePriceAllBaskets(count * price);
        changeCountItemsAllBaskets(count);
    }

    public void clear() {
        changeCountItemsAllBaskets(-count);
        changePriceAllBaskets(-price);
        items = "Список товаров:";
        price = 0;
        weight = 0;
        count = 0;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items + "\n");
        }
    }
}
