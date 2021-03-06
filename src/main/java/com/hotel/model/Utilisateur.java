package main.java.com.hotel.model;
// Generated 30 avr. 2017 02:56:43 by Hibernate Tools 5.2.0.CR1

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Zakaria Choukchou
 */

@Entity
@Table(name = "utilisateur", catalog = "hotel")
@Proxy(lazy = false)
public class Utilisateur implements java.io.Serializable {


    private IntegerProperty idUser;
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty tel;
    private StringProperty type;
    private StringProperty username;
    private String password;
    private Usertype usertype;

    public Utilisateur() {
        this.idUser = new SimpleIntegerProperty();
        this.nom = new SimpleStringProperty();
        this.prenom = new SimpleStringProperty();
        this.tel = new SimpleStringProperty();
        this.type = new SimpleStringProperty();
        this.username = new SimpleStringProperty();
    }

    public Utilisateur(int idUser) {
        this.idUser = new SimpleIntegerProperty(idUser);
        this.nom = new SimpleStringProperty();
        this.prenom = new SimpleStringProperty();
        this.tel = new SimpleStringProperty();
        this.type = new SimpleStringProperty();
        this.username = new SimpleStringProperty();
    }

    public Utilisateur(int idUser, String nom, String prenom, String tel, String type, String username, String password) {
        this.idUser = new SimpleIntegerProperty(idUser);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.tel = new SimpleStringProperty(tel);
        this.type = new SimpleStringProperty(type);
        this.username = new SimpleStringProperty(username);
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idUser", unique = true, nullable = false)
    public Integer getIdUser() {
        return this.idUser.get();
    }

    public void setIdUser(int idUser) {
        this.idUser.set(idUser);
    }

    @Column(name = "nom", length = 20)
    public String getNom() {
        return this.nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    @Column(name = "prenom", length = 20)
    public String getPrenom() {
        return this.prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    @Column(name = "tel", length = 15)
    public String getTel() {
        return this.tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    @Column(name = "type", nullable = false)
    public String getType() {

        return type.get();

    }

    public void setType(String type) {
        this.type.set(type);
    }

    @Column(name = "username", length = 20, unique = true, nullable = false)
    public String getUsername() {
        return this.username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    @Column(name = "password", length = 64, updatable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type", nullable = false, insertable = false, updatable = false)
    public Usertype getUsertype() {
        return this.usertype;
    }

    public void setUsertype(Usertype usertype) {
        this.usertype = usertype;
    }

    public IntegerProperty idUserProperty() {
        return idUser;
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public StringProperty telProperty() {
        return tel;
    }

    public StringProperty typeProperty() {
        return type;
    }

    public StringProperty usernameProperty() {
        return username;
    }


    public enum Type {
        ADMIN("ADMIN"),
        CHEF("CHEF"),
        RECEPTIONISTE("RECEPTIONISTE");
        private final String type;

        private Type(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }

    }

}
