package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.DeclarationTvaHistoryCriteria;
import ma.sir.is.bean.history.DeclarationTvaHistory;


public class DeclarationTvaHistorySpecification extends AbstractHistorySpecification<DeclarationTvaHistoryCriteria, DeclarationTvaHistory> {

    public DeclarationTvaHistorySpecification(DeclarationTvaHistoryCriteria criteria) {
        super(criteria);
    }

    public DeclarationTvaHistorySpecification(DeclarationTvaHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
