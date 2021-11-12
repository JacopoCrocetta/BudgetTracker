package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.AltroTecnologiaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HardwareEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HostingEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.ServiziOnlineEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.SoftwareEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TecnologiaEntity {
    private List<HardwareEntity> hardwareEntities;
    private List<AltroTecnologiaEntity> altroEntities;
    private List<HostingEntity> hostingEntities;
    private List<ServiziOnlineEntity> serviziOnlineEntities;
    private List<SoftwareEntity> softwareEntities;
}