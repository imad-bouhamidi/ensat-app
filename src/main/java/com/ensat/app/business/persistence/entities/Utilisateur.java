package com.ensat.app.business.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name="utilisateur")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private byte actif;

	@Column(nullable=false, length=150)
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified", nullable=false)
	private Date lastModified;

	@Column(nullable=false, length=150)
	private String login;

	@Column(nullable=false, length=150)
	private String nom;

	@Column(nullable=false, length=150)
	private String password;

	@Column(nullable=false, length=150)
	private String prenom;

	//bi-directional many-to-one association to Fonction
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="fonction_id", nullable=false)
	private Fonction fonction;

	//bi-directional many-to-many association to Role
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private List<Role> roles;

	public Utilisateur() {
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Fonction getFonction() {
		return this.fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}