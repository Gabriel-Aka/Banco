
package com.gabriel.boleto.model;

import java.time.format.DateTimeFormatter;
import java.util.List;

public interface LeituraRetorno {

    DateTimeFormatter FormatoData = DateTimeFormatter.ofPattern( "dd/mm/yyyy");
   
    public List<Boleto> lerArquivo (String nomeArquivo);
}
