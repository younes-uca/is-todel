package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.FactureChargeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureChargeHistoryDao extends AbstractHistoryRepository<FactureChargeHistory,Long> {

}
