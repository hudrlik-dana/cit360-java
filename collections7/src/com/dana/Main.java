package com.dana;

import java.util.*;

public class Main {

    public static void main(String[] args) {

// *** create empty HashSet - testInventory1
        // determine what elements are in the testInventory1
        // remove element from testInventory1
        Set<String> testInventory1 = new HashSet<>();

        // add elements
        testInventory1.add("Gloves");
        testInventory1.add("Snow Blower");
        testInventory1.add("Shovel");
        testInventory1.add("Ice Melt");

        // print current testInventory1
        System.out.println("Current inventory includes: ");
        System.out.println(testInventory1);

        // check contents for specific item
        System.out.println("\nDoes the inventory contain 'Gloves'? " + testInventory1.contains("Gloves"));
        System.out.println("Does the inventory contain 'Mittens'? " + testInventory1.contains("Mittens"));

        // remove Snow Blower
        testInventory1.remove("Snow Blower");
        // check current contents testInventory1
        System.out.println("\ntestInventory1 now includes: " + testInventory1);

// *** create empty SortedSet TreeSet - testInventory2
        // check if testInventory1 and testInventory2 contain the same elements
        // create an array from testInventory2 elements
        SortedSet<String> testInventory2 = new TreeSet<>();

        // copy elements in testInventory1 into testInventory2
        testInventory2.addAll(testInventory1);

        System.out.println("\nCreated a copy of testInventory1 named testInventory2");
        System.out.println("testInventory2 includes: " + testInventory2);

        // compare testInventory1 with testInventory2
        boolean value = testInventory1.equals(testInventory2);
        // check contents for all items
        System.out.println("\nDoes testInventory1 hold the same items as testInventory2? " + value);

        // copy all elements from testInventory2 into an ArrayList
        Object[] testInventoryArray = testInventory2.toArray();

        // print testInventoryArray
        System.out.println("\nTreeSet testInventory2 is now an Array testInventoryArray ");
        // iterate using a for loop
        int i;
        for (i = 0; i < testInventoryArray.length; i++) {
            System.out.println(testInventoryArray[i]);
        }

// *** create an ArrayList named testInventory3 from the HashSet testInventory2
        // use listiterator to traverse the list forward and backward
        ArrayList<String> testInventory3 = new ArrayList<>(testInventory2);

        System.out.println("\ntestInventory3 contains: " + testInventory3);

        // add more items to testInventory3
        testInventory3.add("Jackets");
        testInventory3.add("Boots");
        testInventory3.add("Snow Thrower");

        // check current contents of testInventory3
        System.out.println("\ntestInventory3 now contains: " + testInventory3);

        // create the list iterator
        ListIterator<String> iterator = testInventory3.listIterator();

        // traversing elements forward
        System.out.println("\nTraversing elements forward: ");
        // iterate through list forward using while loop
        while (iterator.hasNext()) {
            System.out.println("index: " + iterator.nextIndex() + " value: " + iterator.next());
        }

        // traversing elements backward
        System.out.println("\nTraversing elements backwards: ");
        // iterate through list backward using while loop
        while (iterator.hasPrevious()) {
            System.out.println("index: " + iterator.previousIndex() + " value: " + iterator.previous());
        }

// *** create a PriorityQueue from testInventory3
        PriorityQueue<String> testInventory4 = new PriorityQueue<String>(testInventory3);
        // check contents of testInventory4
        System.out.println("\ntestInventory4 is a PriorityQueue and contains: " + testInventory4);

        // remove head of the queue 'Boots'
        String removeHead = testInventory4.remove();
        // check modified contents of testInventory4
        System.out.println("\ntestInventory4 has lost it's 'Boots' " + testInventory4);

        // view the head of the queue 'Gloves'
        String head = testInventory4.peek();
        // check the head of testInventory4
        System.out.println("\ntestInventory4 has a new head " + head + " " + testInventory4);

        // check the size of the queue
        int size = testInventory4.size();
        // print the size of testInventory4
        System.out.println("\ntestInventory4 holds " + testInventory4.size() + " items");

        // check if PriorityQueue contains 'Boots'
        boolean checkItems = testInventory4.contains("Boots");
        // print validation of checkItems
        System.out.println("\nDoes testInventory4 contain Boots? " + checkItems);

        // insert 'Boots' into testInventory4
        testInventory4.offer("Boots");
        // print modified contents of testInventory4
        System.out.println("\ntestInventory4 contains " + testInventory4 + " totalling " + testInventory4.size() + " items");

        // loop through testInventory4
        for (i = 0; i < testInventory4.size(); i++)
            // if testInventory4 is not null remove the queue head item
            if (testInventory4 != null) {
                System.out.println("removing : " + testInventory4.poll());
            } else {
                System.out.println("testInventory4 is empty");
            }
        // print modified testInventory4
        System.out.println("\ntestInventory4 now contains " + testInventory4);

// Create Dequeue LinkedList from testInventory4
        // create empty Deque
        Deque<String> testInventory5 = new LinkedList<String>(testInventory4);

        // add elements to (position)
        testInventory5.addFirst("Boots (head)");
        testInventory5.add("Gloves (tail)");
        testInventory5.addLast("Ice Melt (tail)");
        testInventory5.offerFirst("Sleds (head)");
        testInventory5.offer("Fresh Snow (tail)");
        testInventory5.offerLast("Snow Blower (tail)");
        testInventory5.push("Beanies (head)");

        // check contents of Deque LinkedList
        System.out.println(testInventory5 + "\n");

        // iterate forward
        System.out.println("\ntestInventory5 front to back: ");
        // iterate through queue using while loop
        Iterator iterator1 = testInventory5.iterator();
        while (iterator1.hasNext())
            // print update
            System.out.println("\t" + iterator1.next());

        // iterate in reverse order
        System.out.println("\ntestInventory5 back to front: ");
        // iterate through queue using while loop)
        Iterator reverse2 = testInventory5.descendingIterator();
        while (reverse2.hasNext())
            System.out.println("\t" + reverse2.next());

        // peek returns the head, without deleting it from queue
        // returns null if queue is empty
        System.out.println("\npeek " + testInventory5.peek());
        System.out.println("after peek: " + testInventory5);

        // pop returns the head, and removes it from the deque
        System.out.println("\npop " + testInventory5.pop());
        // print update
        System.out.println("after pop: " + testInventory5);

        // check if a specific element exists in deque
        System.out.println("\ncontains element 3: " + testInventory5.contains("Fresh Snow (tail)"));

        // remove the first element
        testInventory5.removeFirst();
        // remove the last element
        testInventory5.removeLast();
        // print update
        System.out.println("\ndeque after removing " + "first and last: " + testInventory5);

    }
}
// *** create a TreeMap of inventory items
    class TreeMapPrintInventory {
        public static void main(String[] args) {

            // create empty TreeMap
            TreeMap<String, Integer> inventoryItems = new TreeMap<String, Integer>();

            // enter data
            inventoryItems.put("Boots", 10);
            inventoryItems.put("Gloves", 20);
            inventoryItems.put("Snow Shovels", 4);
            inventoryItems.put("Snow Blowers", 2);
            inventoryItems.put("Ice Melt", 25);
            inventoryItems.put("Jackets", 5);

            // print heading
            System.out.println("\nInventory Items in alphabetical order: ");

            // iterate through inventoryItems using a for loop
            for(Map.Entry m:inventoryItems.entrySet()) {
                // print map key-value pairs, m = key field
                System.out.println(m.getKey() + "... Qty: " + m.getValue());
            }
        }
    }

