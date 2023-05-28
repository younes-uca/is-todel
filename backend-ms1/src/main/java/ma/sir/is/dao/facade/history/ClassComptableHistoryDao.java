package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.ClassComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassComptableHistoryDao extends AbstractHistoryRepository<ClassComptableHistory,Long> {

}
