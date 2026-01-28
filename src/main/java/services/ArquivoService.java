package main.java.services;

import main.java.entities.Pet;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArquivoService {

    public void salvarPet(Pet pet){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHora = agora.format(formatter);

        String nomeFormatado = pet.getNomeCompleto()
                .replace(" ","")
                .toUpperCase();

        String nomeArquivo = dataHora + "-" + nomeFormatado + ".TXT";
        String caminhoCompleto = "petsCadastrados/" + nomeArquivo;

        String conteudo =
                "1 - " + pet.getNomeCompleto() + "\n"+
                "2 - " + pet.getTipo() + "\n" +
                "3 - " + pet.getSexo() + "\n" +
                "4 - " + pet.getEndereco().getRua() + ", " + pet.getEndereco().getNumero() + ", " + pet.getEndereco().getCidade() +"\n" +
                "5 - " + pet.getIdade() + " anos\n" +
                "6 - " + pet.getPeso() + "Kg\n" +
                "7 - " + pet.getRaca();


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("petsCadastrados/" + nomeArquivo))){
            writer.write(conteudo);

        }catch (IOException e) {
            System.out.println("Erro ao salvar arquivo" + e.getMessage());
        }

    }

    public List<File> listarArquivos(){
        File pasta = new File("petsCadastrados/");
        File[] arquivos = pasta.listFiles(); // retorna um array de arquivos

        if (arquivos == null) {
            return new ArrayList<>(); // lista vazia se a pasta não existe
        }
        return Arrays.asList(arquivos); //  converte AARAY para LIST

    }
}
