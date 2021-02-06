package com.project.bebudgeting.utility;

import com.project.bebudgeting.entities.personalbudgetingentity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UtilityEntrate {

    //Filtri per categorie
    public List<AltreCategorieEffettiveEntity> getFilteredCategorieByDate(LocalDate startDate, LocalDate endDate, List<AltreCategorieEffettiveEntity> categorieList){
        CollectionUtils.filter(categorieList, altreCategorie -> ((AltreCategorieEffettiveEntity) altreCategorie).getData().isAfter(startDate));
        CollectionUtils.filter(categorieList, altreCategorie -> ((AltreCategorieEffettiveEntity) altreCategorie).getData().isBefore(endDate));
        return categorieList;
    }

    public List<BonusEffettiveEntity> getFilteredBonusByDate(LocalDate startDate, LocalDate endDate, List<BonusEffettiveEntity> bonusList){
        CollectionUtils.filter(bonusList, bonus -> ((BonusEffettiveEntity) bonus).getData().isAfter(startDate));
        CollectionUtils.filter(bonusList, bonus -> ((BonusEffettiveEntity) bonus).getData().isBefore(endDate));
        return bonusList;
    }

    public List<BustaPagaEffettiveEntity> getFilteredBustaPagaByDate(LocalDate startDate, LocalDate endDate, List<BustaPagaEffettiveEntity> bustaPagaList){
        CollectionUtils.filter(bustaPagaList, bustaPaga -> ((BustaPagaEffettiveEntity) bustaPaga).getData().isAfter(startDate));
        CollectionUtils.filter(bustaPagaList, bustaPaga -> ((BustaPagaEffettiveEntity) bustaPaga).getData().isBefore(endDate));
        return bustaPagaList;
    }

    public List<InteressiEffettivoEntity> getFilteredInteressiByDate(LocalDate startDate, LocalDate endDate, List<InteressiEffettivoEntity> interessiList){
        CollectionUtils.filter(interessiList, altreCategorie -> ((InteressiEffettivoEntity) altreCategorie).getData().isAfter(startDate));
        CollectionUtils.filter(interessiList, altreCategorie -> ((InteressiEffettivoEntity) altreCategorie).getData().isBefore(endDate));
        return interessiList;
    }

    public List<RisparmiEffettiveEntity> getFilteredRisparmiByDate(LocalDate startDate, LocalDate endDate, List<RisparmiEffettiveEntity> risparmiList){
        CollectionUtils.filter(risparmiList, altreCategorie -> ((RisparmiEffettiveEntity) altreCategorie).getData().isAfter(startDate));
        CollectionUtils.filter(risparmiList, altreCategorie -> ((RisparmiEffettiveEntity) altreCategorie).getData().isBefore(endDate));
        return risparmiList;
    }

    //Somme
    public BigDecimal getFilteredSum(EntrateEffettiveEntity filteredEntries){
        BigDecimal ret = new BigDecimal(0);
        filteredEntries.getAltreCategorieEntities().forEach(categoryEntity -> ret.add(categoryEntity.getImporto()));
        filteredEntries.getBonusEntities().forEach(bonusEntity -> ret.add(bonusEntity.getImporto()));
        filteredEntries.getBustaPagaEntities().forEach(bustaPagaEffettiveEntity -> ret.add(bustaPagaEffettiveEntity.getImporto()));
        filteredEntries.getInteressiEntities().forEach(interessiEffettivoEntity -> ret.add(interessiEffettivoEntity.getImporto()));
        filteredEntries.getRisparmiEntities().forEach(risparmiEffettiveEntity -> ret.add(risparmiEffettiveEntity.getImporto()));
        return ret;
    }

    public BigDecimal getTotalSUm(EntrateEffettiveEntity totalEntity){
        BigDecimal ret = new BigDecimal(0);
        totalEntity.getAltreCategorieEntities().forEach(categoryEntity -> ret.add(categoryEntity.getImporto()));
        totalEntity.getBonusEntities().forEach(bonusEntity -> ret.add(bonusEntity.getImporto()));
        totalEntity.getBustaPagaEntities().forEach(bustaPagaEffettiveEntity -> ret.add(bustaPagaEffettiveEntity.getImporto()));
        totalEntity.getInteressiEntities().forEach(interessiEffettivoEntity -> ret.add(interessiEffettivoEntity.getImporto()));
        totalEntity.getRisparmiEntities().forEach(risparmiEffettiveEntity -> ret.add(risparmiEffettiveEntity.getImporto()));
        return ret;
    }
}
