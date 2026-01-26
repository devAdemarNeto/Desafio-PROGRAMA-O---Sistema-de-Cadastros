package main.java.services;

import main.java.entities.Endereco;
import main.java.entities.Pet;
import main.java.enums.SexoPet;
import main.java.enums.TipoPet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PetService {
    public Pet lerFormulario(Scanner scanner){
        String caminho = "src/resources/formulario.txt";
        String[] respostas = new String[7];
        String rua = "";
        String numero = "";
        String cidade = "";


        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
            String linha;
            int contador = 0;
            while ((linha = br.readLine()) != null){
                System.out.println(linha);
                if (contador == 3){
                    System.out.println("Rua: ");
                    rua = scanner.nextLine();
                    System.out.println("Numero: ");
                    numero = scanner.nextLine();
                    System.out.println("Cidade: ");
                    cidade = scanner.nextLine();
                }else {
                    respostas[contador] = scanner.nextLine();
                }

                contador++;
            }


        }catch (IOException e){
            System.out.println("Não fo possivel ler o arquivo" + e.getMessage());;
        }
        Endereco endereco = new Endereco(numero,cidade,rua);


        Pet pet = new Pet(
                respostas[0],
                TipoPet.valueOf(respostas[1].toUpperCase()),
                SexoPet.valueOf(respostas[2].toUpperCase()),
                endereco ,Double.parseDouble(respostas[4]),
                Double.parseDouble(respostas[5]),
                respostas[6]);
        return pet;
    }


}
