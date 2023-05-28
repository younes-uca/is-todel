package ma.sir.is.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.is.zynerator.repository.AbstractRepository;
import ma.sir.is.bean.core.Bilan;
import org.springframework.stereotype.Repository;
import ma.sir.is.bean.core.Bilan;
import java.util.List;


@Repository
public interface BilanDao extends AbstractRepository<Bilan,Long>  {
    Bilan findByRef(String ref);
    int deleteByRef(String ref);

    List<Bilan> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);

    @Query("SELECT NEW Bilan(item.id,item.ref) FROM Bilan item")
    List<Bilan> findAllOptimized();
}
