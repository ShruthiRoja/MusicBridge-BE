package com.musicbridge.framework;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/*you can also use annotations reda more in this article
* https://docs.spring.io/spring-data/jpa/docs/1.7.0.DATAJPA-580-SNAPSHOT/reference/html/auditing.html */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity implements Persistable<UUID> , Auditable<UUID,UUID,LocalDateTime> {

    @Id
    @Column(name = "Id", unique = true, nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID id;

    @NotNull
    @Column(name = "CreatedBy", nullable = false)
    @Type(type = "uuid-char")
    private UUID createdBy;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDT", nullable = false)
    private Date createdDate;

    @Column(name = "UpdatedBy")
    @Type(type = "uuid-char")
    @LastModifiedBy
    private UUID lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdatedDT")
    private Date lastModifiedDate;

    @Version
    @Column(name = "Version")
    private Long version = 0L;

    public AbstractBaseEntity() {
    }

    public Optional<UUID> getCreatedBy() {
        return Optional.ofNullable(this.createdBy);
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public Optional<LocalDateTime> getCreatedDate() {
        return null == this.createdDate ? Optional.empty() : Optional.of(LocalDateTime.ofInstant(this.createdDate.toInstant(), ZoneId.systemDefault()));
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = Date.from(createdDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    public Optional<UUID> getLastModifiedBy() {
        return Optional.ofNullable(this.lastModifiedBy);
    }

    public void setLastModifiedBy(UUID lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Optional<LocalDateTime> getLastModifiedDate() {
        return null == this.lastModifiedDate ? Optional.empty() : Optional.of(LocalDateTime.ofInstant(this.lastModifiedDate.toInstant(), ZoneId.systemDefault()));
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = Date.from(lastModifiedDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        AbstractBaseEntity rhs = (AbstractBaseEntity) obj;
        return this.id != null && this.id.equals(rhs.id);
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += (this.id == null) ? 0 : this.id.hashCode() * 31;
        return hashCode;
    }
}
