package com.project.bebudgeting.mensile.service.previsti.entrate;

import com.project.bebudgeting.mensile.repository.previsti.entrate.InteressiPrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteressiPrevistiService {
    @Autowired
    InteressiPrevisteRepository repository;
}
