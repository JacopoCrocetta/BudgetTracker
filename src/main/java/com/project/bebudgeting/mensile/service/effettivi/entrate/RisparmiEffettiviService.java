package com.project.bebudgeting.mensile.service.effettivi.entrate;

import com.project.bebudgeting.mensile.repository.effettivi.entrate.RisparmiEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RisparmiEffettiviService {
    @Autowired
    RisparmiEffettiviRepository repository;
}
