package com.wanlin.springboot.controller;

import com.wanlin.springboot.domain.City;
import com.wanlin.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {

        System.out.println("==================== startCity ========================" + cityName);

        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value = "/api/sayHello")
    public String sayHello(String name) {

        System.out.println("==================== cityName ========================" + name);

        //return cityService.findCityByName(cityName);
        return name;
    }

    @RequestMapping(value = "/api/savecity" , method = RequestMethod.POST)
    public int saveCity(long provinceId,String cityName,String description) {
        int resultNum = 0;
        System.out.println("==================== provinceId ========================" + provinceId);
        City city = new City();
        city.setProvinceId(provinceId);
        city.setCityName(cityName);
        city.setDescription(description);
        resultNum = cityService.saveCity(city);
        return resultNum;
    }

    @RequestMapping(value = "/api/deletecity" , method = RequestMethod.GET)
    public int deleteCity(@RequestParam(value = "cityId", required = true) String cityId){
        int resultNum = 0;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("cityId",cityId);
        if (!map.isEmpty()) resultNum = cityService.deleteCity(map);
        return resultNum;
    }

    @RequestMapping(value = "/api/updatecity" , method = RequestMethod.POST)
    public int updateCity(@RequestParam(value = "cityId", required = true) String cityId,
                                String cityName, String description){
        int resultNum = 0;

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("cityId",cityId);
        map.put("cityName",cityName);
        map.put("description",description);
        if(!map.isEmpty() && !StringUtils.isEmpty(map.get("cityId")))
            resultNum = cityService.updateCity(map);
        return resultNum;
    }

    @RequestMapping(value="/api/findcitybycityid" , method = RequestMethod.GET)
    public City findCityByCityId(@RequestParam(value = "cityId", required = true) String cityId){
        City city = null;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("cityId",cityId);
        if (!map.isEmpty()) city = cityService.findCityById(map);
        return city;
    }

    @RequestMapping(value="/api/findcitybyname" , method = RequestMethod.GET)
    public List<City> findCityByName(@RequestParam(value = "cityName", required = true) String cityName){
        List<City> list = null;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("cityName",cityName);
        if(!map.isEmpty()) list = cityService.findCityByName(map);
        return list;
    }

}
