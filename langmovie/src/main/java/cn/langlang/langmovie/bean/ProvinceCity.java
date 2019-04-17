package cn.langlang.langmovie.bean;

import java.util.LinkedList;

public class ProvinceCity {
    private String province;
    private LinkedList<String> cities;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public LinkedList<String> getCities() {
        return cities;
    }

    public void setCities(LinkedList<String> cities) {
        this.cities = cities;
    }


}
