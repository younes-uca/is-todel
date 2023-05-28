package ma.sir.is.dao.facade.core;

import ma.sir.is.zynerator.repository.AbstractRepository;
import ma.sir.is.bean.core.DeclarationIs;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DeclarationIsDao extends AbstractRepository<DeclarationIs,Long>  {

    List<DeclarationIs> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationIs> findByTauxIsId(Long id);
    int deleteByTauxIsId(Long id);

}
