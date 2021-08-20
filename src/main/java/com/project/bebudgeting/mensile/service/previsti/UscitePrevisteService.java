package com.project.bebudgeting.mensile.service.previsti;

import com.project.bebudgeting.mensile.repository.previsti.UscitePrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UscitePrevisteService {
    @Autowired
    UscitePrevisteRepository repository;

}
