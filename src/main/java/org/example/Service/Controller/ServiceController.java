package org.example.Service.Controller;

import org.example.Service.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/Service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @PostMapping("/getService")
    public Map<String,Object> getService(){
        Map<String,Object>map = new HashMap<>();
        map.put("data",serviceService.getService());
        return map;
    }
}
