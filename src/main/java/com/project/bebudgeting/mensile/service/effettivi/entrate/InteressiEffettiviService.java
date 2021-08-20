package com.project.bebudgeting.mensile.service.effettivi.entrate;

import com.project.bebudgeting.mensile.repository.effettivi.entrate.InteressiEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteressiEffettiviService {
    @Autowired
    InteressiEffettiviRepository repository;
}