// *** create a map and linked list to sort through items by quantity on hand
    class HashMapSortByQuantity {

        // function to sort hashmap by quantity
        public static HashMap<String, Integer> sortItemByQuantity(HashMap<String, Integer> hashmap) {

            // create a LinkedList from elements in the HashMap
            List<Map.Entry<String, Integer>> linkedListFromHashMap = new LinkedList<Map.Entry<String, Integer>>(hashmap.entrySet());

            // sort the LinkedListFromHashMap using an anonymous Comparator
            Collections.sort(linkedListFromHashMap, new Comparator<Map.Entry<String, Integer>>() {
                // compare values by item
                public int compare(Map.Entry<String, Integer> item1, Map.Entry<String, Integer> item2) {
                    return (item1.getValue()).compareTo(item2.getValue());
                }
            });

            // put the data from sorted linkedListFromHashMap into a new HashMap
            HashMap<String, Integer> temporaryLinkedHashMap = new LinkedHashMap<String, Integer>();
            // iterate using a for loop
            for (Map.Entry<String, Integer> quantityItemEntry : linkedListFromHashMap) {
                temporaryLinkedHashMap.put(quantityItemEntry.getKey(), quantityItemEntry.getValue());
            }
            return temporaryLinkedHashMap;
        }

        // code to drive the program
        public static void main(String[] args) {
            // create a second hash map to hold the data to be sorted
            HashMap<String, Integer> secondHashMap2 = new HashMap<String, Integer>();

            // enter data into secondHashMap2
            secondHashMap2.put("Boots", 10);
            secondHashMap2.put("Gloves", 20);
            secondHashMap2.put("Snow Shovels", 4);
            secondHashMap2.put("Snow Blowers", 2);
            secondHashMap2.put("Ice Melt", 25);
            secondHashMap2.put("Jackets", 5);

            // create the final HashMap
            Map<String, Integer> finalHashMap3 = sortItemByQuantity(secondHashMap2);

            // print heading
            System.out.println("\nInventory Items in order of quantity: ");

            // iterate using for loop
            for (Map.Entry<String, Integer> itemsSorted : finalHashMap3.entrySet()) {
                // print update
                System.out.println(itemsSorted.getKey() + "... QTY: " + itemsSorted.getValue());
            }
        }
    }




