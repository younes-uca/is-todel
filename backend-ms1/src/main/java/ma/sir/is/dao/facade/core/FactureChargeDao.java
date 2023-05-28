package ma.sir.is.dao.facade.core;

import ma.sir.is.zynerator.repository.AbstractRepository;
import ma.sir.is.bean.core.FactureCharge;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FactureChargeDao extends AbstractRepository<FactureCharge,Long>  {

    List<FactureCharge> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<FactureCharge> findByDeclarationIsId(Long id);
    int deleteByDeclarationIsId(Long id);

}
