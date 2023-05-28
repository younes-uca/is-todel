package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.is.bean.history.SousClassComptableHistory;


public class SousClassComptableHistorySpecification extends AbstractHistorySpecification<SousClassComptableHistoryCriteria, SousClassComptableHistory> {

    public SousClassComptableHistorySpecification(SousClassComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public SousClassComptableHistorySpecification(SousClassComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
