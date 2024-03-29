package com.wanlin.springboot.service.imp;


import com.wanlin.springboot.dao.CityDao;
import com.wanlin.springboot.domain.City;
import com.wanlin.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 城市业务逻辑实现类
 *
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;


    @Override
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    public int saveCity(City city){
        int resultNum = 0;
        Map<String,Object> map = new HashMap<String,Object>();
        if(null != city){
            long provinceId = city.getProvinceId();
            String cityName = city.getCityName();
            String description = city.getDescription();
            map.put("provinceId",provinceId);
            map.put("cityName",cityName);
            map.put("description",description);
            if(!map.isEmpty()) resultNum = cityDao.saveCity(map);
        }

        return resultNum;
    }

    /**
     * 根据城市ID删除城市信息
     * @param map 城市属性信息
     * @return 成功操作的记录条数
     */
    public int deleteCity(Map<String,Object> map){
        return cityDao.deleteCity(map);
    }

    /**
     * 修改城市信息
     * @param map 城市属性信息
     * @return 成功操作的记录条数
     */
    public int updateCity(Map<String,Object> map){
        return cityDao.updateCity(map);
    }

    /**
     * 根据城市ID获取城市信息
     * @param map 城市ID
     * @return 城市信息
     */
   public City findCityById(Map<String,Object> map){
       return cityDao.findCityById(map);
   }

    /**
     * 根据名称获取城市列表
     * @param map 城市名称
     * @return 城市信息列表
     */
    public List<City> findCityByName(Map<String,Object> map){
       return cityDao.findCityByName(map);
    }


}
