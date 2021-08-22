package com.project.bebudgeting.mensile.service.effettivi.entrate;

import com.project.bebudgeting.mensile.repository.effettivi.entrate.BonusEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonusEffettiviService {
    @Autowired
    BonusEffettiviRepository repository;

    public long count() {
        return repository.count();
    }
}
