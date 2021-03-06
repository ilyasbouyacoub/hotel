package main.java.com.hotel.model;
// Generated 30 avr. 2017 02:56:43 by Hibernate Tools 5.2.0.CR1

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * @author Ilies Bouyacoub
 */

@Entity
@Table(name = "chambre", catalog = "hotel")
public class Chambre implements java.io.Serializable {

    private IntegerProperty idChambre;
    private Categorie categorie;
    private IntegerProperty numeroChambre;
    private IntegerProperty etage;
    private BooleanProperty checked;


    public Chambre() {
        this.idChambre = new SimpleIntegerProperty();
        categorie = new Categorie();
        this.numeroChambre = new SimpleIntegerProperty();
        this.etage = new SimpleIntegerProperty();
        this.checked = new SimpleBooleanProperty();
    }

    public Chambre(int idChambre) {
        this.idChambre = new SimpleIntegerProperty(idChambre);
        this.numeroChambre = new SimpleIntegerProperty();
        this.etage = new SimpleIntegerProperty();
        this.checked = new SimpleBooleanProperty();


    }

    public Chambre(int idChambre, Categorie categorie, Integer numeroChambre, Integer etage,
                   Boolean checked) {
        this.idChambre = new SimpleIntegerProperty(idChambre);
        this.categorie = categorie;
        this.numeroChambre = new SimpleIntegerProperty(numeroChambre);
        this.etage = new SimpleIntegerProperty(etage);
        this.checked = new SimpleBooleanProperty(checked);


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChambre", unique = true, nullable = false)
    public int getIdChambre() {
        return this.idChambre.get();
    }

    public void setIdChambre(int idChambre) {
        this.idChambre.set(idChambre);
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_categorie")
    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    @Column(name = "numeroChambre")
    public Integer getNumeroChambre() {
        return this.numeroChambre.get();
    }

    public void setNumeroChambre(Integer numeroChambre) {
        this.numeroChambre.set(numeroChambre);
    }

    @Column(name = "etage")
    public Integer getEtage() {
        return this.etage.get();
    }

    public void setEtage(Integer etage) {
        this.etage.set(etage);
    }

    @Column(name = "checked")

    public Boolean getChecked() {
        return this.checked.get();
    }

    public void setChecked(Boolean checked) {
        this.checked.set(checked);

    }


    public IntegerProperty idChambreProperty() {
        return idChambre;
    }

    public IntegerProperty numeroChambreProperty() {
        return numeroChambre;
    }

    public IntegerProperty etageProperty() {
        return etage;
    }


    public BooleanProperty checkedProperty() {
        return checked;
    }
}
