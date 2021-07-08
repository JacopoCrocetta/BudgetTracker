package com.project.bebudgeting.annuale.entity.entrate;

import com.project.bebudgeting.annuale.entity.EntrataAnnuale;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Altre_Entrate")
@Data
@Getter
@Setter
@NoArgsConstructor
public class AltreEntrateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idEntrata")
    private EntrataAnnuale entrata;
}
