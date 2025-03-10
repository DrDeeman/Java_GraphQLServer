package org.example.entity;
// Generated 7 мар. 2025 г., 11:03:17 by Hibernate Tools 3.2.2.GA


import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * eUsers generated by hbm2java
 */
@Entity
@Table(name = "users"
)
public class eUsers implements java.io.Serializable {


    private int id;
    private String name;
    private String login;
    private String password;
    private String email;

    public eUsers() {
    }

    public eUsers(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    
    @Column(name = "id", nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "login")
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * toString
     *
     * @return String
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        buffer.append("id").append("='").append(getId()).append("' ");
        buffer.append("name").append("='").append(getName()).append("' ");
        buffer.append("login").append("='").append(getLogin()).append("' ");
        buffer.append("password").append("='").append(getPassword()).append("' ");
        buffer.append("email").append("='").append(getEmail()).append("' ");
        buffer.append("]");

        return buffer.toString();
    }

    public boolean equals(Object other) {
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof eUsers)) return false;
        eUsers castOther = (eUsers) other;

        return (this.getId() == castOther.getId())
                && ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null && this.getName().equals(castOther.getName())))
                && ((this.getLogin() == castOther.getLogin()) || (this.getLogin() != null && castOther.getLogin() != null && this.getLogin().equals(castOther.getLogin())))
                && ((this.getPassword() == castOther.getPassword()) || (this.getPassword() != null && castOther.getPassword() != null && this.getPassword().equals(castOther.getPassword())))
                && ((this.getEmail() == castOther.getEmail()) || (this.getEmail() != null && castOther.getEmail() != null && this.getEmail().equals(castOther.getEmail())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getId();
        result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
        result = 37 * result + (getLogin() == null ? 0 : this.getLogin().hashCode());
        result = 37 * result + (getPassword() == null ? 0 : this.getPassword().hashCode());
        result = 37 * result + (getEmail() == null ? 0 : this.getEmail().hashCode());
        return result;
    }


}


