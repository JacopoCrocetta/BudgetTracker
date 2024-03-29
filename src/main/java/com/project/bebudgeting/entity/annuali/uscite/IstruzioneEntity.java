package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.AltroIstruzioneEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LezioniIndipendentiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LibriIstruzioneEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.RetteEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IstruzioneEntity {
    private List<LezioniIndipendentiEntity> lezioniIndipendentiEntities;
    private List<AltroIstruzioneEntity> altroEntities;
    private List<LibriIstruzioneEntity> libriEntities;
    private List<RetteEntity> retteEntities;
}