package com.project.bebudgeting.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Data", "account", "amount", "currency", "Description" };

    public boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public List<CSVHelperEntity> csvToTutorials(InputStream is) {
        Utility utility = new Utility();
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<CSVHelperEntity> tutorials = new ArrayList<CSVHelperEntity>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                CSVHelperEntity tutorial = new CSVHelperEntity();

                DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
                try {
                    LocalDate datetime = LocalDate.parse(csvRecord.get("Data"), pattern);
                    System.out.println(datetime);
                    tutorial.setData(datetime);
                } catch (DateTimeParseException e) {
                    // DateTimeParseException - Text '2019-nov-12' could not be parsed at index 5
                    // Exception handling message/mechanism/logging as per company standard
                    System.out.println(e.getMessage());
                }

                tutorial.setCategoria(
                        utility.setDescrizioneAttivita(csvRecord.get("description"), csvRecord.get("Categoria")));
                tutorial.setOperazione(csvRecord.get("Operazione"));
                tutorial.setImporto(utility.setImporto(csvRecord.get("amount"), csvRecord.get("importo")));
                tutorial.setDettagli(csvRecord.get("dettagli"));

                tutorials.add(tutorial);
            }

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
