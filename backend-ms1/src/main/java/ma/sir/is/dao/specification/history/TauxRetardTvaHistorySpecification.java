package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.is.bean.history.TauxRetardTvaHistory;


public class TauxRetardTvaHistorySpecification extends AbstractHistorySpecification<TauxRetardTvaHistoryCriteria, TauxRetardTvaHistory> {

    public TauxRetardTvaHistorySpecification(TauxRetardTvaHistoryCriteria criteria) {
        super(criteria);
    }

    public TauxRetardTvaHistorySpecification(TauxRetardTvaHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
