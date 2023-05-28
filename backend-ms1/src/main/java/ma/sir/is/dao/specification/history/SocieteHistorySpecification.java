package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.SocieteHistoryCriteria;
import ma.sir.is.bean.history.SocieteHistory;


public class SocieteHistorySpecification extends AbstractHistorySpecification<SocieteHistoryCriteria, SocieteHistory> {

    public SocieteHistorySpecification(SocieteHistoryCriteria criteria) {
        super(criteria);
    }

    public SocieteHistorySpecification(SocieteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
