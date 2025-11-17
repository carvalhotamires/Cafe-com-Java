package com.girlscode.cafecomjava;

import com.girlscode.cafecomjava.bebidas.CafeDescafeinado;
import com.girlscode.cafecomjava.bebidas.CafeExpresso;
import com.girlscode.cafecomjava.bebidas.CafeFiltrado;
import com.girlscode.cafecomjava.bebidas.ColdBrew;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.decorador.CaldasDecorator;
import com.girlscode.cafecomjava.decorador.ChantillyDecorator;
import com.girlscode.cafecomjava.decorador.LeiteDecorator;
import com.girlscode.cafecomjava.decorador.XaropesDecorator;


import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bebida bebida = null;

        System.out.println("--- Bem vindo ao Café com Java ---");

        System.out.println("Escolha a sua bebida base: ");
        System.out.println("1 - Café Expresso (R$ 5.00)");
        System.out.println("2 - Café Filtrado (R$ 4.00)");
        System.out.println("3 - Café Descafeinado (R$ 7.50)");
        System.out.println("4 - ColdBrew (R$ 8.00)");
        System.out.print("Sua escolha:");
        int escolhaBase = scanner.nextInt();

        switch (escolhaBase) {
            case 1:
                bebida = new CafeExpresso();
                System.out.println(bebida.getDescricao());
                break;

            case 2:
                bebida = new CafeFiltrado();
                System.out.println(bebida.getDescricao());
                break;

            case 3:
                bebida = new CafeDescafeinado();
                System.out.println(bebida.getDescricao());
                break;

            case 4:
                bebida = new ColdBrew();
                System.out.println(bebida.getDescricao());
                break;

            default:
                System.out.println("Opção inválida. Usando café Expresso por padrão.");
                bebida = new CafeExpresso();
                break;
        }
        
        int toppingChoice = 0;
        
        while (toppingChoice != 5) {

            System.out.println("Adicione Toppings na sua bebiba:");

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

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Pedido Finalizado com sucesso!");
        System.out.println("Descrição completa: " + bebida.getDescricao());
        System.out.println("Custo Total: R$ " + String.format("%.2f", bebida.getCusto()));
        System.out.println("-------------------------------------------------------------------------");

        scanner.close();
	}

}
