package com.project.bebudgeting.helper;

public class Utility {
    public String setDescrizioneAttivita(String descrizione, String categoria) {
        String descrizioneRet = null;
        if (!descrizione.isEmpty() || categoria.isEmpty()) {
            descrizioneRet = descrizione;
        } else if (!descrizione.isEmpty() || categoria.isEmpty()) {
            descrizioneRet = descrizione;
        } else if (descrizione.isEmpty() || !categoria.isEmpty()) {
            descrizioneRet = categoria;
        }
        return descrizioneRet;
    }

    public String setValuta(String currency, String valuta) {
        String valutaRet = null;
        if (!currency.isEmpty() || valuta.isEmpty()) {
            valutaRet = currency;
        } else if (!currency.isEmpty() || valuta.isEmpty()) {
            valutaRet = currency;
        } else if (currency.isEmpty() || !valuta.isEmpty()) {
            valutaRet = valuta;
        }
        return valutaRet;
    }

    public String setImporto(String amount, String importo) {
        String importoRet = null;
        if (!amount.isEmpty() || importo.isEmpty()) {
            importoRet = amount;
        } else if (!amount.isEmpty() || importo.isEmpty()) {
            importoRet = amount;
        } else if (amount.isEmpty() || !importo.isEmpty()) {
            importoRet = importo;
        }
        return importoRet;
    }
}
