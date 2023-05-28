package ma.sir.is.dao.facade.history;

import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.bean.history.DeclarationTvaHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationTvaHistoryDao extends AbstractHistoryRepository<DeclarationTvaHistory,Long> {

}
