package com.girlscode.cafecomjava;

import com.girlscode.cafecomjava.contexto.PedidoContexto;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.core.CafeFactory;
import com.girlscode.cafecomjava.decorador.CaldasDecorator;
import com.girlscode.cafecomjava.decorador.ChantillyDecorator;
import com.girlscode.cafecomjava.decorador.LeiteDecorator;
import com.girlscode.cafecomjava.decorador.XaropesDecorator;
import com.girlscode.cafecomjava.factory.ColdBrewFactory;
import com.girlscode.cafecomjava.factory.DescafeinadoFactory;
import com.girlscode.cafecomjava.factory.ExpressoFactory;
import com.girlscode.cafecomjava.factory.FiltradoFactory;
import com.girlscode.cafecomjava.strategy.DescontoMembro;
import com.girlscode.cafecomjava.strategy.SemDesconto;


import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) throws IllegalAccessException {

        Scanner scanner = new Scanner(System.in);
        Bebida bebida = null;
        CafeFactory factory = null;

        System.out.println("--- Bem vindo ao Café com Java ---");

        System.out.println("\nEscolha a sua bebida base: ");
        System.out.println("1 - Café Expresso (R$ 5.00)");
        System.out.println("2 - Café Filtrado (R$ 4.00)");
        System.out.println("3 - Café Descafeinado (R$ 7.50)");
        System.out.println("4 - ColdBrew (R$ 8.00)");
        System.out.print("Sua escolha: ");
        int escolhaBase = scanner.nextInt();

        switch (escolhaBase) {
            case 1:
                factory = new ExpressoFactory();
                break;

            case 2:
                factory = new FiltradoFactory();
                break;

            case 3:
                factory = new DescafeinadoFactory();
                break;

            case 4:
                factory = new ColdBrewFactory();
                break;

            default:
                System.out.println("Opção inválida. Usando café Expresso por padrão.");
                factory = new ExpressoFactory();
                break;
        }

        bebida = factory.createBebida();
        System.out.println("\nBase escolhida: " + bebida.getDescricao());

        int toppingChoice = 0;
        
        while (toppingChoice != 5) {

            System.out.println("\nAdicione Toppings na sua bebiba:");

            System.out.println("1 - Leite (R$ 2.50)");
            System.out.println("2 - Chantilly (R$ 3.00)");
            System.out.println("3 - Calda (R$ 3.50)");
            System.out.println("4 - Xarope (R$ 5.00)");
            System.out.println("5 - Finalizar pedido");
            System.out.print("Opção: ");
            int opcaoTopping = scanner.nextInt();

            toppingChoice = opcaoTopping;

            switch (opcaoTopping) {

                case 1:
                    bebida = new LeiteDecorator(bebida);
                    System.out.println(bebida.getDescricao());
                    break;

                case 2:
                    bebida = new ChantillyDecorator(bebida);
                    System.out.println(bebida.getDescricao());
                    break;

                case 3:
                    bebida = new CaldasDecorator(bebida);
                    System.out.println(bebida.getDescricao());
                    break;

                case 4:
                    bebida = new XaropesDecorator(bebida);
                    System.out.println(bebida.getDescricao());
                    break;

                case 5:
                    System.out.println("Finalizando pedido.");
                    break;

                default:
                    System.out.println("Opção de topping inválida. Tente novamente.");
                    break;
            }
            
        }

        double custoTotalDecorado = bebida.getCusto();

        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("Pedido Finalizado com sucesso!");
        System.out.println("Descrição completa: " + bebida.getDescricao());
        System.out.println("Custo Total: R$ " + String.format("%.2f", bebida.getCusto()));

        System.out.print("Você é cliente membro? (S/N)? ");
        String isMembro = scanner.next();

        PedidoContexto contexto = new PedidoContexto();

        if (isMembro.equals("S")) {
            contexto.setStrategy(new DescontoMembro());
        } else {
            contexto.setStrategy(new SemDesconto());
        }

        double custoFinal = contexto.processarDesconto(custoTotalDecorado);

        System.out.println("Custo Final: R$ " + String.format("%.2f", custoFinal));

        System.out.println("-------------------------------------------------------------------------");

        scanner.close();
	}

}
