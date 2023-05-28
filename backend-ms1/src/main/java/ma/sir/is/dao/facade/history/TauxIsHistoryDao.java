package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.TauxIsHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxIsHistoryDao extends AbstractHistoryRepository<TauxIsHistory,Long> {

}
