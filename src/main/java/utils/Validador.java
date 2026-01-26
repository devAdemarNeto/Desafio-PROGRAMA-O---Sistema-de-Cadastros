package main.java.utils;

import main.java.exceptions.CadastroException;

public class Validador {
    public static void validarNome(String nome){
        if (!nome.contains(" ")){
            throw new CadastroException("Nome deve ter nome e sobrenome");
        }

        if (!nome.matches("^[a-zA-ZÀ-ú\\s]+$")){
            throw new CadastroException("Nome só pode conter letras!");
        }
    }

    public static void validarPeso(double peso){
        if (peso > 60 || peso <0.5){
            throw new CadastroException("Peso deve estar entre 0.5kg e 60kg");
        }
    }
}
