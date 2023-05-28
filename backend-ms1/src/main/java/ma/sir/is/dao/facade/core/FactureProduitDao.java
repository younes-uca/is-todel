package ma.sir.is.dao.facade.core;

import ma.sir.is.zynerator.repository.AbstractRepository;
import ma.sir.is.bean.core.FactureProduit;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FactureProduitDao extends AbstractRepository<FactureProduit,Long>  {

    List<FactureProduit> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);

}
