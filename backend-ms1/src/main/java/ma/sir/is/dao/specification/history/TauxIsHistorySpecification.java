package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.TauxIsHistoryCriteria;
import ma.sir.is.bean.history.TauxIsHistory;


public class TauxIsHistorySpecification extends AbstractHistorySpecification<TauxIsHistoryCriteria, TauxIsHistory> {

    public TauxIsHistorySpecification(TauxIsHistoryCriteria criteria) {
        super(criteria);
    }

    public TauxIsHistorySpecification(TauxIsHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
