package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.Bilan;
import ma.sir.is.dao.criteria.core.BilanCriteria;
import ma.sir.is.dao.criteria.history.BilanHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.BilanDto;
import org.springframework.http.HttpEntity;

public interface BilanAdminService extends  IService<Bilan,BilanCriteria, BilanHistoryCriteria>  {

    List<Bilan> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);

    HttpEntity<byte[]> createPdf(BilanDto dto) throws Exception;


}
