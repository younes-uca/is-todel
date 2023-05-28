package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.BilanHistoryCriteria;
import ma.sir.is.bean.history.BilanHistory;


public class BilanHistorySpecification extends AbstractHistorySpecification<BilanHistoryCriteria, BilanHistory> {

    public BilanHistorySpecification(BilanHistoryCriteria criteria) {
        super(criteria);
    }

    public BilanHistorySpecification(BilanHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
