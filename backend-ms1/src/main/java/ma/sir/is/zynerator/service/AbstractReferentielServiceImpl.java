package ma.sir.is.zynerator.service;

import ma.sir.is.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sir.is.zynerator.criteria.BaseCriteria;
import ma.sir.is.zynerator.history.HistBusinessObject;
import ma.sir.is.zynerator.history.HistCriteria;
import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}