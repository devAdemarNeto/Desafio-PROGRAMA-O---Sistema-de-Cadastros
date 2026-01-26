package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String caminho = "src/resources/formulario.txt";
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
            String linha;
            while ((linha = br.readLine()) != null){
                System.out.println(linha);
            }
        }catch (IOException e){
            System.out.println("Não fo possivel ler o arquivo" + e.getMessage());;
        }
        exibirMenu();
    }


    public static void exibirMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (true){
            System.out.println("======= SISTEMA DE ADOÇÃO DE PETS =======");
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.println("==========================================");
            System.out.println("Escolha uma opção:");

            if (scanner.hasNextInt()){
                opcao = scanner.nextInt();

                if (opcao <= 0 ){
                    System.out.println("Digite um número maior que zero");
                }
            }else {
                System.out.println("Digite apenas números");
                scanner.next();
                continue;
            }

            switch (opcao){

                case 1:
                    System.out.println("opção 1 selecionada");
                    break;

                case 2:
                    System.out.println("opção 2 selecionada");
                    break;

                case 3:
                    System.out.println("opção 3 selecionada");
                    break;

                case 4:
                    System.out.println("opção 4 selecionada");
                    break;

                case 5:
                    System.out.println("opção 5 selecionada");
                    break;

                case 6:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Numero inválido");
            }


        }
    }
}
