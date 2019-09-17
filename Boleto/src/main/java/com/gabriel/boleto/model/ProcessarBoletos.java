
package com.gabriel.boleto.model;

import java.util.List;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
        
    
    public void processar(String nomeArquivo){
        List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
    }
    


    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
    
    
}
