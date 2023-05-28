package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.Societe;
import ma.sir.is.dao.criteria.core.SocieteCriteria;
import ma.sir.is.dao.criteria.history.SocieteHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.SocieteDto;
import org.springframework.http.HttpEntity;

public interface SocieteAdminService extends  IService<Societe,SocieteCriteria, SocieteHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(SocieteDto dto) throws Exception;


}
