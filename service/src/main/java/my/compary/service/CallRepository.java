package my.compary.service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class CallRepository implements PanacheRepository<Call> {

    public Stream<Call> findAlive(TypeCall type, long page){
        return stream("status", type);
    }

}
