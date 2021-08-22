package com.project.bebudgeting.mensile.service.previsti.uscite;

import com.project.bebudgeting.mensile.repository.previsti.uscite.TrasportiPrevistiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrasportiPrevistiService {
    @Autowired
    TrasportiPrevistiRepository repository;
}
