import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("ATLETAS");

        Scanner leitor = new Scanner(System.in);
        String nome;
        String nomeMaisAlto = null;
        String sexo = "";
        int countMasculino = 0;
        int countFeminino = 0;
        double altura = 0.0;
        double alturaMaisAlto = 0.0;
        double somaAlturaFeminina = 0.0;
        double peso = 0.0;
        double somaPesos = 0.0;
        boolean continuaLoop = true;

        System.out.print("Qual a quantidade de atletas?");
        int quantidadeAtletas = leitor.nextInt();

        for (int i = 1; i <= quantidadeAtletas; i++){
            System.out.printf("Digite os dados do atleta numero %d:", i);
            System.out.print("\nNome: ");
            nome = leitor.next();
            leitor.nextLine();

            continuaLoop = true;
            while(continuaLoop){
                System.out.print("Sexo: ");
                sexo = leitor.next().toUpperCase();
                if (sexo.equals("F")) {
                    countFeminino++;
                    continuaLoop = false;
                } else if (sexo.equals("M")) {
                    countMasculino++;
                    continuaLoop = false;
                } else {
                    System.out.println("Valor invalido! Favor digitar F ou M: " + sexo);
                }
            }

            continuaLoop = true;
            while(continuaLoop){
                System.out.print("Altura: ");
                altura = leitor.nextDouble();
                if (altura > 0.0) {

                    if (sexo.equals("F"))
                        somaAlturaFeminina += altura;

                    if(altura > alturaMaisAlto) {
                        nomeMaisAlto = nome;
                        alturaMaisAlto = altura;
                    }
                    continuaLoop = false;

                } else {
                    System.out.println("Valor invalido! Favor digitar um valor positivo: " + altura);
                }
            }

            continuaLoop = true;
            while(continuaLoop){
                System.out.print("Peso: ");
                peso = leitor.nextDouble();
                if (peso > 0.0) {
                     somaPesos += peso;
                    continuaLoop = false;

                } else {
                    System.out.println("Valor invalido! Favor digitar um valor positivo: " + altura);
                }
            }

        }

        System.out.println("\nRELATÓRIO");
        double mediaPeso = somaPesos/quantidadeAtletas;
        System.out.printf("Peso médio dos atletas: %.2f\n", mediaPeso);
        System.out.printf("Atletas mais alto: %s\n", nomeMaisAlto);
        double percentHomens = (countMasculino * 100.00)/quantidadeAtletas;
        if (percentHomens > 0)
            System.out.printf("Porcentagem de homens: %.1f %%\n", percentHomens);
        else
            System.out.println("Não há homens cadastrados");

        double mediaAltura = somaAlturaFeminina/countFeminino;
        if (mediaAltura > 0)
            System.out.printf("Altura média das mulheres: %.2f\n", mediaAltura);
        else
            System.out.println("Não há mulheres cadastradas");


    }
}