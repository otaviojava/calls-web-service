package my.compary.service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@ApplicationScoped
public class CallRepository implements PanacheRepository<Call> {

    private static final int SIZE = 10;

    public Stream<Call> findCall(TypeCall type, int index) {
        Page page = Page.of(index, SIZE);
        if (Objects.isNull(type)) {
            return findAll().page(page).stream();
        }
        return find("status", type).page(page).stream();
    }

}
