package com.project.bebudgeting.entity.importdatafrombank;

import java.time.LocalDate;

import javax.persistence.Id;

import com.project.bebudgeting.helper.DebtorAccount;
import com.project.bebudgeting.helper.TransactionAmount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedEntity {
    @Id
    private String transactionId;

    private String debtorName;
    private DebtorAccount debtorAccount;
    private TransactionAmount transactionAmount;
    private String bankTransactionCode;
    private LocalDate bookingDate;
    private LocalDate valueDte;
    private String remittanceInformationsUnstructured;
}
