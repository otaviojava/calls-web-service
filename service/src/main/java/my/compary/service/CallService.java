package my.compary.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CallService {

    private final CallRepository repository;

    public CallService(CallRepository repository) {
        this.repository = repository;
    }

    public List<CallDTO> query(CallFilter query) {

        return null;
    }
}
