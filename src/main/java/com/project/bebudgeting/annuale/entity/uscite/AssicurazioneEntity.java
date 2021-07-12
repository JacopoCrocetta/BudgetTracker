package com.project.bebudgeting.annuale.entity.uscite;

import com.project.bebudgeting.annuale.entity.UscitaAnnuale;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "Assicurazioni")
@NoArgsConstructor
public class AssicurazioneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UscitaAnnuale uscitaAnnuale;
}