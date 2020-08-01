package binarySearch;

import java.util.*;

class Data{
    int timestamp;
    String value;
    public Data(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}

public class M_981TimeBasedKeyValueStore {
    //solution1 hashmap + TreeMap
    HashMap<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public void TimeMap1() {
        map = new HashMap<>();
    }

    public void set1(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get1(String key, int timestamp) {
        if(!map.containsKey(key)){
            return null;
        }
        TreeMap<Integer, String> temp = map.get(key);
        if(temp.floorKey(timestamp) == null){
            return "";
        }
        return temp.get(temp.floorKey(timestamp));
    }

    //solution2 hashmap + arraylist
    Map<String, List<Data>> map2;
    /** Initialize your data structure here. */
    public void TimeMap() {
        map2 = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map2.putIfAbsent(key, new ArrayList<>());
        Data data = new Data(timestamp, value);
        map2.get(key).add(data);
    }

    public String get(String key, int timestamp) {
        return binarysearch(map2.get(key), timestamp);
    }

    private String binarysearch(List<Data> list, int timestamp){
        System.out.println(list.get(list.size() - 1).timestamp);
        if(list == null){
            return "";
        }
        int start = 0;
        int end = list.size() - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(list.get(mid).timestamp >= timestamp){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(list.get(end).timestamp <= timestamp){
            return list.get(end).value;
        }
        if(list.get(start).timestamp <= timestamp){
            return list.get(start).value;
        }
        return "";
    }
}
