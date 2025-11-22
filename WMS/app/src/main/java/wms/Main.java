package wms;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import wms.domain.entity.*;
import wms.domain.order.*;

public class Main {
    public static void main(String[] args) {
        // Produtos Exemplos
        Product p1 = new Product("7897832823227", "Régua 30cm Dello", "Dello", "(35) 3435-8900", 50, 100);
        Product p2 = new Product("7897832823236", "Régua 50cm Dello", "Dello", "(35) 3435-8900", 50, 100);
        Product p3 = new Product("7897832823245", "Régua 70cm Dello", "Dello", "(35) 3435-8900", 50, 100);
        Product p4 = new Product("7891360320227", "Lápis 48 Cores Faber Castell Ecolápis", "Faber Castell",
                "(11) 4004-6200", 30, 200);
        Product p5 = new Product("7891360674818", "Lápis 10 Cores Faber Castell", "Faber Castell", "(11) 4004-6200", 40,
                150);
        Product p6 = new Product("7891360458142", "Lápis 24 Cores Faber Castell Linha Vermelha", "Faber Castell",
                "(11) 4004-6200", 20, 100);
        Product p7 = new Product("7891360698449", "Lápis Eco Supersoft 50 Cores Faber Castell", "Faber Castell",
                "(11) 4004-6200", 10, 50);
        Product p8 = new Product("4006381333658", "Marca-Texto Stabilo Boss Vermelho", "Stabilo", "(49) 6024-7500", 25,
                120);
        Product p9 = new Product("4006381333689", "Marca-Texto Stabilo Boss Rosa", "Stabilo", "(49) 6024-7500", 25,
                120);
        Product p10 = new Product("4006381333641", "Marca-Texto Stabilo Boss Verde Claro", "Stabilo", "(49) 6024-7500",
                25, 120);
        Product p11 = new Product("70330179134", "Caneta Esferográfica Bic Cristal Bold 1.6 Azul", "Bic",
                "(16) 2101-2200", 100, 500);
        Product p12 = new Product("70330129665", "Caneta Esferográfica Bic Cristal 1.0 Preta", "Bic", "(16) 2101-2200",
                100, 500);

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

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {

            printMenu();
            System.out.print("Escolha uma opção: ");
            int op = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (op) {

                // === PRODUTOS ===
                case 1 -> inputNewProduct(sc, storage);
                case 2 -> productsList(storage);
                case 3 -> searchProduct(sc, storage);
                case 4 -> updateProduct(sc, storage);

                // === ESTOQUE ===
                case 5 -> reporEstoque(sc, storage);
                case 6 -> baixarEstoque(sc, storage);
                case 7 -> listarEstoque(storage);
                case 8 -> consultarEstoque(sc, storage);

                // === PEDIDO DE COMPRA ===
                case 9 -> criarPedidoCompra(sc, storage);
                case 10 -> adicionarItensCompra(sc, storage);
                case 11 -> processarPedidoCompra(sc, storage);
                case 12 -> listarPedidosCompra(storage);

                // === PEDIDO DE VENDA ===
                case 13 -> criarPedidoVendaCompleto(sc, storage);
                case 14 -> processarPedidoVenda(sc, storage);
                case 15 -> listarPedidosVenda(storage);

                // === UTILIDADES ===
                case 16 -> mostrarLog(storage);
                case 17 -> gerarRelatorioEstoque(storage);

                // === SAIR ===
                case 18 -> running = false;

                default -> System.out.println("Opção inválida.");
            }
            pause(sc);
        }

        sc.close();
    }

    private static void pause(Scanner sc) {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }

    private static void printMenu() {
        System.out.println("\n====== MENU WMS ======");

        System.out.println("\n--- Produtos ---");
        System.out.println("1. Cadastrar produto");
        System.out.println("2. Listar produtos");
        System.out.println("3. Buscar produto");
        System.out.println("4. Atualizar produto");

        System.out.println("\n--- Estoque ---");
        System.out.println("5. Repor estoque");
        System.out.println("6. Baixar estoque");
        System.out.println("7. Listar estoque");
        System.out.println("8. Consultar estoque de um produto");

        System.out.println("\n--- Pedidos de Compra ---");
        System.out.println("9. Criar pedido de compra");
        System.out.println("10. Adicionar itens ao pedido de compra");
        System.out.println("11. Processar pedido de compra");
        System.out.println("12. Listar pedidos de compra");

        System.out.println("\n--- Pedidos de Venda ---");
        System.out.println("13. Criar pedido de venda (com itens)");
        System.out.println("14. Processar pedido de venda");
        System.out.println("15. Listar pedidos de venda");

        System.out.println("\n--- Utilidades ---");
        System.out.println("16. Mostrar log de transações");
        System.out.println("17. Gerar relatório de estoque");

        System.out.println("\n18. Sair");
    }

