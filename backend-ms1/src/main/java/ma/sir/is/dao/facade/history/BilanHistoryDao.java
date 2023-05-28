package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.BilanHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BilanHistoryDao extends AbstractHistoryRepository<BilanHistory,Long> {

}
