package controlWork;

import java.io.File;
import java.util.*;

//просто вывод папок и содержимого
public class FileCommander {
    Map<String, String> mapList = new LinkedHashMap<>();
    CreateTree createTree = new CreateTree();
    //    File dir = new File("E:\\1");
    Map<String, String> mapList2 = new LinkedHashMap<>();


    public static void main(String[] args) {
        FileCommander fileAssert = new FileCommander();
//        Scanner scanner = new Scanner(System.in);
//        File dir = new File(scanner.nextLine());
        fileAssert.go();
        fileAssert.choice();

    }

    public void go() {
        System.out.println("enter path to directory");
        Scanner scanner = new Scanner(System.in);
        File dir = new File(scanner.nextLine());
        addToMap(dir);
        mapList2.putAll(mapList);
        sorter(mapList);
    }


    public void choice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter choice: \n1.sort a-y\n2.sort y-a\n3.default path\n4.re-enter path\n5.close");
        switch (scanner.nextInt()) {
            case 1:
                Map<String, String> sortedMap1 = sortByValueAB(mapList2);
                printMap(sortedMap1);
                choice();
                break;
            case 2:
                Map<String, String> sortedMap2 = sortByValueBA(mapList2);
                printMap(sortedMap2);
                choice();
                break;
            case 3:
                sorter(mapList);
                choice();
                break;
            case 4:
                go();
                choice();
                break;
            case 5:
                break;
        }
/*        System.out.println("sortAB");
        Map<String, String> sortedMap1 = sortByValueAB(mapList2);
        printMap(sortedMap1);
        System.out.println("sortAB");
        Map<String, String> sortedMap2 = sortByValueBA(mapList2);
        printMap(sortedMap2);*/
    }

    //добавление элементов в мап
    public void addToMap(File dir) {
        //нахождение ключа
        String spliiiit = createTree.printDirectoryTree(dir).toString();
        String delimeter = "[\n]";
        String[] subStr = spliiiit.split(delimeter);
        List<String> listKey = new ArrayList<>();
        Collections.addAll(listKey, subStr);

        //нахождение значения
        String splitVal = createTree.printDirectoryTree(dir).toString();
        String delimeter2 = "[^a-zA-Z0-9.]";
        String[] subStrVal = splitVal.split(delimeter2);
        List<String> listVal = new ArrayList<>();
        Collections.addAll(listVal, subStrVal);
        Iterator<String> iter = listVal.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s == null || s.isEmpty()) {
                iter.remove();
            }
        }
        for (int i = 0; i < listKey.size(); i++) {
            mapList.put(listKey.get(i), listVal.get(i));
        }
    }

    public void sorter(Map<String, String> mapList2) {
        Iterator<Map.Entry<String, String>> enteries = mapList2.entrySet().iterator();
        while (enteries.hasNext()) {
            Map.Entry<String, String> entry = enteries.next();
            System.out.println(entry.getKey());
        }

    }

    private Map<String, String> sortByValueBA(Map<String, String> mapList) {
        // 1. Convert Map to List of Map
        List<Map.Entry<String, String>> list =
                new LinkedList<Map.Entry<String, String>>(mapList.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    private Map<String, String> sortByValueAB(Map<String, String> mapList) {
        // 1. Convert Map to List of Map
        List<Map.Entry<String, String>> list =
                new LinkedList<Map.Entry<String, String>>(mapList.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


    public <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }


}

