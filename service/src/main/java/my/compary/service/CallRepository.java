package my.compary.service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CallRepository implements PanacheRepository<Call> {
}
