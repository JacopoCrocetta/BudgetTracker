package com.project.bebudgeting.entity.importdatafrombank;

import java.time.LocalDate;

import com.project.bebudgeting.helper.TransactionAmount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PendingEntity {
    private TransactionAmount transactionAmount;
    private LocalDate valueDate;
    private String remittanceInformationsUnstructured;
}
