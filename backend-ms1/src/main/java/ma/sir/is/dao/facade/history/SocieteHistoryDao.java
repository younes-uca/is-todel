package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.SocieteHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteHistoryDao extends AbstractHistoryRepository<SocieteHistory,Long> {

}
