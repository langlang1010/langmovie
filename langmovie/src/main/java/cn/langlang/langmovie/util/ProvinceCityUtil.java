package cn.langlang.langmovie.util;

import cn.langlang.langmovie.bean.City;
import cn.langlang.langmovie.bean.ProvinceCity;
import java.util.*;

/**
 * 处理成每个省份所拥有的所有城市的格式
 * 原本的LinkedList：黑龙江：齐齐哈尔；黑龙江：七台河；黑龙江：哈尔滨；....
 * 最终的json格式： [  {"provice":"黑龙江","cities":["齐齐哈尔","七台河","哈尔滨"]},
 *                     {"provice":"湖南","cities":["长沙","湘潭","衡阳","株洲"]}   ]
 * @author Smileyan
 */
public class ProvinceCityUtil {
    /**
     * 根据city中的province进行操作
     * @param list
     * @return
     */
    public static  List<ProvinceCity> listProvinceCity(List<City> list) {
        /**
         * Set用来存储省份，确保省份不重复添加
         * HashMap用来存储所有数据
         */
        Map<String,Object> hashMap  = new HashMap<>();
        Set<String> hashSet = new HashSet<>();
        for(int i=0; i<list.size(); i++) {
            // 获得省名，和city名
            String pro = list.get(i).getProvince();
            String city = list.get(i).getCity();

            /**
             * 如果没有添加过这个省份
             *   需要创建list并把数据添加其中
             * 如果已添加这个省份
             *   需要获得对应的list,然后进行Add操作
             */
            if(hashSet.contains(pro) == false) {
                hashSet.add(pro);
                List<String> cities = new LinkedList<>();
                cities.add(city);
                hashMap.put(pro,cities);
            }else {
                List<String> cities = ((LinkedList)hashMap.get(pro));
                cities.add(city);
            }
        }

        List<ProvinceCity> listProvinceCity = new LinkedList<>();
        Iterator<Map.Entry<String, Object>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            ProvinceCity provinceCity = new ProvinceCity();
            Map.Entry<String, Object> next = iterator.next();
            provinceCity.setCities((LinkedList<String>) next.getValue());
            provinceCity.setProvince(next.getKey());
            listProvinceCity.add(provinceCity);
        }


        return listProvinceCity;
    }

}
