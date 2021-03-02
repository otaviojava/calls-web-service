package my.compary.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
public class CallService {

    private final CallRepository repository;

    public CallService(CallRepository repository) {
        this.repository = repository;
    }

    public List<CallDTO> query(CallFilter query) {
        Stream<Call> calls = repository.findCall(query.getType(), query.getPage());
        return calls.map(CallDTO::of).collect(toList());
    }
}
