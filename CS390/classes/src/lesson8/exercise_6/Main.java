package lesson8.exercise_6;

import java.util.*;

@SuppressWarnings({ "serial", "unused" })
public class Main {

	public static void main(String[] args) {
		List<String> list1 = dataList1();
		List<String> list2 = dataList2();
		List<String> list3 = dataList3();

		// Step 1: Sort each list
		Collections.sort(list1);
		Collections.sort(list2);
		Collections.sort(list3);

		// Step 2: Assemble the sorted lists into a single collection of lists
		List<List<String>> allLists = new ArrayList<>();
		allLists.add(list1);
		allLists.add(list2);
		allLists.add(list3);

		// Step 3: Sort the combined list using a Comparator based on the 0th element
		allLists.sort(Comparator.comparing(list -> list.get(0)));

		// Print the combined list
		for (List<String> list : allLists) {
			System.out.println(list);
		}
	}

	private static List<String> dataList1() {
		return new ArrayList<String>() {
			{
				add("Joe"); add("Bill"); add("Sue");
				add("Rob"); add("Mohammed"); add("Steven");
			}
		};
	}

	private static List<String> dataList2() {
		return new ArrayList<String>() {
			{
				add("Rick"); add("Sally"); add("Tom");
				add("George");
			}
		};
	}

	private static List<String> dataList3() {
		return new ArrayList<String>() {
			{
				add("Talia"); add("Richard"); add("Chloe");
				add("Celine"); add("Zahra"); add("Rod");
				add("Frank");
			}
		};
	}
}
