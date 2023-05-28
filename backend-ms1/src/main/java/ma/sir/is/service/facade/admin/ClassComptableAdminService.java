package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.ClassComptable;
import ma.sir.is.dao.criteria.core.ClassComptableCriteria;
import ma.sir.is.dao.criteria.history.ClassComptableHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.ClassComptableDto;
import org.springframework.http.HttpEntity;

public interface ClassComptableAdminService extends  IService<ClassComptable,ClassComptableCriteria, ClassComptableHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ClassComptableDto dto) throws Exception;


}
