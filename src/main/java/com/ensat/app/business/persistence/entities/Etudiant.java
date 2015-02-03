package com.ensat.app.business.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the etudiant database table.
 * 
 */
@Entity
@NamedQuery(name="Etudiant.findAll", query="SELECT e FROM Etudiant e")
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Boolean ajournee;
	private Date birthdate;
	private String cin;
	private String cne;
	private String email;
	private String nom;
	private byte[] photo;
	private String prenom;
	private String sexe;
	private String ville;
	private Filier filier;
	private List<EtudiantSession> etudiantSessions;

	public Etudiant() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Boolean getAjournee() {
		return this.ajournee;
	}

	public void setAjournee(Boolean ajournee) {
		this.ajournee = ajournee;
	}


	@Temporal(TemporalType.DATE)
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getCne() {
		return this.cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Lob
	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	//bi-directional many-to-one association to Filier
	@ManyToOne(fetch=FetchType.LAZY)
	public Filier getFilier() {
		return this.filier;
	}

	public void setFilier(Filier filier) {
		this.filier = filier;
	}


	//bi-directional many-to-one association to EtudiantSession
	@OneToMany(mappedBy="etudiant")
	public List<EtudiantSession> getEtudiantSessions() {
		return this.etudiantSessions;
	}

	public void setEtudiantSessions(List<EtudiantSession> etudiantSessions) {
		this.etudiantSessions = etudiantSessions;
	}

	public EtudiantSession addEtudiantSession(EtudiantSession etudiantSession) {
		getEtudiantSessions().add(etudiantSession);
		etudiantSession.setEtudiant(this);

		return etudiantSession;
	}

	public EtudiantSession removeEtudiantSession(EtudiantSession etudiantSession) {
		getEtudiantSessions().remove(etudiantSession);
		etudiantSession.setEtudiant(null);

		return etudiantSession;
	}

}