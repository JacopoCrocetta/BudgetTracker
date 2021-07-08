package com.project.bebudgeting.utility;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.EntrateEffettiveEntity;
import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.EntratePrevisteEntity;
import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.effettive.*;
import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.previste.*;
import com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.effettive.*;
import com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.previste.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
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

    //Utility Method
    public boolean hasOneElement(EntratePrevisteEntity totalEntity) {
        return (totalEntity.getAltreCategorieEntities().size() != 1) ||
                (totalEntity.getBonusEntities().size() != 1) ||
                (totalEntity.getBustaPagaEntities().size() != 1) ||
                (totalEntity.getInteressiEntities().size() != 1) ||
                (totalEntity.getRisparmiEntities().size() != 1);
    }

    public boolean hasMoreElement(EntratePrevisteEntity totalEntity) {
        return (totalEntity.getAltreCategorieEntities().size() > 1) ||
                (totalEntity.getBonusEntities().size() > 1) ||
                (totalEntity.getBustaPagaEntities().size() > 1) ||
                (totalEntity.getInteressiEntities().size() > 1) ||
                (totalEntity.getRisparmiEntities().size() > 1);
    }

    public boolean hasOneElement(EntrateEffettiveEntity totalEntity) {
        return (totalEntity.getAltreCategorieEntities().size() != 1) ||
                (totalEntity.getBonusEntities().size() != 1) ||
                (totalEntity.getBustaPagaEntities().size() != 1) ||
                (totalEntity.getInteressiEntities().size() != 1) ||
                (totalEntity.getRisparmiEntities().size() != 1);
    }

    public boolean hasMoreElement(EntrateEffettiveEntity totalEntity) {
        return (totalEntity.getAltreCategorieEntities().size() > 1) ||
                (totalEntity.getBonusEntities().size() > 1) ||
                (totalEntity.getBustaPagaEntities().size() > 1) ||
                (totalEntity.getInteressiEntities().size() > 1) ||
                (totalEntity.getRisparmiEntities().size() > 1);
    }

    public boolean exists(EntrateEffettiveEntity totalEntity, AltreCategorieEffettiveRepository categorieRepository, BonusEffettiviRepository bonusEffettiviRepository, BustaPagaEffettiviRepository bustaPagaEffettiviRepository, InteressiEffettiviRepository interessiEffettiviRepository, RisparmiEffettiviRepository risparmiEffettiviRepository) {
        return false;
    }

    public boolean exists(EntratePrevisteEntity totalEntity, AltreCategoriePrevisteRepository categorieRepository, BonusPrevistiRepository bonusPrevistiRepository, BustaPagaPrevistiRepository bustaPagaRepository, InteressiPrevistiRepository interessiRepository, RisparmiPrevistiRepository risparmiRepository) {
        return (
                categorieRepository.existsById(totalEntity.getAltreCategorieEntities().get(0).getId()) &&
                        bustaPagaRepository.existsById(totalEntity.getBustaPagaEntities().get(0).getId()) &&
                        interessiRepository.existsById(totalEntity.getInteressiEntities().get(0).getId()) &&
                        risparmiRepository.existsById(totalEntity.getRisparmiEntities().get(0).getId()) &&
                        bonusPrevistiRepository.existsById(totalEntity.getBonusEntities().get(0).getId())
        );
    }

    public EntratePrevisteEntity deleteOneElement(EntratePrevisteEntity totalEntity, AltreCategoriePrevisteRepository categorieRepository, BonusPrevistiRepository bonusPrevistiRepository, BustaPagaPrevistiRepository bustaPagaRepository, InteressiPrevistiRepository interessiRepository, RisparmiPrevistiRepository risparmiRepository) {
        categorieRepository.delete(totalEntity.getAltreCategorieEntities().get(0));
        bonusPrevistiRepository.delete(totalEntity.getBonusEntities().get(0));
        bustaPagaRepository.delete(totalEntity.getBustaPagaEntities().get(0));
        interessiRepository.delete(totalEntity.getInteressiEntities().get(0));
        risparmiRepository.delete(totalEntity.getRisparmiEntities().get(0));
        return totalEntity;
    }

    public EntrateEffettiveEntity deleteOneElement(EntrateEffettiveEntity totalEntity, AltreCategorieEffettiveRepository categorieRepository, BonusEffettiviRepository bonusEffettiviRepository, BustaPagaEffettiviRepository bustaPagaEffettiviRepository, InteressiEffettiviRepository interessiEffettiviRepository, RisparmiEffettiviRepository risparmiEffettiviRepository) {
        categorieRepository.delete(totalEntity.getAltreCategorieEntities().get(0));
        bonusEffettiviRepository.delete(totalEntity.getBonusEntities().get(0));
        bustaPagaEffettiviRepository.delete(totalEntity.getBustaPagaEntities().get(0));
        interessiEffettiviRepository.delete(totalEntity.getInteressiEntities().get(0));
        risparmiEffettiviRepository.delete(totalEntity.getRisparmiEntities().get(0));
        return totalEntity;
    }

    public EntrateEffettiveEntity
    retreiveOneElementByID(int id, EntrateEffettiveEntity elementToPopulate, AltreCategorieEffettiveRepository categorieRepository, BonusEffettiviRepository bonusEffettiviRepository, BustaPagaEffettiviRepository bustaPagaEffettiviRepository, InteressiEffettiviRepository interessiEffettiviRepository, RisparmiEffettiviRepository risparmiEffettiviRepository) {
        List<AltreCategorieEntrateEffettiviEntity> altreCategorieEntities = new LinkedList<>();
        List<BonusEffettiveEntity> bonusEntities = new LinkedList<>();
        List<BustaPagaEffettiveEntity> bustaPagaEntities = new LinkedList<>();
        List<InteressiEffettiviEntity> interessiEntities = new LinkedList<>();
        List<RisparmiEffettiveEntity> risparmiEntities = new LinkedList<>();

        altreCategorieEntities.add(categorieRepository.findById(id).get());
        bonusEntities.add(bonusEffettiviRepository.findById(id).get());
        bustaPagaEntities.add(bustaPagaEffettiviRepository.findById(id).get());
        interessiEntities.add(interessiEffettiviRepository.findById(id).get());
        risparmiEntities.add(risparmiEffettiviRepository.findById(id).get());

        elementToPopulate.setAltreCategorieEntities(altreCategorieEntities);
        elementToPopulate.setBonusEntities(bonusEntities);
        elementToPopulate.setBustaPagaEntities(bustaPagaEntities);
        elementToPopulate.setInteressiEntities(interessiEntities);
        elementToPopulate.setRisparmiEntities(risparmiEntities);
        return elementToPopulate;
    }
}
