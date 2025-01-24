package org.example.Service.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.Service.Mapper.ServiceMapper;
import org.example.Service.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceMapper serviceMapper;
    @Override
    public List<Map<String, Object>> getService() {
        log.info("返回值map{}",serviceMapper.getService());
        return serviceMapper.getService();
    }
}
