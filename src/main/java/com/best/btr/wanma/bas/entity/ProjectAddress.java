package com.best.btr.wanma.bas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framwork.AbstractEntity;

@Entity
@Table(name = "WM_BAS_PROJECT_ADDRESS")
@SequenceGenerator(name = "project_addr_sequence", sequenceName = "project_addr_sequence", initialValue = 1000, allocationSize = 10)
public class ProjectAddress extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "project_addr_sequence")
    private Long id;
    
    @ManyToOne
    private Project project;
    
    @ManyToOne
    private Customer customer;
    
    @ManyToOne
    private Site ownerSite;
    
    @Column(length = 128, nullable = false)
    private String customerName;
    
    @Column(length = 128, nullable = false)
    private String contacts;

    @Column(length = 128, nullable = false)
    private String phone;
    
    @Column(length = 256, nullable = false)
    private String address;
    
    @ManyToOne
    private Param state;
    
	public Long getId() {
		return this.getId();
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Param getState() {
		return state;
	}

	public void setState(Param state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Site getOwnerSite() {
		return ownerSite;
	}

	public void setOwnerSite(Site ownerSite) {
		this.ownerSite = ownerSite;
	}
}
