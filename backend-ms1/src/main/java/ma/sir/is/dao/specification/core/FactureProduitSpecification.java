package  ma.sir.is.dao.specification.core;

import ma.sir.is.zynerator.specification.AbstractSpecification;
import ma.sir.is.dao.criteria.core.FactureProduitCriteria;
import ma.sir.is.bean.core.FactureProduit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FactureProduitSpecification extends  AbstractSpecification<FactureProduitCriteria, FactureProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateFacuture", criteria.getDateFacuture(), criteria.getDateFacutureFrom(), criteria.getDateFacutureTo());
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateFk("societe","id", criteria.getSociete()==null?null:criteria.getSociete().getId());
        addPredicateFk("societe","id", criteria.getSocietes());
        addPredicateFk("societe","ice", criteria.getSociete()==null?null:criteria.getSociete().getIce());
    }

    public FactureProduitSpecification(FactureProduitCriteria criteria) {
        super(criteria);
    }

    public FactureProduitSpecification(FactureProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
