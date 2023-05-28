package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.FactureProduitHistoryCriteria;
import ma.sir.is.bean.history.FactureProduitHistory;


public class FactureProduitHistorySpecification extends AbstractHistorySpecification<FactureProduitHistoryCriteria, FactureProduitHistory> {

    public FactureProduitHistorySpecification(FactureProduitHistoryCriteria criteria) {
        super(criteria);
    }

    public FactureProduitHistorySpecification(FactureProduitHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
