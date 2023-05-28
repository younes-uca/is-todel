package ma.sir.is.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.is.zynerator.repository.AbstractRepository;
import ma.sir.is.bean.core.Societe;
import org.springframework.stereotype.Repository;
import ma.sir.is.bean.core.Societe;
import java.util.List;


@Repository
public interface SocieteDao extends AbstractRepository<Societe,Long>  {
    Societe findByIce(String ice);
    int deleteByIce(String ice);


    @Query("SELECT NEW Societe(item.id,item.ice) FROM Societe item")
    List<Societe> findAllOptimized();
}
