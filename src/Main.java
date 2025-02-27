import java.sql.SQLOutput;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = leitor.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite o item a ser comprado: ");
            String item = leitor.next();

            leitor.nextLine();

            System.out.println("Digite o valor da compra: ");
            double valor = leitor.nextDouble();

            Compras compras = new Compras(item, valor);
            boolean confirmacaoCompra = cartao.lancaCompra(compras);

            if (confirmacaoCompra){
                System.out.println("Parabéns!!! Compra realizada.");
                System.out.println("Digite 0 para sair e 1 para continuar:  ");
                sair = leitor.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
            }
        }
        System.out.println("----------------------------------------------------");
        System.out.println("                   LISTA DE COMPRAS                 ");
        Collections.sort(cartao.getCompras());
        for (Compras c : cartao.getCompras()){
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }
        System.out.println("----------------------------------------------------");
        }
    }

