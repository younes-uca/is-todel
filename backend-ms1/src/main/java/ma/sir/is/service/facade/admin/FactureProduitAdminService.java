package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.FactureProduit;
import ma.sir.is.dao.criteria.core.FactureProduitCriteria;
import ma.sir.is.dao.criteria.history.FactureProduitHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.FactureProduitDto;
import org.springframework.http.HttpEntity;

public interface FactureProduitAdminService extends  IService<FactureProduit,FactureProduitCriteria, FactureProduitHistoryCriteria>  {

    List<FactureProduit> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);

    HttpEntity<byte[]> createPdf(FactureProduitDto dto) throws Exception;


}
