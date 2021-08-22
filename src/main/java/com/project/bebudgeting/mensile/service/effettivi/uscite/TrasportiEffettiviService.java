package com.project.bebudgeting.mensile.service.effettivi.uscite;

import com.project.bebudgeting.mensile.repository.effettivi.uscite.TrasportiEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrasportiEffettiviService {
    @Autowired
    TrasportiEffettiviRepository repository;
}
