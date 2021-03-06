package main.java.com.hotel.modeldao;

import main.java.com.hotel.login.LoginController;
import main.java.com.hotel.metier.StringRessources;
import main.java.com.hotel.model.Categorie;
import main.java.com.hotel.model.Chambre;
import main.java.com.hotel.model.Permission;
import main.java.com.hotel.permission.MyPrivilegedAction;

import javax.security.auth.Subject;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created by Ilyas Bouyacoub on 03/04/2017.
 */
public class ChambreDAO extends DAO {
    private static List<Observer> observers = new ArrayList<>();


    public ChambreDAO() {
        super();
    }

    public static void addObserver(Observer obs) {
        observers.add(obs);
    }

    public static void updateObservers(Object o) {
        for (Observer obs : observers) {
            obs.update(null, o);
        }
    }

    public static void deleteObservers() {
        observers = new ArrayList<>();
    }

    /**
     * Insert a new Chambre into the database.
     *
     * @param chambre
     */
    public void create(Chambre chambre) {
        try {
            try {
                Subject.doAs(LoginController.getLoginContext().getSubject(), new MyPrivilegedAction("CHAMBRE", Permission.CREATE));
                super.saveOrUpdate(chambre);
                updateObservers(StringRessources.MSG_CHAMBRE_SUCCES);
                updateObservers(chambre);
            } catch (AccessControlException e) {
                e.printStackTrace();
                updateObservers(StringRessources.MSG_PRIVILEGES);
            }
        } catch (DataAccessLayerException e) {
            updateObservers(StringRessources.MSG_CHAMBRE_ERREUR);
        } catch (Exception e) {
            updateObservers(StringRessources.MSG_CHAMBRE_ERREUR);
        }
    }

    /**
     * Delete a detached Chambre from the database.
     *
     * @param chambre
     */
    public void delete(Chambre chambre) throws DataAccessLayerException {

        try {
            Subject.doAs(LoginController.getLoginContext().getSubject(), new MyPrivilegedAction("CHAMBRE", Permission.DELETE));
            updateObservers(StringRessources.MSG_SUPPRESSION_SUCCES);
            super.delete(chambre);
        } catch (AccessControlException e) {
            e.printStackTrace();
            updateObservers(StringRessources.MSG_PRIVILEGES);
        }
    }

    /**
     * Find an Chambre by its primary key.
     *
     * @param id
     * @return
     */
    public Chambre find(int id) throws DataAccessLayerException {
        try {
            Subject.doAs(LoginController.getLoginContext().getSubject(), new MyPrivilegedAction("CHAMBRE", Permission.READ));
            return (Chambre) super.find(Chambre.class, id);
        } catch (AccessControlException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Updates the state of a detached Chambre.
     *
     * @param chambre
     */
    public void update(Chambre chambre) throws DataAccessLayerException {
        try {
            Subject.doAs(LoginController.getLoginContext().getSubject(), new MyPrivilegedAction("CHAMBRE", Permission.UPDATE));
            super.saveOrUpdate(chambre);
            updateObservers(StringRessources.MSG_MODIFICATION_SUCCES);
        } catch (AccessControlException e) {
            e.printStackTrace();
            updateObservers(StringRessources.MSG_PRIVILEGES);
        }
    }

    /**
     * Finds all Chambre in the database.
     *
     * @return
     */
    public List<Chambre> findAll() throws DataAccessLayerException {
        try {
            Subject.doAs(LoginController.getLoginContext().getSubject(), new MyPrivilegedAction("CHAMBRE", Permission.READ));
            return super.findAll(Chambre.class);
        } catch (AccessControlException e) {
            e.printStackTrace();

        }
        return new ArrayList<>();
    }

    public List<Chambre> createAll(int debut, int fin, Categorie categorie, int etage) {

//            Chambre chambre = new Chambre();
//            chambre.setNumeroChambre(i);
//            chambre.setEtage(Integer.valueOf(etage.getText()));
//            chambre.setCheck(false);
//            chambre.setCategorie(categorie.getValue());
//            ChambreDAO chambreDAO = (ChambreDAO) DAOFactory.getDAO(StringRessources.CHAMBRE);

        return null;
    }
}
