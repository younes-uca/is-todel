package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.DeclarationIsHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationIsHistoryDao extends AbstractHistoryRepository<DeclarationIsHistory,Long> {

}
