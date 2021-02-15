package com.project.bebudgeting.utility;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.EntrateEffettiveEntity;
import com.project.bebudgeting.entities.personalbudgetingentity.entrate.EntratePrevisteEntity;
import com.project.bebudgeting.entities.personalbudgetingentity.entrate.effettive.*;
import com.project.bebudgeting.entities.personalbudgetingentity.entrate.previste.*;
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

    //Filtri per categorie effettive
    public List<AltreCategorieEntrateEffettiviEntity> getFilteredCategorieEffettiveByDate(LocalDate startDate, LocalDate endDate, List<AltreCategorieEntrateEffettiviEntity> categorieList) {
        CollectionUtils.filter(categorieList, altreCategorie -> ((AltreCategorieEntrateEffettiviEntity) altreCategorie).getData().isAfter(startDate));
        CollectionUtils.filter(categorieList, altreCategorie -> ((AltreCategorieEntrateEffettiviEntity) altreCategorie).getData().isBefore(endDate));
        return categorieList;
    }

    public List<BonusEffettiveEntity> getFilteredBonusEffettiveByDate(LocalDate startDate, LocalDate endDate, List<BonusEffettiveEntity> bonusList) {
        CollectionUtils.filter(bonusList, bonus -> ((BonusEffettiveEntity) bonus).getData().isAfter(startDate));
        CollectionUtils.filter(bonusList, bonus -> ((BonusEffettiveEntity) bonus).getData().isBefore(endDate));
        return bonusList;
    }

    public List<BustaPagaEffettiveEntity> getFilteredBustaPagaEffettiveByDate(LocalDate startDate, LocalDate endDate, List<BustaPagaEffettiveEntity> bustaPagaList) {
        CollectionUtils.filter(bustaPagaList, bustaPaga -> ((BustaPagaEffettiveEntity) bustaPaga).getData().isAfter(startDate));
        CollectionUtils.filter(bustaPagaList, bustaPaga -> ((BustaPagaEffettiveEntity) bustaPaga).getData().isBefore(endDate));
        return bustaPagaList;
    }

    public List<InteressiEffettiviEntity> getFilteredInteressiEffettiveByDate(LocalDate startDate, LocalDate endDate, List<InteressiEffettiviEntity> interessiList) {
        CollectionUtils.filter(interessiList, altreCategorie -> ((InteressiEffettiviEntity) altreCategorie).getData().isAfter(startDate));
        CollectionUtils.filter(interessiList, altreCategorie -> ((InteressiEffettiviEntity) altreCategorie).getData().isBefore(endDate));
        return interessiList;
    }

    public List<RisparmiEffettiveEntity> getFilteredRisparmiEffettiveByDate(LocalDate startDate, LocalDate endDate, List<RisparmiEffettiveEntity> risparmiList) {
        CollectionUtils.filter(risparmiList, altreCategorie -> ((RisparmiEffettiveEntity) altreCategorie).getData().isAfter(startDate));
        CollectionUtils.filter(risparmiList, altreCategorie -> ((RisparmiEffettiveEntity) altreCategorie).getData().isBefore(endDate));
        return risparmiList;
    }


    //Filtri per categorie previste
    public List<AltreCategorieEntratePrevisteEntity> getFilteredCategoriePrevisteByDate(LocalDate startDate, LocalDate endDate, List<AltreCategorieEntratePrevisteEntity> categorieList) {
        CollectionUtils.filter(categorieList, altreCategorie -> ((AltreCategorieEntrateEffettiviEntity) altreCategorie).getData().isAfter(startDate));
        CollectionUtils.filter(categorieList, altreCategorie -> ((AltreCategorieEntrateEffettiviEntity) altreCategorie).getData().isBefore(endDate));
        return categorieList;
    }

    public List<BonusPrevistiEntity> getFilteredBonusPrevistiByDate(LocalDate startDate, LocalDate endDate, List<BonusPrevistiEntity> bonusList) {
        CollectionUtils.filter(bonusList, bonus -> ((BonusPrevistiEntity) bonus).getData().isAfter(startDate));
        CollectionUtils.filter(bonusList, bonus -> ((BonusPrevistiEntity) bonus).getData().isBefore(endDate));
        return bonusList;
    }

    public List<BustaPagaPrevisteEntity> getFilteredBustaPagaPrevisteByDate(LocalDate startDate, LocalDate endDate, List<BustaPagaPrevisteEntity> bustaPagaList) {
        CollectionUtils.filter(bustaPagaList, bustaPaga -> ((BustaPagaEffettiveEntity) bustaPaga).getData().isAfter(startDate));
        CollectionUtils.filter(bustaPagaList, bustaPaga -> ((BustaPagaEffettiveEntity) bustaPaga).getData().isBefore(endDate));
        return bustaPagaList;
    }

    public List<InteressiPrevistiEntity> getFilteredInteressiPrevistiByDate(LocalDate startDate, LocalDate endDate, List<InteressiPrevistiEntity> interessiList) {
        CollectionUtils.filter(interessiList, altreCategorie -> ((InteressiEffettiviEntity) altreCategorie).getData().isAfter(startDate));
        CollectionUtils.filter(interessiList, altreCategorie -> ((InteressiEffettiviEntity) altreCategorie).getData().isBefore(endDate));
        return interessiList;
    }

    public List<RisparmiPrevistiEntity> getFilteredRisparmiPrevistiByDate(LocalDate startDate, LocalDate endDate, List<RisparmiPrevistiEntity> risparmiList) {
        CollectionUtils.filter(risparmiList, altreCategorie -> ((RisparmiEffettiveEntity) altreCategorie).getData().isAfter(startDate));
        CollectionUtils.filter(risparmiList, altreCategorie -> ((RisparmiEffettiveEntity) altreCategorie).getData().isBefore(endDate));
        return risparmiList;
    }


    //Somme per entrate effettive
    public BigDecimal getFilteredActualRevenueSum(EntrateEffettiveEntity filteredEntries) {
        BigDecimal ret = new BigDecimal(0);
        filteredEntries.getAltreCategorieEntities().forEach(categoryEntity -> ret.add(categoryEntity.getImporto()));
        filteredEntries.getBonusEntities().forEach(bonusEntity -> ret.add(bonusEntity.getImporto()));
        filteredEntries.getBustaPagaEntities().forEach(bustaPagaEffettiveEntity -> ret.add(bustaPagaEffettiveEntity.getImporto()));
        filteredEntries.getInteressiEntities().forEach(interessiEffettiviEntity -> ret.add(interessiEffettiviEntity.getImporto()));
        filteredEntries.getRisparmiEntities().forEach(risparmiEffettiveEntity -> ret.add(risparmiEffettiveEntity.getImporto()));
        return ret;
    }

    public BigDecimal getTotalForActualRevenueSum(EntrateEffettiveEntity totalEntity) {
        BigDecimal ret = new BigDecimal(0);
        totalEntity.getAltreCategorieEntities().forEach(categoryEntity -> ret.add(categoryEntity.getImporto()));
        totalEntity.getBonusEntities().forEach(bonusEntity -> ret.add(bonusEntity.getImporto()));
        totalEntity.getBustaPagaEntities().forEach(bustaPagaEffettiveEntity -> ret.add(bustaPagaEffettiveEntity.getImporto()));
        totalEntity.getInteressiEntities().forEach(interessiEffettiviEntity -> ret.add(interessiEffettiviEntity.getImporto()));
        totalEntity.getRisparmiEntities().forEach(risparmiEffettiveEntity -> ret.add(risparmiEffettiveEntity.getImporto()));
        return ret;
    }

    //Somme per entrate previste
    public BigDecimal getFilteredEstimatedRevenue(EntratePrevisteEntity filteredEntries) {
        BigDecimal ret = new BigDecimal(0);
        filteredEntries.getAltreCategorieEntities().forEach(categoryEntity -> ret.add(categoryEntity.getImporto()));
        filteredEntries.getBonusEntities().forEach(bonusEntity -> ret.add(bonusEntity.getImporto()));
        filteredEntries.getBustaPagaEntities().forEach(bustaPagaEffettiveEntity -> ret.add(bustaPagaEffettiveEntity.getImporto()));
        filteredEntries.getInteressiEntities().forEach(interessiEffettiviEntity -> ret.add(interessiEffettiviEntity.getImporto()));
        filteredEntries.getRisparmiEntities().forEach(risparmiEffettiveEntity -> ret.add(risparmiEffettiveEntity.getImporto()));
        return ret;
    }

    public BigDecimal getTotalEstimatedRevenueSum(EntratePrevisteEntity totalEntity) {
        BigDecimal ret = new BigDecimal(0);
        totalEntity.getAltreCategorieEntities().forEach(categoryEntity -> ret.add(categoryEntity.getImporto()));
        totalEntity.getBonusEntities().forEach(bonusEntity -> ret.add(bonusEntity.getImporto()));
        totalEntity.getBustaPagaEntities().forEach(bustaPagaEffettiveEntity -> ret.add(bustaPagaEffettiveEntity.getImporto()));
        totalEntity.getInteressiEntities().forEach(interessiEffettiviEntity -> ret.add(interessiEffettiviEntity.getImporto()));
        totalEntity.getRisparmiEntities().forEach(risparmiEffettiveEntity -> ret.add(risparmiEffettiveEntity.getImporto()));
        return ret;
    }
}
