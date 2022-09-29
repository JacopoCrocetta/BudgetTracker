package com.project.bebudgeting.service.banca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.bebudgeting.entity.importdatafrombank.TransactionEntity;
import com.project.bebudgeting.repository.banca.ImportDataFromBankRepository;

@Service
public class ImportDataFromBankService {
    @Autowired
    ImportDataFromBankRepository repository;

    // FIND ALL
    public List<TransactionEntity> findAll() {
        return repository.findAll();
    }

    public List<TransactionEntity> findAllByEntity(Example<TransactionEntity> filter) {
        return repository.findAll(filter);
    }

    public List<TransactionEntity> findAllByEntityAndSort(Example<TransactionEntity> filter, Sort sort) {
        return repository.findAll(filter, sort);
    }

    // SAVE
    public List<TransactionEntity> saveDataFromBank() {
        String command = "https://ob.nordigen.com/api/v2/accounts/065da497-e6af-4950-88ed-2edbc0577d20/transactions/";

        try {
            URL obj = new URL(command);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            System.out.println("Impossibile scaricare i dati perchè: " + e.getMessage());
        }

        return null;
    }
}
