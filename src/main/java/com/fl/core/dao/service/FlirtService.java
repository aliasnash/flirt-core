package com.fl.core.dao.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fl.core.dao.FlirtDao;

import lombok.Setter;

@Setter
@Service
@Transactional(readOnly = false)
public class FlirtService {
    
    @Resource
    private FlirtDao flirtDao;
    
}
