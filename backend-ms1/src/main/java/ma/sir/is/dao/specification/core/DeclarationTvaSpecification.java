package  ma.sir.is.dao.specification.core;

import ma.sir.is.zynerator.specification.AbstractSpecification;
import ma.sir.is.dao.criteria.core.DeclarationTvaCriteria;
import ma.sir.is.bean.core.DeclarationTva;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DeclarationTvaSpecification extends  AbstractSpecification<DeclarationTvaCriteria, DeclarationTva>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDeclaration", criteria.getDateDeclaration(), criteria.getDateDeclarationFrom(), criteria.getDateDeclarationTo());
        addPredicateInt("trimistre", criteria.getTrimistre(), criteria.getTrimistreMin(), criteria.getTrimistreMax());
        addPredicateInt("annee", criteria.getAnnee(), criteria.getAnneeMin(), criteria.getAnneeMax());
        addPredicateBigDecimal("totalTvaCollecte", criteria.getTotalTvaCollecte(), criteria.getTotalTvaCollecteMin(), criteria.getTotalTvaCollecteMax());
        addPredicateBigDecimal("totalTvaDue", criteria.getTotalTvaDue(), criteria.getTotalTvaDueMin(), criteria.getTotalTvaDueMax());
        addPredicateBigDecimal("differenceTva", criteria.getDifferenceTva(), criteria.getDifferenceTvaMin(), criteria.getDifferenceTvaMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateFk("societe","id", criteria.getSociete()==null?null:criteria.getSociete().getId());
        addPredicateFk("societe","id", criteria.getSocietes());
        addPredicateFk("societe","ice", criteria.getSociete()==null?null:criteria.getSociete().getIce());
        addPredicateFk("tauxRetardTva","id", criteria.getTauxRetardTva()==null?null:criteria.getTauxRetardTva().getId());
        addPredicateFk("tauxRetardTva","id", criteria.getTauxRetardTvas());
    }

    public DeclarationTvaSpecification(DeclarationTvaCriteria criteria) {
        super(criteria);
    }

    public DeclarationTvaSpecification(DeclarationTvaCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
