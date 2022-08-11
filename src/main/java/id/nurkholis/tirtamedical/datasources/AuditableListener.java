package id.nurkholis.tirtamedical.datasources;

import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.PrePersist;
import java.time.OffsetDateTime;

@Configurable
public class AuditableListener {
    @PrePersist
    public void touchForCreate(Object target) {
        if (!(target instanceof Auditable)) {
            return;
        }

        final Auditable e = (Auditable) target;

        e.setCreatedAt(OffsetDateTime.now());
    }
}
