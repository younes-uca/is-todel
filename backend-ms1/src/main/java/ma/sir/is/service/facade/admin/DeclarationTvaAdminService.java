package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.DeclarationTva;
import ma.sir.is.dao.criteria.core.DeclarationTvaCriteria;
import ma.sir.is.dao.criteria.history.DeclarationTvaHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.DeclarationTvaDto;
import org.springframework.http.HttpEntity;

public interface DeclarationTvaAdminService extends  IService<DeclarationTva,DeclarationTvaCriteria, DeclarationTvaHistoryCriteria>  {

    List<DeclarationTva> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationTva> findByTauxRetardTvaId(Long id);
    int deleteByTauxRetardTvaId(Long id);

    HttpEntity<byte[]> createPdf(DeclarationTvaDto dto) throws Exception;


}
