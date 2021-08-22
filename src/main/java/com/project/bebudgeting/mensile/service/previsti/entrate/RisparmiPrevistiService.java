package com.project.bebudgeting.mensile.service.previsti.entrate;

import com.project.bebudgeting.mensile.repository.previsti.entrate.RisparmiPrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RisparmiPrevistiService {
    @Autowired
    RisparmiPrevisteRepository repository;
}
