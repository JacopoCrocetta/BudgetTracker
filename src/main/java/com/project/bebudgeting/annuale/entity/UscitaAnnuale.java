package com.project.bebudgeting.annuale.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "UscitaAnnuale")
@Data
@NoArgsConstructor
@Getter
@Setter
public class UscitaAnnuale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
