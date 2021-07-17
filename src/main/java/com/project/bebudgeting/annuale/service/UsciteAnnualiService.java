package com.project.bebudgeting.annuale.service;

import com.project.bebudgeting.annuale.repository.UsciteAnnualiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsciteAnnualiService {
    @Autowired
    UsciteAnnualiRepository repository;
}