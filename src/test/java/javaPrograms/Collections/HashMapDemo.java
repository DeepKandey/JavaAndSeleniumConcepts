package javaPrograms.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("myName", "Deepak");
		hashMap.put("actor", "Salman");
		hashMap.putIfAbsent("cricketer", "Sachin"); // putIfAbsent added in Java 8
		hashMap.putIfAbsent("player", "Virat");

		// keys in Map are set so we can use method KeySet() to take them in a Set and
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
		System.out.println(hashMap.get("director"));
		System.out.println(hashMap.getOrDefault("director", "No Name")); // getOrDefault added in Java 8
	}
}
