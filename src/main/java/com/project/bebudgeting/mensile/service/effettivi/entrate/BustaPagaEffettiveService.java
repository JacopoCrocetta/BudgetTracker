package com.project.bebudgeting.mensile.service.effettivi.entrate;

import com.project.bebudgeting.mensile.repository.effettivi.entrate.BustaPagaEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BustaPagaEffettiveService {
    @Autowired
    BustaPagaEffettiviRepository repository;
}
