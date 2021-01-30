package com.project.BEbudgeting.utility;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Utility {

    public BigDecimal getActualCost(){
        return new BigDecimal(123);
    }

    public Iterable<EntratePersonalBudgetEntity> resultFiltered(Iterable<EntratePersonalBudgetEntity> listToFilter){
        Iterable<EntratePersonalBudgetEntity> filteredList = listToFilter;

        //TODO IMPLEMENTARE I FILTRI

        return filteredList;
    }

}