    private static int getRandomStock() {
        return (int) (Math.random() * 290) + 10;
    }

    private static void inputNewProduct(Scanner sc, Storage storage) {
        System.out.println("=== Cadastro de Produto ===");

        System.out.print("Código de Barra do Produto: ");
        String code = sc.nextLine();
        for (Product p : storage.getProducts()) {
            if (p.getCode().equals(code)) {
                System.out.println("ERRO: Já existe um produto com esse código de barras.");
                return; // aborta o cadastro
            }
        }
        System.out.print("Nome do produto: ");
        String name = sc.nextLine();

        System.out.print("Fornecedor: ");
        String supplier = sc.nextLine();

        System.out.print("Telefone do fornecedor: ");
        String supplierPhone = sc.nextLine();

        System.out.print("Quantidade mínima: ");
        int min = Integer.parseInt(sc.nextLine());
        if (min < 0) {
            System.out.println("ERRO: Este campo apenas aceita numeros não negativos");
            return; // aborta o cadastro
        }

        System.out.print("Quantidade máxima: ");
        int max = Integer.parseInt(sc.nextLine());
        if (max < 1) {
            System.out.println("ERRO: Este campo apenas aceita numeros positivos");
            return; // aborta o cadastro
        }
        System.out.print("Quantidade inicial: ");
        int initial = Integer.parseInt(sc.nextLine());
        if (initial < 0) {
            System.out.println("ERRO: Este campo apenas aceita numeros não negativos");
            return; // aborta o cadastro
        }

        // cria produto
        Product p = new Product(code, name, supplier, supplierPhone, min, max);

        // coloca quantidade inicial no estoque
        storage.restock(p, initial);
    }

    private static void productsList(Storage storage) {
        for (Product item : storage.getProducts()) {
            System.out.println(item.getCode() + " | " + item.getName() + "\n");
        }
    }

    private static void searchProduct(Scanner sc, Storage storage) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("=== Buscar Produto ===\n");
        System.out.print("Código de Barra do Produto: ");
        String code = sc.nextLine();

        for (Product item : storage.getProducts()) {
            if (item.getCode().equals(code)) {
                System.out.println("Codigo:" + item.getCode() + "\nNome:" + item.getName() + "\nCriação:"
                        + item.getCreation().format(fmt) + "\nÚltima Atualização:" + item.getLastUpdate().format(fmt)
                        + "\n");
                return;
            }
        }
        System.out.print("ERRO: Produto não encontrado!");
        return;
    }

    private static void updateProduct(Scanner sc, Storage storage) {
        System.out.print("Código de Barra do Produto: ");
        String code = sc.nextLine();

        Product found = null;
        for (Product p : storage.getProducts()) {
            if (p.getCode().equals(code)) {
                found = p;
                break;
            }
        }

        if (found == null) {
            System.out.println("ERRO: Produto não encontrado.");
            return;
        }
        System.out.println("\n--- Campos ---");
        System.out.println("1. Atualizar Nome");
        System.out.println("2. Atualizar quantidade Mínima");
        System.out.println("3. Atualizar Quantidade Máxima");
        System.out.println("4. Atualizar fornecedor");
        System.out.println("5. Atualizar numero do fornecedor");
        System.out.print("Escolha uma opção: ");
        int op = sc.nextInt();
        sc.nextLine(); // consumir quebra de linha

        switch (op) {
            case 1 -> found.setName(sc.nextLine());
            case 2 -> found.setMinQuantity(sc.nextInt());
            case 3 -> found.setMaxQuantity(sc.nextInt());
            case 4 -> found.setSupplier(sc.nextLine());
            case 5 -> found.setSupplierPhone(sc.nextLine());
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void reporEstoque(Scanner sc, Storage storage) {
    }

    private static void baixarEstoque(Scanner sc, Storage storage) {
    }

    private static void listarEstoque(Storage storage) {
    }

    private static void consultarEstoque(Scanner sc, Storage storage) {
    }

    private static void criarPedidoCompra(Scanner sc, Storage storage) {
    }

    private static void adicionarItensCompra(Scanner sc, Storage storage) {
    }

    private static void processarPedidoCompra(Scanner sc, Storage storage) {
    }

    private static void listarPedidosCompra(Storage storage) {
    }

    private static void criarPedidoVendaCompleto(Scanner sc, Storage storage) {
    }

    private static void processarPedidoVenda(Scanner sc, Storage storage) {
    }

    private static void listarPedidosVenda(Storage storage) {
    }

    private static void mostrarLog(Storage storage) {
    }

    private static void gerarRelatorioEstoque(Storage storage) {
    }
}
