package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.FactureChargeHistoryCriteria;
import ma.sir.is.bean.history.FactureChargeHistory;


public class FactureChargeHistorySpecification extends AbstractHistorySpecification<FactureChargeHistoryCriteria, FactureChargeHistory> {

    public FactureChargeHistorySpecification(FactureChargeHistoryCriteria criteria) {
        super(criteria);
    }

    public FactureChargeHistorySpecification(FactureChargeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
