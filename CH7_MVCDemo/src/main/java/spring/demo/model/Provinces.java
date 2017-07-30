package spring.demo.model;

// Generated Mar 18, 2015 12:15:31 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Provinces generated by hbm2java
 */
@Entity
@Table(name="provinces")
public class Provinces implements java.io.Serializable {

	@Id
	@Column(name="PROVINCE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int provinceId;
	
	@ManyToOne
	@JoinColumn(name="GEO_ID")
	private Geography geography;
	
	@Column(name="PROVINCE_CODE")
	private String provinceCode;
	
	@Column(name="PROVINCE_NAME")
	private String provinceName;
	
	//@Transient
	//private List<Amphures> amphureses ;

	public Provinces() {
	}

	public Provinces(Geography geography, String provinceCode, String provinceName) {
		this.geography = geography;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
	}

	/*public Provinces(Geography geography, String provinceCode, String provinceName, Set amphureses) {
		this.geography = geography;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
		this.amphureses = amphureses;
	}*/

	public int getId() {
		return this.provinceId;
	}

	public void setId(int provinceId) {
		this.provinceId = provinceId;
	}

	public Geography getGeography() {
		return this.geography;
	}

	public void setGeography(Geography geography) {
		this.geography = geography;
	}

	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	/*public Set getAmphureses() {
		return this.amphureses;
	}*/

	/*public void setAmphureses(Set amphureses) {
		this.amphureses = amphureses;
	}*/

}
