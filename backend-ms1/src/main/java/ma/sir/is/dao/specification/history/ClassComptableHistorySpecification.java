package  ma.sir.is.dao.specification.history;

import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.dao.criteria.history.ClassComptableHistoryCriteria;
import ma.sir.is.bean.history.ClassComptableHistory;


public class ClassComptableHistorySpecification extends AbstractHistorySpecification<ClassComptableHistoryCriteria, ClassComptableHistory> {

    public ClassComptableHistorySpecification(ClassComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public ClassComptableHistorySpecification(ClassComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
