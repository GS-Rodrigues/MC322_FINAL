package wms;

import wms.domain.entity.*;
import wms.domain.order.*;

public class Main {
    public static void main(String[] args) {
        // Produtos Exemplos
        Product p1 = new Product("7897832823227", "Régua 30cm Dello", "Dello", "(35) 3435-8900", 50, 10, 100);
        Product p2 = new Product("7897832823236", "Régua 50cm Dello", "Dello", "(35) 3435-8900", 50, 10, 100);
        Product p3 = new Product("7897832823245", "Régua 70cm Dello", "Dello", "(35) 3435-8900", 50, 10, 100);

        // 2. Criar estoque
        Storage storage = new Storage();
        storage.restock(p1, 100);
        storage.restock(p2, 50);
        storage.restock(p3, 60);

        // 3. Criar pedidos de venda
        SellingOrder order1 = new SellingOrder("Cliente A", "12345-678", "PENDING");
        order1.addItem(new OrderItem(p1, 10));
        order1.addItem(new OrderItem(p2, 5));
        order1.addItem(new OrderItem(p3, 20));
    }

}
