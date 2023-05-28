package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.OperationComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationComptableHistoryDao extends AbstractHistoryRepository<OperationComptableHistory,Long> {

}
