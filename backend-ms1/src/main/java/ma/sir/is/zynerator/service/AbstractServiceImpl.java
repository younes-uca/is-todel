package ma.sir.is.zynerator.service;

import ma.sir.is.zynerator.audit.AuditBusinessObject;
import ma.sir.is.zynerator.criteria.BaseCriteria;
import ma.sir.is.zynerator.dto.AuditEntityDto;
import ma.sir.is.zynerator.exception.EntityNotFoundException;
import ma.sir.is.zynerator.history.HistBusinessObject;
import ma.sir.is.zynerator.history.HistCriteria;
import ma.sir.is.zynerator.repository.AbstractHistoryRepository;
import ma.sir.is.zynerator.repository.AbstractRepository;
import ma.sir.is.zynerator.security.bean.User;
import ma.sir.is.zynerator.security.service.facade.UserService;
import ma.sir.is.zynerator.specification.AbstractHistorySpecification;
import ma.sir.is.zynerator.specification.AbstractSpecification;
import ma.sir.is.zynerator.util.ListUtil;
import ma.sir.is.zynerator.util.RefelexivityUtil;
import ma.sir.is.zynerator.util.StringUtil;
import ma.sir.is.zynerator.util.Utils;

import ma.sir.is.zynerator.util.FileUtils;
import ma.sir.is.zynerator.util.MD5Checksum;
import ma.sir.is