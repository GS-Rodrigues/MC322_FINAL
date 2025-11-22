package wms;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import wms.domain.entity.*;
import wms.domain.order.*;
import wms.support.Truncar;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        // Dados iniciais Fictícios
        {
            Product p1 = new Product("7897832823227", "Régua 30cm Dello", "Dello", "(35) 3435-8900", 50, 100);
            Product p2 = new Product("7897832823236", "Régua 50cm Dello", "Dello", "(35) 3435-8900", 50, 100);
            Product p3 = new Product("7897832823245", "Régua 70cm Dello", "Dello", "(35) 3435-8900", 50, 100);
            Product p4 = new Product("7891360320227", "Lápis 48 Cores Faber Castell Ecolápis", "Faber Castell",
                    "(11) 4004-6200", 30, 200);
            Product p5 = new Product("7891360674818", "Lápis 10 Cores Faber Castell", "Faber Castell", "(11) 4004-6200",
                    40,
                    150);
            Product p6 = new Product("7891360458142", "Lápis 24 Cores Faber Castell Linha Vermelha", "Faber Castell",
                    "(11) 4004-6200", 20, 100);
            Product p7 = new Product("7891360698449", "Lápis Eco Supersoft 50 Cores Faber Castell", "Faber Castell",
                    "(11) 4004-6200", 10, 50);
            Product p8 = new Product("4006381333658", "Marca-Texto Stabilo Boss Vermelho", "Stabilo", "(49) 6024-7500",
                    25,
                    120);
            Product p9 = new Product("4006381333689", "Marca-Texto Stabilo Boss Rosa", "Stabilo", "(49) 6024-7500", 25,
                    120);
            Product p10 = new Product("4006381333641", "Marca-Texto Stabilo Boss Verde Claro", "Stabilo",
                    "(49) 6024-7500",
                    25, 120);
            Product p11 = new Product("70330179134", "Caneta Esferográfica Bic Cristal Bold 1.6 Azul", "Bic",
                    "(16) 2101-2200", 100, 500);
            Product p12 = new Product("70330129665", "Caneta Esferográfica Bic Cristal 1.0 Preta", "Bic",
                    "(16) 2101-2200",
                    100, 500);

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

        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {

            printMenu();
            System.out.print("Escolha uma opção: ");
            int op = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (op) {

                // PRODUTOS
                case 1 -> inputNewProduct(sc, storage);
                case 2 -> productsList(storage);
                case 3 -> searchProduct(sc, storage);
                case 4 -> updateProduct(sc, storage);

                // ESTOQUE
                case 5 -> input(sc, storage);
                case 6 -> output(sc, storage);
                case 7 -> StorageList(storage);
                case 8 -> productConsult(sc, storage);

                // PEDIDO DE COMPRA
                case 9 -> processPurchaseOrder(sc, storage);
                case 10 -> lisOfPO(storage);

                // PEDIDO DE VENDA
                case 11 -> newSellingOrder(sc, storage);
                case 12 -> processSellingOrder(sc, storage);
                case 13 -> listarPedidosVenda(storage);

                // UTILIDADES
                case 14 -> mostrarLog(storage);
                case 15 -> gerarRelatorioEstoque(storage);

                // SAIR
                case 16 -> running = false;

                default -> System.out.println("Opção inválida.");
            }

            pause(sc);
        }

        sc.close();
    }

    /**
     * Aguarda o usuário pressionar ENTER antes de continuar a execução.
     *
     * @param sc Scanner para capturar a entrada do usuário.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
    private static void pause(Scanner sc) {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }

    /**
     * Exibe o menu principal do sistema WMS com todas as opções disponíveis.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
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
        System.out.println("9. Processar pedido de compra");
        System.out.println("10. Listar pedidos de compra");

        System.out.println("\n--- Pedidos de Venda ---");
        System.out.println("11. Criar pedido de venda (com itens)");
        System.out.println("12. Processar pedido de venda");
        System.out.println("13. Listar pedidos de venda");

        System.out.println("\n--- Utilidades ---");
        System.out.println("14. Mostrar log de transações");
        System.out.println("15. Gerar relatório de estoque");

        System.out.println("\n16. Sair");
    }

    /**
     * Gera uma quantidade aleatória para uso como estoque inicial (dados
     * simulados).
     *
     * @return Um valor entre 10 e 299 representando uma quantidade aleatória.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
    private static int getRandomStock() {
        return (int) (Math.random() * 290) + 10;
    }

    /**
     * Realiza o cadastro de um novo produto no sistema. Valida código duplicado,
     * coleta dados do usuário e adiciona o produto ao estoque já com quantidade
     * inicial.
     *
     * @param sc      Scanner para entrada do usuário.
     * @param storage Instância do Storage onde o produto será armazenado.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
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

    /**
     * Lista todos os produtos cadastrados exibindo código e nome.
     *
     * @param storage Instância do Storage que contém os produtos.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
    private static void productsList(Storage storage) {
        for (Product item : storage.getProducts()) {
            System.out.println(item.getCode() + " | " + item.getName() + "\n");
        }
    }

    /**
     * Busca um produto pelo código de barras e exibe seus dados detalhados.
     *
     * @param sc      Scanner para entrada do usuário.
     * @param storage Instância do Storage contendo os produtos.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
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

    /**
     * Atualiza campos específicos de um produto existente. Localiza pelo código e
     * permite alterar nome, min, max, fornecedor e telefone.
     *
     * @param sc      Scanner para entrada do usuário.
     * @param storage Instância do Storage que contém os produtos.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
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
            case 2 -> found.setMinQuantity(Integer.parseInt(sc.nextLine()));
            case 3 -> found.setMaxQuantity(Integer.parseInt(sc.nextLine()));
            case 4 -> found.setSupplier(sc.nextLine());
            case 5 -> found.setSupplierPhone(sc.nextLine());
            default -> System.out.println("Opção inválida.");
        }
    }

    /**
     * Realiza uma entrada de produtos no estoque. Valida existência do produto e
     * quantidade positiva.
     *
     * @param sc      Scanner para entrada do usuário.
     * @param storage Instância do Storage responsável pelos produtos.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
    private static void input(Scanner sc, Storage storage) {
        Product p = null;
        System.out.println("=== Entrada de Produto ===");
        System.out.print("Código de Barra do Produto: ");
        String code = sc.nextLine();
        for (Product item : storage.getProducts()) {
            if (item.getCode().equals(code)) {
                p = item;
                break;
            }
        }
        if (p == null) {
            System.out.println("ERRO: Produto não encontrado no estoque. Operação Cancelada");
            return;
        } else {
            System.out.print("Digite a quantidade de entrada: ");
            int qtd = Integer.parseInt(sc.nextLine());
            if (qtd <= 0) {
                System.out.println("ERRO: Este campo apenas aceita numeros positivos. Operação Cancelada.");
                return;
            }
            storage.restock(p, qtd);
        }
    }

    /**
     * Realiza a saída de produtos do estoque.Valida existência do produto,
     * quantidade positiva e estoque suficiente.
     *
     * @param sc      Scanner para entrada do usuário.
     * @param storage Instância do Storage responsável pelos produtos.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
    private static void output(Scanner sc, Storage storage) {
        Product p = null;
        System.out.println("=== Saida de Produto ===");
        System.out.print("Código de Barra do Produto: ");
        String code = sc.nextLine();
        for (Product item : storage.getProducts()) {
            if (item.getCode().equals(code)) {
                p = item;
                break;
            }
        }
        if (p == null) {
            System.out.println("ERRO: Produto não encontrado no estoque. Operação Cancelada");
            return;
        } else {
            System.out.print("Digite a quantidade de saida: ");
            int qtd = Integer.parseInt(sc.nextLine());
            if (qtd <= 0) {
                System.out.println("ERRO: Este campo apenas aceita numeros positivos. Operação Cancelada.");
                return;
            }
            if (p.getCurrentQuantity() < qtd) {
                System.out.println("ERRO: Não temos essa quantidade em estoque para saida. Operação Cancelada.");
                return;
            }
            storage.withdraw(p, qtd);
        }
    }

    /**
     * Exibe uma listagem completa dos produtos em formato de tabela, incluindo
     * código, nome truncado, quantidades, limites e fornecedor.
     *
     * @param storage Instância do Storage que contém a lista de produtos.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
    private static void StorageList(Storage storage) {
        List<Product> produtos = storage.getProducts();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado. Operação Cancelada.");
            return;
        }

        System.out.println("\n=== LISTA DE PRODUTOS ===");

        // Cabeçalho da tabela
        System.out.printf("%-15s %-30s %-10s %-10s %-10s %-10s\n", "CÓDIGO", "NOME", "ATUAL", "MIN", "MAX",
                "FORNECEDOR");

        System.out.println(
                "--------------------------------------------------------------------------------------------");

        // Linhas
        for (Product p : produtos) {

            String nome = Truncar.truncar(p.getName(), 35);
            String fornecedor = Truncar.truncar(p.getSupplier(), 20);
            System.out.printf("%-13s %-35s %-6d %-6d %-6d %-20s%n",
                    p.getCode(),
                    nome,
                    p.getCurrentQuantity(),
                    p.getMinQuantity(),
                    p.getMaxQuantity(),
                    fornecedor);
        }
    }

    /**
     * Exibe as informações de estoque de um produto em formato de tabela, incluindo
     * código, nome truncado, quantidades, limites e fornecedor.
     * 
     * @param sc      Scanner para entrada do usuário.
     * @param storage Instância do Storage que contém a lista de produtos.
     * 
     * @author Guilherme Rodrigues
     * @version 1.0
     * @since 2025-11-22
     */
    private static void productConsult(Scanner sc, Storage storage) {
        System.out.println("=== Consultar Produto ===\n");
        System.out.print("Código de Barra do Produto: ");
        String code = sc.nextLine();

        for (Product p : storage.getProducts()) {
            if (p.getCode().equals(code)) {
                System.out.printf("%-15s %-30s %-10s %-10s %-10s %-10s\n", "CÓDIGO", "NOME", "ATUAL", "MIN", "MAX",
                        "FORNECEDOR");
                System.out.println(
                        "--------------------------------------------------------------------------------------------");
                String nome = Truncar.truncar(p.getName(), 35);
                String fornecedor = Truncar.truncar(p.getSupplier(), 20);
                System.out.printf("%-15s %-30s %-10d %-10d %-10d %-10s%n",
                        p.getCode(),
                        nome,
                        p.getCurrentQuantity(),
                        p.getMinQuantity(),
                        p.getMaxQuantity(),
                        fornecedor);
                return;
            }
        }
        System.out.print("ERRO: Produto não encontrado!");
        return;
    }

    private static void processPurchaseOrder(Scanner sc, Storage storage) {
        System.out.println("=== Processar PO===\n");
        System.out.print("Código do PO:");
        String code = sc.nextLine();

        for (PurchaseOrder item : storage.getOrderManager().getPo()) {
            if (item.getCode().equals(code)) {
                storage.purchase(item);
                return;
            }
        }
        System.out.print("ERRO: Pedido não encontrado! Operação Cancelada.");
        return;
    }

    private static void lisOfPO(Storage storage) {
        List<PurchaseOrder> pedidos = storage.getOrderManager().getPo();

        if (pedidos.isEmpty()) {
            System.out.println("\nNenhum pedido de compra cadastrado.");
            return;
        }

        System.out.println("\n=== LISTA DE PEDIDOS DE COMPRA ===");
        System.out.printf("%-10s %-20s %-15s %-10s\n",
                "CÓDIGO", "FORNECEDOR", "TELEFONE", "STATUS");
        System.out.println("--------------------------------------------------------------");

        for (PurchaseOrder po : pedidos) {
            System.out.printf("%-10s %-20s %-15s %-10s\n",
                    po.getCode(),
                    Truncar.truncar(po.getSupplier(), 20),
                    po.getSupplierPhone(),
                    po.getStatus());

            // Exibe itens do pedido (se houver)
            if (!po.getItens().isEmpty()) {
                System.out.println("  Itens:");
                for (OrderItem item : po.getItens()) {
                    System.out.println("    - " + item.getProduct().getName() +
                            " | Qtd: " + item.getQuantity());
                }
            }

            System.out.println("--------------------------------------------------------------");
        }
    }

    private static void newSellingOrder(Scanner sc, Storage storage) {
        System.out.println("=== Criar Pedido de Venda ===");

        // Dados do cliente
        System.out.print("Nome do cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.print("CEP do cliente: ");
        String cepCliente = sc.nextLine();

        SellingOrder pedido = new SellingOrder(nomeCliente, cepCliente, "PENDING");
        while (true) {
            System.out.print("Código do produto (ou 'sair' para finalizar o pedido): ");
            String codigo = sc.nextLine();
            if (codigo.equalsIgnoreCase("sair")) {
                break;
            }

            Product produto = storage.getProductByCode(codigo);
            if (produto == null) {
                System.out.println("Produto não encontrado!");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade;
            try {
                quantidade = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida!");
                continue;
            }

            if (quantidade > produto.getCurrentQuantity()) {
                System.out.println("Estoque insuficiente! Disponível: " + produto.getCurrentQuantity());
                continue;
            }

            // Adiciona o item ao pedido
            pedido.addItem(new OrderItem(produto, quantidade));

            System.out.println("Item adicionado ao pedido!");
        }

        if (pedido.getItens().isEmpty()) {
            System.out.println("Pedido vazio. Nenhum item adicionado.");
        } else {
            storage.receiveSellingOrder(pedido);
            System.out.println("Pedido de venda criado com sucesso!");
        }
    }

    private static void processSellingOrder(Scanner sc, Storage storage) {
        System.out.println("=== Processar Ordem de Venda===\n");
        System.out.print("Código da Ordem de Venda:");
        String code = sc.nextLine();

        for (SellingOrder item : storage.getOrderManager().getSo()) {
            if (item.getCode().equals(code)) {
                storage.sell(item);
                return;
            }
        }
        System.out.print("ERRO: Pedido não encontrado! Operação Cancelada.");
        return;
    }

    private static void listarPedidosVenda(Storage storage) {
    }

    private static void mostrarLog(Storage storage) {
    }

    private static void gerarRelatorioEstoque(Storage storage) {
    }
}
