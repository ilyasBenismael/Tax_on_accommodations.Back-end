package service;

import bean.Local;
import dao.LocalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {
    @Autowired
    private LocalDao localDao;

    public Local findByRef(String ref) {
        return localDao.findByRef(ref);
    }

    public List<Local> findByRueCode(String code) {
        return localDao.findByRueCode(code);
    }

    public List<Local> findByCategorieLocalCode(String code) {
        return localDao.findByCategorieLocalCode(code);
    }

    public List<Local> findByRueQuartierCode(String code) {
        return localDao.findByRueQuartierCode(code);
    }

    public List<Local> findByRueQuartierSecteurCode(String code) {
        return localDao.findByRueQuartierSecteurCode(code);
    }

    public List<Local> findByDerTripayeeAndDerAnnpayeeBetween(int trimMin, int trimMax, int anneeMin, int anneeMax) {
        return localDao.findByDerTripayeeAndDerAnnpayeeBetween(trimMin, trimMax, anneeMin, anneeMax);
    }

    public List<Local> findByDerTripayee(int dernierTrimPaye) {
        return localDao.findByDerTripayee(dernierTrimPaye);
    }

    public int deleteByRef(String ref) {
        return localDao.deleteByRef(ref);
    }
//gg
    public int save(Local local) {
        if(findByRef(local.getRef())!=null){
            return -1;
        }else{
            localDao.save(local);
            return 1;
        }

    }
}
