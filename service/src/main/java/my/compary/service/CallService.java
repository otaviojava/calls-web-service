package my.compary.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
public class CallService {

    private final CallRepository repository;

    @Inject
    public CallService(CallRepository repository) {
        this.repository = repository;
    }

    public List<CallDTO> query(CallFilter query) {
        Stream<Call> calls = repository.findCall(query.getType(), query.getPage());
        return calls.map(CallDTO::of).collect(toList());
    }

    @Transactional
    public List<CallDTO> save(CallsDTO dtos) {
        List<Call> calls = dtos.getDtos().stream().map(CallDTO::toEntity).collect(toList());
        repository.persist(calls);
        return calls.stream().map(CallDTO::of).collect(toList());
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
