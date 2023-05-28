package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.CompteComptableHistoryCriteria;
import ma.sir.is.bean.history.CompteComptableHistory;


public class CompteComptableHistorySpecification extends AbstractHistorySpecification<CompteComptableHistoryCriteria, CompteComptableHistory> {

    public CompteComptableHistorySpecification(CompteComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public CompteComptableHistorySpecification(CompteComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
