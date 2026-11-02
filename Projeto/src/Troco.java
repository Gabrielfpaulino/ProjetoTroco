import java.util.Scanner;

public class Troco {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // valores em centavos, do maior para o menor
        int[] valores = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5, 1};
        String[] nomes = {
                "nota de R$ 100", "nota de R$ 50", "nota de R$ 20", "nota de R$ 10",
                "nota de R$ 5", "nota de R$ 2", "moeda de R$ 1",
                "moeda de 50 centavos", "moeda de 25 centavos", "moeda de 10 centavos",
                "moeda de 5 centavos", "moeda de 1 centavo"};
        String[] nomesPlural = {
                "notas de R$ 100", "notas de R$ 50", "notas de R$ 20", "notas de R$ 10",
                "notas de R$ 5", "notas de R$ 2", "moedas de R$ 1",
                "moedas de 50 centavos", "moedas de 25 centavos", "moedas de 10 centavos",
                "moedas de 5 centavos", "moedas de 1 centavo"};

        // Parte A
        int compra = 0;
        boolean aValida = false;
        while (!aValida) {
            System.out.print("Qual o valor da compra? ");
            double valorCompra = scanner.nextDouble();
            int centavos = (int) Math.round(valorCompra * 100);
            if (centavos >= 1) {
                compra = centavos;
                aValida = true;
            } else {
                System.out.println("Valor inválido");
            }
        }
        //Parte B
        int pagamento = 0;
        boolean bValida = false;
        while (!bValida) {
            System.out.print("Qual o valor do pagamento? ");
            double valorPagamento = scanner.nextDouble();
            int dinheiro = (int) Math.round(valorPagamento * 100);
            if (dinheiro >= compra) {
                pagamento = dinheiro;
                bValida = true;
            } else {
                System.out.println("valor de pagamento não aceito");
            }
        }
            int troco = pagamento - compra;
            int trocoOriginal = troco;
            int[] quantidades = new int[valores.length];

            for (int i = 0; i < valores.length; i++) {
                quantidades[i] = troco / valores[i];
                troco = troco % valores[i];
            }
            for (int i = 0; i < valores.length; i++){
                if (quantidades[i] > 0){
                    if (quantidades[i] == 1) {
                        System.out.println(quantidades[i] + " " + nomes[i]);
                    } else {
                        System.out.println(quantidades[i] + " " + nomesPlural[i]);
                        }
                    }
                }
            if (trocoOriginal == 0){
                System.out.println("Sem troco");
            }
            scanner.close();
    }
}