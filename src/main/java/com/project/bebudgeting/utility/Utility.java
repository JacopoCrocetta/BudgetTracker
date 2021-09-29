package com.project.bebudgeting.utility;

import java.util.ArrayList;
import java.util.List;

import com.project.bebudgeting.annuale.entity.entrate.AltreEntrateEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.DividendiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.InteressiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.RegaliAltreEntrateEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.RimborsiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.TrasferimentoRisparmiEntity;

public class Utility {
    public List<AltreEntrateEntity> filterEntrateConAltreEntrate(List<AltreEntrateEntity> unfilteredList,
            Iterable<AltroAltreEntrateEntity> altreEntrate) {
        return unfilteredList;
    }

    public List<AltreEntrateEntity> filterEntrateConDividendi(List<AltreEntrateEntity> unfilteredList,
            Iterable<DividendiEntity> dividendi) {
        List<AltreEntrateEntity> ret = new ArrayList<AltreEntrateEntity>();
        return ret;
    }

    public List<AltreEntrateEntity> filterEntrateConInteressi(List<AltreEntrateEntity> unfilteredList,
            Iterable<InteressiEntity> interessi) {
        List<AltreEntrateEntity> ret = new ArrayList<AltreEntrateEntity>();
        return ret;
    }

    public List<AltreEntrateEntity> filterEntrateConRegali(List<AltreEntrateEntity> unfilteredList,
            Iterable<RegaliAltreEntrateEntity> regaliALtreEntrate) {
        List<AltreEntrateEntity> ret = new ArrayList<AltreEntrateEntity>();
        return ret;
    }

    public List<AltreEntrateEntity> filterEntrateConRimborsi(List<AltreEntrateEntity> unfilteredList,
            Iterable<RimborsiEntity> rimborsi) {
        List<AltreEntrateEntity> ret = new ArrayList<AltreEntrateEntity>();
        return ret;
    }

    public List<AltreEntrateEntity> filterEntrateConTrasferimentiRisparmi(List<AltreEntrateEntity> unfilteredList,
            Iterable<TrasferimentoRisparmiEntity> trasferimentiRisparmi) {
        List<AltreEntrateEntity> ret = new ArrayList<AltreEntrateEntity>();
        return ret;
    }
}
