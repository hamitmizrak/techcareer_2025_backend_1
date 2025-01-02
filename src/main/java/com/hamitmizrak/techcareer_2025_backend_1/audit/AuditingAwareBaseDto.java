package com.hamitmizrak.techcareer_2025_backend_1.audit;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

// LOMBOK
@Getter
@Setter

abstract public class AuditingAwareBaseDto implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID = 1L;

    // AUDITING
    // Kim ekledi ?
    protected String createdBy;

    // Kim ne zaman ekledi ?
    protected String createdDate;

    // Kim güncelledi ?
    protected String lastModifiedBy;

    // Kim ne zaman güncelledi ?
    protected String lastModifiedDate;
}
