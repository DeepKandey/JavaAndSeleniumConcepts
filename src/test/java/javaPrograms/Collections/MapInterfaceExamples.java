package javaPrograms.Collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapInterfaceExamples {

  public static void main(String[] args) {

    Map<String, String> hashMap = new HashMap<>();
    hashMap.put("myName", "Deepak");
    hashMap.put("actor", "Salman");
    hashMap.putIfAbsent("cricketer", "Sachin"); // putIfAbsent added in Java 8
    hashMap.putIfAbsent("player", "Virat");

    // keys in Map are Set so we can use method KeySet() to take them in a Set and
    // iterate to fetch values

    System.out.println("---Iterating using keySet----");
    Set<String> keys = hashMap.keySet();

    for (String key : keys) {
      System.out.println("Key: " + key + " , value: " + hashMap.get(key));
    }

    // In Map, key-Value pair is taken as an entry, so we have interface Entry which
    // comes under Map interface. It will give you set of entries

    System.out.println("---Iterating using entrySet----");
    Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();

    for (Map.Entry<String, String> e : entrySet) {
      System.out.println("Key: " + e.getKey() + " , value: " + e.getValue());
    }

    // Non- existing data in Map
    System.out.println("Value for director: " + hashMap.get("director"));
    System.out.println(
        "Value for director: "
            + hashMap.getOrDefault("director", "Not present")); // getOrDefault added in Java 8

    Map<String, String> hashMap1 = new HashMap<>();
    hashMap1.put("myName", "Deepak");
    hashMap1.put("actor", "Salman");
    hashMap1.putIfAbsent("cricketer", "Sachin"); // putIfAbsent added in Java 8
    hashMap1.putIfAbsent("player", "Virat");

    // -- Map comparison--

    // compare on the basis of key-value
    System.out.println("Map comparison on the basis of key-value: " + hashMap.equals(hashMap1));
    // compare on the basis of keySet
    System.out.println(
        "Map comparison on the basis of keySet: " + hashMap.keySet().equals(hashMap1.keySet()));

    Map<String, String> hashMap2 = new HashMap<>();
    hashMap2.put("myName", "Deepak");
    hashMap2.put("actor", "Salman");
    hashMap2.putIfAbsent("cricketer", "Sachin"); // putIfAbsent added in Java 8
    hashMap2.putIfAbsent("player", "Virat");
    hashMap2.putIfAbsent("villain", "Amrish");

    // combine the keys from both the maps: using HashSet
    HashSet<String> combineKeys = new HashSet<>(hashMap1.keySet());

    combineKeys.addAll(hashMap2.keySet()); // add the keySet from hashMap2
    combineKeys.removeAll(hashMap1.keySet()); // remove the keySet from hashMap1
    System.out.println("extra key in hashMap2: " + combineKeys);

    // compare maps by values
    HashMap<Integer, String> map1 = new HashMap<>();
    map1.put(1, "A");
    map1.put(2, "B");
    map1.put(3, "C");

    HashMap<Integer, String> map2 = new HashMap<>();
    map2.put(4, "A");
    map2.put(5, "B");
    map2.put(6, "C");
    map2.put(7, "C");

    HashMap<Integer, String> map3 = new HashMap<>();
    map3.put(1, "A");
    map3.put(2, "B");
    map3.put(3, "C");
    map3.put(4, "D");

    // duplicates are allowed
    System.out.println(
        "map1 and map2 values comparison using ArrayList: "
            + new ArrayList<>(map1.values()).equals(new ArrayList<>(map2.values())));
    System.out.println(
        "map1 and map3 values comparison using ArrayList: "
            + new ArrayList<>(map1.values()).equals(new ArrayList<>(map3.values())));

    // duplicates are not allowed
    System.out.println(
        "map1 and map2 values comparison using HashSet: "
            + new HashSet<>(map1.values()).equals(new HashSet<>(map2.values())));

    // ---- synchronized Maps-----

    Map<String, String> map4 = new HashMap<>();
    map4.put("1", "Deepak");
    map4.put("2", "Tom");
    map4.put("3", "Lisa");

    // create synchronizedMap
    Map<String, String> synchronizedMap = Collections.synchronizedMap(map4);
    System.out.println("Synchronized Map using synchronizedMap(): " + synchronizedMap);

    // ConcurrentHashMap
    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    concurrentHashMap.put("A", "Java");
    concurrentHashMap.put("B", "JavaScript");
    concurrentHashMap.put("C", "Python");
    System.out.println("Synchronized Map using ConcurrentHashMap: " + concurrentHashMap);

    // TreeMap - implements NavigableMap interface( extends sortedMap interface). It is naturally
    // ordered.
    TreeMap<Integer, String> treeMap = new TreeMap<>();
    treeMap.put(1000, "Pankaj");
    treeMap.put(4000, "Deepak");
    treeMap.put(3000, "Shubham");
    treeMap.put(5000, "Ankit");

    System.out.println("TreeMap: " + treeMap);
    treeMap.forEach((k, v) -> System.out.println("key=" + k + " value=" + v));

    System.out.println("last key: " + treeMap.lastKey());
    System.out.println("last entry: " + treeMap.lastEntry());

    System.out.println("first key: " + treeMap.firstKey());
    System.out.println("first entry: " + treeMap.firstEntry());

    Set<Integer> keysLessThan3k = treeMap.headMap(3000, false).keySet();
    System.out.println("keys less than 3000: " + keysLessThan3k);

    Set<Integer> keysGreaterThan3k = treeMap.tailMap(3000, false).keySet();
    System.out.println("keys greater than 3000: " + keysGreaterThan3k);
  }
}
