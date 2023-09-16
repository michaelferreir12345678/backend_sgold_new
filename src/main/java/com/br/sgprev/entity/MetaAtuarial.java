package com.br.sgprev.entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;



@Entity
@Table(name = "META_ATUARIAL")
public class MetaAtuarial implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_META_ATUARIAL")
	@SequenceGenerator(name="SEQ_META_ATUARIAL", sequenceName="SQ_META_ATUARIAL", allocationSize=1)	
	@Column(name = "SEQ_META_ATUARIAL")	
	private java.lang.Long id;
	
	@Column(name = "DAT_META")
	private java.util.Date dataInicio;
	@Column(name = "COD_INDICE")
	private java.lang.Integer indice;
	@Column(name = "VLR_META_ADC")
	private java.math.BigDecimal valorAdicional;
	@Transient
	private String nomeIndice;
	@Transient
	private java.math.BigDecimal indicador, indicadorAcumulado, meta, metaAcumulada, margemSeguranca, retornoDesejado;
	
	/**
	 * O formato do titulo � "Meta Atuarial (NomeIndice + ValorAdicional % a.a.)"
	 * @return
	 */
	public String getTitulo() {
		StringBuffer tituloMeta = new StringBuffer("Meta Atuarial (");
//		tituloMeta.append(getNomeIndice());
		tituloMeta.append(" + ");
		tituloMeta.append(100*getValorAdicional().doubleValue());
		tituloMeta.append("% a.a.)");
		
		return tituloMeta.toString();
	}
	
	/**
	 * O formato do titulo � "NomeIndice + ValorAdicional % a.a."
	 * @return
	 */
	public String getTitulo2() {
		StringBuffer tituloMeta = new StringBuffer("");
//		tituloMeta.append(getNomeIndice());
		tituloMeta.append(" + ");
		tituloMeta.append(100*getValorAdicional().doubleValue());
		tituloMeta.append("% a.a.");
		
		return tituloMeta.toString();
	}	

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.util.Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(java.util.Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public java.lang.Integer getIndice() {
		return indice;
	}

	public void setIndice(java.lang.Integer indice) {
		this.indice = indice;
	}

	public java.math.BigDecimal getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(java.math.BigDecimal valorAdcional) {
		this.valorAdicional = valorAdcional;
	}


	public void setNomeIndice(String nomeIndice) {
		this.nomeIndice = nomeIndice;
	}

	public java.math.BigDecimal getIndicador() {
		return indicador;
	}

	public void setIndicador(java.math.BigDecimal indicador) {
		this.indicador = indicador;
	}

	public java.math.BigDecimal getIndicadorAcumulado() {
		return indicadorAcumulado;
	}

	public void setIndicadorAcumulado(java.math.BigDecimal indicadorAcumulado) {
		this.indicadorAcumulado = indicadorAcumulado;
	}

	public java.math.BigDecimal getMeta() {
		return meta;
	}

	public void setMeta(java.math.BigDecimal meta) {
		this.meta = meta;
	}

	public java.math.BigDecimal getMetaAcumulada() {
		return metaAcumulada;
	}

	public void setMetaAcumulada(java.math.BigDecimal metaAcumulada) {
		this.metaAcumulada = metaAcumulada;
	}	

	public java.math.BigDecimal getMargemSeguranca() {
		return margemSeguranca;
	}

	public void setMargemSeguranca(java.math.BigDecimal margemSeguranca) {
		this.margemSeguranca = margemSeguranca;
	}
	

	public java.math.BigDecimal getRetornoDesejado() {
		return retornoDesejado;
	}

	public void setRetornoDesejado(java.math.BigDecimal retornoDesejado) {
		this.retornoDesejado = retornoDesejado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((indice == null) ? 0 : indice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetaAtuarial other = (MetaAtuarial) obj;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (indice == null) {
			if (other.indice != null)
				return false;
		} else if (!indice.equals(other.indice))
			return false;
		return true;
	}		
}
