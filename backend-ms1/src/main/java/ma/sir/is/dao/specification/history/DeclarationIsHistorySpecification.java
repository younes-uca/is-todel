package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.is.bean.history.DeclarationIsHistory;


public class DeclarationIsHistorySpecification extends AbstractHistorySpecification<DeclarationIsHistoryCriteria, DeclarationIsHistory> {

    public DeclarationIsHistorySpecification(DeclarationIsHistoryCriteria criteria) {
        super(criteria);
    }

    public DeclarationIsHistorySpecification(DeclarationIsHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
