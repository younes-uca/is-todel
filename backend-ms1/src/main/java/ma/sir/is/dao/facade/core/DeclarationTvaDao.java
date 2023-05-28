package ma.sir.is.dao.facade.core;

import ma.sir.is.zynerator.repository.AbstractRepository;
import ma.sir.is.bean.core.DeclarationTva;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DeclarationTvaDao extends AbstractRepository<DeclarationTva,Long>  {

    List<DeclarationTva> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationTva> findByTauxRetardTvaId(Long id);
    int deleteByTauxRetardTvaId(Long id);

}
