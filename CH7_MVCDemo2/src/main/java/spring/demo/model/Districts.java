package spring.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Generated Mar 18, 2015 12:15:31 PM by Hibernate Tools 4.3.1

/**
 * Districts generated by hbm2java
 */
@Entity
@Table(name="districts")
public class Districts implements java.io.Serializable {

	@Id
	@Column(name="DISTRICT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer districtId;
	
	@ManyToOne
	@JoinColumn(name="AMPHUR_ID")
	private Amphures amphures;
	
	@Column(name="DISTRICT_CODE")
	private String districtCode;
	
	@Column(name="DISTRICT_NAME")
	private String districtName;
	
	

	public Districts() {
	}

	public Districts(Amphures amphures, String districtCode, String districtName) {
		this.amphures = amphures;
		this.districtCode = districtCode;
		this.districtName = districtName;
	}

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Amphures getAmphures() {
		return this.amphures;
	}

	public void setAmphures(Amphures amphures) {
		this.amphures = amphures;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
