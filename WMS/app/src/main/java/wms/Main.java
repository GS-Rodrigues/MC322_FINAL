package wms;

import wms.domain.entity.*;
import wms.domain.order.*;

public class Main {
    public static void main(String[] args) {
        // Produtos Exemplos
        Product p1 = new Product("7897832823227", "Régua 30cm Dello", "Dello", "(35) 3435-8900", 50, 10, 100);
        Product p2 = new Product("7897832823236", "Régua 50cm Dello", "Dello", "(35) 3435-8900", 50, 10, 100);
        Product p3 = new Product("7897832823245", "Régua 70cm Dello", "Dello", "(35) 3435-8900", 50, 10, 100);
        Product p4 = new Product("7891360320227", "Lápis 48 Cores Faber Castell Ecolápis", "Faber Castell",
                "(11) 4004-6200", 30, 5, 200);
        Product p5 = new Product("7891360674818", "Lápis 10 Cores Faber Castell", "Faber Castell", "(11) 4004-6200", 40,
                8, 150);
        Product p6 = new Product("7891360458142", "Lápis 24 Cores Faber Castell Linha Vermelha", "Faber Castell",
                "(11) 4004-6200", 20, 4, 100);
        Product p7 = new Product("7891360698449", "Lápis Eco Supersoft 50 Cores Faber Castell", "Faber Castell",
                "(11) 4004-6200", 10, 2, 50);
        Product p8 = new Product("4006381333658", "Marca-Texto Stabilo Boss Vermelho", "Stabilo", "(49) 6024-7500", 25,
                7, 120);
        Product p9 = new Product("4006381333689", "Marca-Texto Stabilo Boss Rosa", "Stabilo", "(49) 6024-7500", 25, 7,
                120);
        Product p10 = new Product("4006381333641", "Marca-Texto Stabilo Boss Verde Claro", "Stabilo", "(49) 6024-7500",
                25, 7, 120);
        Product p11 = new Product("70330179134", "Caneta Esferográfica Bic Cristal Bold 1.6 Azul", "Bic",
                "(16) 2101-2200", 100, 20, 500);
        Product p12 = new Product("70330129665", "Caneta Esferográfica Bic Cristal 1.0 Preta", "Bic", "(16) 2101-2200",
                100, 20, 500);

        Storage storage = new Storage();
        storage.restock(p1, getRandomStock());
        storage.restock(p2, getRandomStock());
        storage.restock(p3, getRandomStock());
        storage.restock(p4, getRandomStock());
        storage.restock(p5, getRandomStock());
        storage.restock(p6, getRandomStock());
        storage.restock(p7, getRandomStock());
        storage.restock(p8, getRandomStock());
        storage.restock(p9, getRandomStock());
        storage.restock(p10, getRandomStock());
        storage.restock(p11, getRandomStock());
        storage.restock(p12, getRandomStock());

        // Pedidos de venda ficticios
        SellingOrder so1 = new SellingOrder("Maria Oliveira", "13465-210", "PENDING");
        so1.addItem(new OrderItem(p1, 3));
        so1.addItem(new OrderItem(p4, 1));
        so1.addItem(new OrderItem(p10, 2));

        SellingOrder so2 = new SellingOrder("João Pereira", "04578-900", "PENDING");
        so2.addItem(new OrderItem(p2, 5));
        so2.addItem(new OrderItem(p6, 2));

        SellingOrder so3 = new SellingOrder("Ana Souza", "22783-112", "PENDING");
        so3.addItem(new OrderItem(p3, 1));
        so3.addItem(new OrderItem(p8, 4));
        so3.addItem(new OrderItem(p11, 12));

        SellingOrder so4 = new SellingOrder("Carlos Silva", "89210-410", "PENDING");
        so4.addItem(new OrderItem(p7, 2));
        so4.addItem(new OrderItem(p9, 3));

        SellingOrder so5 = new SellingOrder("Beatriz Martins", "13084-012", "PENDING");
        so5.addItem(new OrderItem(p2, 7));
        so5.addItem(new OrderItem(p10, 1));
        so5.addItem(new OrderItem(p12, 3));

        SellingOrder so6 = new SellingOrder("Felipe Ramos", "69058-300", "PENDING");
        so6.addItem(new OrderItem(p5, 2));
        so6.addItem(new OrderItem(p1, 6));

        SellingOrder so7 = new SellingOrder("Juliana Castro", "30140-120", "PENDING");
        so7.addItem(new OrderItem(p4, 2));
        so7.addItem(new OrderItem(p8, 1));
        so7.addItem(new OrderItem(p9, 1));
        so7.addItem(new OrderItem(p11, 5));

        SellingOrder so8 = new SellingOrder("Victor Almeida", "49087-330", "PENDING");
        so8.addItem(new OrderItem(p6, 4));
        so8.addItem(new OrderItem(p3, 2));

        SellingOrder so9 = new SellingOrder("Patrícia Torres", "57073-020", "PENDING");
        so9.addItem(new OrderItem(p12, 8));
        so9.addItem(new OrderItem(p7, 3));

        SellingOrder so10 = new SellingOrder("Ricardo Santos", "78050-200", "PENDING");
        so10.addItem(new OrderItem(p1, 10));
        so10.addItem(new OrderItem(p5, 4));
        so10.addItem(new OrderItem(p10, 6));

        storage.receiveSellingOrder(so1);
        storage.receiveSellingOrder(so2);
        storage.receiveSellingOrder(so3);
        storage.receiveSellingOrder(so4);
        storage.receiveSellingOrder(so5);
        storage.receiveSellingOrder(so6);
        storage.receiveSellingOrder(so7);
        storage.receiveSellingOrder(so8);
        storage.receiveSellingOrder(so9);
        storage.receiveSellingOrder(so10);

    }

    private static int getRandomStock() {
        return (int) (Math.random() * 290) + 10;

    }
}
