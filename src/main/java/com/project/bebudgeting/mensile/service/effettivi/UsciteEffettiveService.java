package com.project.bebudgeting.mensile.service.effettivi;

import com.project.bebudgeting.mensile.repository.effettivi.UsciteEffettiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsciteEffettiveService {
    @Autowired
    UsciteEffettiveRepository repository;
}
