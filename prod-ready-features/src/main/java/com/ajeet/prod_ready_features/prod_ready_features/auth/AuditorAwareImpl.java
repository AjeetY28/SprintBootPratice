package com.ajeet.prod_ready_features.prod_ready_features.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //upcoming week do
        //get security context
        //get authentication
        //get the principal
        //get the username
        return Optional.of("Ajeet Yadav");
    }
}
