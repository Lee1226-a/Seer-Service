package seer.seerservice.utils;

import java.lang.management.ManagementPermission;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("we","1");
        map.put("ag","2");
        map.put("qg","3");
        Set<String> keys = map.keySet();
        System.out.println(keys);
    }
}
