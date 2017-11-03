package home.pam.geodata.Service;

import home.pam.geodata.DAO.PaisesDb;
import home.pam.geodata.Model.Pais;

/**
 * Created by pfidelis on 03/11/17.
 */

public class PaisService {

    PaisesDb dao;

    public PaisService(PaisesDb dao) {
        this.dao = dao;
    }

    public void inserirPaises(Pais[] paises){
        dao.inserirPaises(paises);
    }

    public Pais[] selecionarPaises() {
       return dao.selecionarPaises();
    }
}
