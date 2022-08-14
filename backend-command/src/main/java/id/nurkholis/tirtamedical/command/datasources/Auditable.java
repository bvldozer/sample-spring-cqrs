package id.nurkholis.tirtamedical.command.datasources;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditableListener.class)
public class Auditable {

    @Basic(optional = false)
    @Column(name = "created_at", updatable = false, nullable = false)
    @CreatedDate
    protected OffsetDateTime createdAt;

}
