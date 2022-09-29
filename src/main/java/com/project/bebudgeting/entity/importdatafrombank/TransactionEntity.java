package com.project.bebudgeting.entity.importdatafrombank;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection="Transazioni")
public class TransactionEntity {
    private BookedEntity bookedEntity;
    private PendingEntity pendingEntity;
}
