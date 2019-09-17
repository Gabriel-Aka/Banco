package com.gabriel.boleto.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LeituraRetornoBradesco implements LeituraRetorno{
    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        try {
            //Ler arquivo
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String linha;
            List<Boleto> listaBoletos=new ArrayList<>();
            
            while((linha=reader.readLine())!=null){
                String[] vetor = linha.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.valueOf(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2],FormatoData));
                boleto.setDataPagamemento(LocalDateTime.parse(vetor[3], FormatoData));
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));
               
                
                listaBoletos.add(boleto);
            }
            return listaBoletos;
            
        } catch (IOException ex) {
            Logger.getLogger(LeituraRetornoBancoBrasil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //retorna uma lista vazia
        return Collections.EMPTY_LIST;
    }
}
