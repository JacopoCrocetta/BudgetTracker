package com.project.bebudgeting.mensile.service.previsti.uscite;

import com.project.bebudgeting.mensile.repository.previsti.uscite.AltreUscitePrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltreUscitePrevisteService {
    @Autowired
    AltreUscitePrevisteRepository repository;
}
