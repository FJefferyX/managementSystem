package com.Xiong.service.impl;

import com.Xiong.dao.TravellerDao;
import com.Xiong.domain.Traveller;
import com.Xiong.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravellerServiceImp implements TravellerService {
    @Autowired
    private TravellerDao travellerDao;

    @Override
    public Traveller findById(String id) {
        return null;
    }
}
