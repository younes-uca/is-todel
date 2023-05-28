package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.OperationComptable;
import ma.sir.is.dao.criteria.core.OperationComptableCriteria;
import ma.sir.is.dao.criteria.history.OperationComptableHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.OperationComptableDto;
import org.springframework.http.HttpEntity;

public interface OperationComptableAdminService extends  IService<OperationComptable,OperationComptableCriteria, OperationComptableHistoryCriteria>  {

    List<OperationComptable> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<OperationComptable> findByCompteComptableId(Long id);
    int deleteByCompteComptableId(Long id);

    HttpEntity<byte[]> createPdf(OperationComptableDto dto) throws Exception;


}
