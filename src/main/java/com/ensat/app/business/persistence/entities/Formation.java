package com.ensat.app.business.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formation database table.
 * 
 */
@Entity
@NamedQuery(name="Formation.findAll", query="SELECT f FROM Formation f")
public class Formation implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private Integer duree;
	private String titre;
	private Utilisateur professeur;
	private Filier filier;
	private List<Session> sessions;

	public Formation() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getDuree() {
		return this.duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}


	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	//bi-directional many-to-one association to Professeur
	@ManyToOne(fetch=FetchType.LAZY)
	public Utilisateur getProfesseur() {
		return this.professeur;
	}

	public void setProfesseur(Utilisateur professeur) {
		this.professeur = professeur;
	}


	//bi-directional many-to-one association to Filier
	@ManyToOne(fetch=FetchType.LAZY)
	public Filier getFilier() {
		return this.filier;
	}

	public void setFilier(Filier filier) {
		this.filier = filier;
	}


	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="formation")
	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setFormation(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setFormation(null);

		return session;
	}

}