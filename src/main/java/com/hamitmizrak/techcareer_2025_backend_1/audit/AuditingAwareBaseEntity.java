package com.hamitmizrak.techcareer_2025_backend_1.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

// LOMBOK
@Setter
@Getter

// ENTITY SUPER CLASS
@MappedSuperclass

// AUDITING ÇALIŞMASI İÇİN
@EntityListeners(AuditingEntityListener.class)

// Backtend'ten Frontend'e Verilerin görünmemesi için:
@JsonIgnoreProperties(value = {"created_date","last_modified_date"},allowGetters = true)
abstract  public class AuditingAwareBaseEntity implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID = 1L;

    // AUDITING
    // Kim ekledi
    @CreatedBy
    @Column(name="created_by")
    @JsonIgnore // Backentend'ten Frontend'e veri gönderme
    protected String createdBy;

    // Kim ne zaman ekledi
    @CreatedDate
    @Column(name="created_date")
    @JsonIgnore // Backentend'ten Frontend'e veri gönderme
    protected String createdDate;

    // Kim güncelledi
    @LastModifiedBy
    @Column(name="last_modified_by")
    @JsonIgnore // Backentend'ten Frontend'e veri gönderme
    protected String lastModifiedBy;

    // Kim ne zaman güncelledi
    @LastModifiedDate
    @Column(name="last_modified_date")
    @JsonIgnore // Backentend'ten Frontend'e veri gönderme
    protected String lastModifiedDate;

} //end AuditingAwareBaseEntity
