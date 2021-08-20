package com.project.bebudgeting.mensile.service.effettivi;

import com.project.bebudgeting.mensile.repository.effettivi.EntrateEffettiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrateEffettiveService {
    @Autowired
    EntrateEffettiveRepository repository;
}
