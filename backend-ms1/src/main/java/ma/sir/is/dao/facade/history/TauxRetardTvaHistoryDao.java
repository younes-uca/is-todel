package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.TauxRetardTvaHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxRetardTvaHistoryDao extends AbstractHistoryRepository<TauxRetardTvaHistory,Long> {

}
