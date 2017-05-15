package com.cnxs.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.eclipse.persistence.annotations.AdditionalCriteria;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
@AdditionalCriteria("this.deleted=0")
public abstract class BusinessObjectBase {
    
	//创建时间
    @Column(name="creationtime", updatable=false)
    private Date creationTime;
    
	//是否删除
    @JsonIgnore
    private boolean deleted;
    
    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
