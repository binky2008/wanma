package com.jinhe.tss.framwork;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.jinhe.tss.framework.persistence.IEntity;

@MappedSuperclass
public abstract class AbstractEntity implements IEntity {

	@Version
	private int lockVersion = 0;

	public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder
				.reflectionToString(this);
	}
	
	protected abstract Long getId();

	public Serializable getPK() {
		return this.getId();
	}

	public int getLockVersion() {
		return lockVersion;
	}

	public void setLockVersion(int lockVersion) {
		this.lockVersion = lockVersion;
	}
}