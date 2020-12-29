package javaPrograms.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

// Have used Collection, List Interface and Collections, ArrayList class
public class ListInterfaceExamples {

    public static void main(String[] args) {

        // Using collection Interface
        Collection<Integer> values = new ArrayList<>();
        values.add(99);
        values.add(90);

        System.out.println("-------Using Collection interface------");
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Using List Interface which extends Collection interface but maintains index
        List<Integer> valuesList = new ArrayList<>();
        valuesList.add(99);
        valuesList.add(90);
        valuesList.add(1, 87);

        System.out.println("--------Using List interface");
        valuesList.forEach(System.out::println);

        Collections.sort(valuesList);  // Sorting list using Collections class

        System.out.println("-------Using List interface after sorting------");
        Iterator<Integer> iteratorList = valuesList.iterator();
        while (iteratorList.hasNext()) {
            System.out.println(iteratorList.next());
        }

        List<String> namesList = new ArrayList<>();
        namesList.add("Deepak");
        namesList.add("Vinoth");
        namesList.add(1, "Amod");
        namesList.add("Amod");
        namesList.add("Pankaj");
        namesList.add("Anny");


        List<String> namesWithoutDuplicates = namesList.stream().distinct().collect(Collectors.toList());
        System.out.println("Removing duplicates using distinct from stream: " + namesWithoutDuplicates);

        // singleton() creates a immutable set over a single specified element.
        // An application of this method is to remove an element from Collections like List and Set.

        namesList.removeAll(Collections.singleton("Amod"));
        System.out.println("Removing Amod from list using singleton(): " + namesList);

        namesList.retainAll(Collections.singleton("Pankaj"));
        System.out.println("Retaining Pankaj from list using singleton(): " + namesList);

        // synchronized list
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<String>());
        synchronizedList.add("Java");
        synchronizedList.add("Javascript");
        synchronizedList.add("Ruby");

        // add remove - no need to use explicit synchronization
        // to fetch/traverse the values from this list -- need to use explicit synchronization

        System.out.println("----SynchronizedList----");
        synchronized (synchronizedList) {
            Iterator<String> it = synchronizedList.iterator();
            while (it.hasNext())
                System.out.println(it.next());
        }

        // copyOnWriteArrayList - class to create synchronized class
        CopyOnWriteArrayList<String> copyOnWriteArrayListSynchronized = new CopyOnWriteArrayList<>();
        copyOnWriteArrayListSynchronized.add("Tom");
        copyOnWriteArrayListSynchronized.add("Steve");
        copyOnWriteArrayListSynchronized.add("Deepak");

        // no need to use explicit synchronization for any operation
        System.out.println("----copyOnWriteArrayListSynchronized----");
        Iterator<String> it = copyOnWriteArrayListSynchronized.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
