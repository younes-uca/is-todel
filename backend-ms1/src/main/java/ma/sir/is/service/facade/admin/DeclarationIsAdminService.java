package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.DeclarationIs;
import ma.sir.is.dao.criteria.core.DeclarationIsCriteria;
import ma.sir.is.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.DeclarationIsDto;
import org.springframework.http.HttpEntity;

public interface DeclarationIsAdminService extends  IService<DeclarationIs,DeclarationIsCriteria, DeclarationIsHistoryCriteria>  {

    List<DeclarationIs> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationIs> findByTauxIsId(Long id);
    int deleteByTauxIsId(Long id);

    HttpEntity<byte[]> createPdf(DeclarationIsDto dto) throws Exception;


}
