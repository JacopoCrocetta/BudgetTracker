package com.project.bebudgeting.helper;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CSVHelperEntity {
    LocalDate data;
    String operazione;
    String dettagli;
    String categoria;
    String importo;
}
