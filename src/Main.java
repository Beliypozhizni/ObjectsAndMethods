public class Main {

    public static void main(String[] args) {
        Basket basket_1 = new Basket();
        Basket basket_2 = new Basket();

        basket_1.add("Milk", 40, 5, 500);
        basket_1.clear();
        basket_1.add("Egg", 20, 10, 50);
        basket_2.add("Beer", 100, 10, 500);

        System.out.println("Всего корзин: " + Basket.getCountAllBaskets());
        System.out.println("Всего товаров: " + Basket.getCountAllItems());
        System.out.println("Стоимость всех корзин: " + Basket.getPriceAllBaskets());
        System.out.println("Средняя цена корзины: " + Basket.getAveragePriceAllBaskets());
        System.out.println("Средняя цена товара: " + Basket.getAveragePriceAllItems() + "\n");

        basket_1.print("Корзина 1:");
        basket_2.print("Корзина 2:");
    }
}
