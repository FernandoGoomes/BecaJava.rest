package br.rest.app.model;

public class Voto {
	
	private Long Id;
	private Long CandidatoId;
	private Long EleitorId;
	private Long ZonaId;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getCandidatoId() {
		return CandidatoId;
	}
	public void setCandidatoId(Long candidatoId) {
		CandidatoId = candidatoId;
	}
	public Long getEleitorId() {
		return EleitorId;
	}
	public void setEleitorId(Long eleitorId) {
		EleitorId = eleitorId;
	}
	public Long getZonaId() {
		return ZonaId;
	}
	public void setZonaId(Long zonaId) {
		ZonaId = zonaId;
	}

}