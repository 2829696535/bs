package org.example.Service.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ServiceMapper {

List<Map<String, Object>> getService();
}
