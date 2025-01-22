package org.example.Service.Service.Impl;

import org.example.Service.Mapper.ServiceMapper;
import org.example.Service.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceMapper serviceMapper;
    @Override
    public List<Map<String, Object>> getService() {
        return serviceMapper.getService();
    }
}
