package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.OperationComptableHistoryCriteria;
import ma.sir.is.bean.history.OperationComptableHistory;


public class OperationComptableHistorySpecification extends AbstractHistorySpecification<OperationComptableHistoryCriteria, OperationComptableHistory> {

    public OperationComptableHistorySpecification(OperationComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public OperationComptableHistorySpecification(OperationComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
