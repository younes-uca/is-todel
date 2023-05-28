package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.FactureProduitHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureProduitHistoryDao extends AbstractHistoryRepository<FactureProduitHistory,Long> {

}
