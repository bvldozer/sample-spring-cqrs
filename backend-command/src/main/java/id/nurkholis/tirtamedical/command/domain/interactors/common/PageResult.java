package id.nurkholis.tirtamedical.command.domain.interactors.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PageResult<T> {
    private List<T> result = Collections.emptyList();
    private Long count = 0l;

    public PageResult(List<T> result) {
        this.result = result != null ? result : Collections.emptyList();
        this.count = result != null ? result.size() : 0l;
    }

    public Page<T> toPage(int page, int size) {
        if (result != null) {
            return new PageImpl<>(result, PageRequest.of(page, size), getCount().longValue());
        } else {
            return Page.empty();
        }
    }
}
