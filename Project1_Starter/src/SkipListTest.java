import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class SkipListTest {

	private static SkipList<String, Integer> nameAge;
	private static SkipList<String, Double> nameSalary;
	private static Iterator<KVPair<String, Integer>> nameAgeIt;
	private static Iterator<KVPair<String, Double>> nameSalaryIt;
	private static KVPair<String, Integer> personData1;
	private static KVPair<String, Double> personData2;
	
	@BeforeAll
	public static void initializingTest() {
		nameAge = new SkipList<String, Integer>();
		nameSalary = new SkipList<String, Double>();
		nameAgeIt = nameAge.iterator();
		nameSalaryIt = nameSalary.iterator();
		assertEquals(0, nameAge.size());
		assertEquals(0, nameSalary.size());
		assertFalse(nameAgeIt.hasNext());
		assertFalse(nameSalaryIt.hasNext());
		assertNull(nameAgeIt.next());
		assertNull(nameSalaryIt.next());
	}
	
	@AfterEach
	public void sortingTest() {
		
		int nameAgeSize = 0;
		int nameSalarySize = 0;
		nameAgeIt = nameAge.iterator();
		nameSalaryIt = nameSalary.iterator();
		
		while(nameAgeIt.hasNext()) {
			nameAgeSize++;
			nameAgeIt.next();
		}
		while(nameSalaryIt.hasNext()) {
			nameSalarySize++;
			nameSalaryIt.next();
		}
		
		assertEquals(nameAgeSize, nameAge.size());
		assertEquals(nameSalarySize, nameSalary.size());
		
		String[] nameAgeKeys = new String[nameAgeSize];
		String[] nameSalaryKeys = new String[nameSalarySize];
		nameAgeIt = nameAge.iterator();
		nameSalaryIt = nameSalary.iterator();
		int idx = 0;
		
		while(nameAgeIt.hasNext()) {
			personData1 = nameAgeIt.next();
			nameAgeKeys[idx] = personData1.getKey();
			idx++;
		}
		idx = 0;
		while(nameSalaryIt.hasNext()) {
			personData2 = nameSalaryIt.next();
			nameSalaryKeys[idx] = personData2.getKey();
			idx++;
		}
		
		String[] tempArray1 = new String[nameAgeKeys.length];
		String[] tempArray2 = new String[nameSalaryKeys.length];
		
		for(int i = 0; i < nameAgeKeys.length; i++) {
			tempArray1[i] = nameAgeKeys[i];
		}
		for(int i = 0; i < nameSalaryKeys.length; i++) {
			tempArray2[i] = nameSalaryKeys[i];
		}
		
		Arrays.sort(tempArray1);
		Arrays.sort(tempArray2);
		
		assertArrayEquals(tempArray1, nameAgeKeys);
		assertArrayEquals(tempArray2, nameSalaryKeys);
		
		//System.out.println("//////////Test State//////////");
		//System.out.println("Name-Age SkipList:");
		//nameAge.dump();
		//System.out.println();
		
		//System.out.println("Name-Salary SkipList:");
		//nameSalary.dump();
		//System.out.println();
	}
	
	@Test
	public void InsertingTest01() {
		personData1 = new KVPair<String, Integer>("Bob", 27);
		personData2 = new KVPair<String, Double>("Bob", 2030.22);
		
		nameAge.insert(personData1);
		nameSalary.insert(personData2);
		
		assertEquals(1, nameAge.size());
		assertEquals(1, nameSalary.size());
	}
	
	@Test
	public void InsertingTest02() {
		personData1 = new KVPair<String, Integer>("Alice", 25);
		personData2 = new KVPair<String, Double>("Alice", 4050.88);
		
		nameAge.insert(personData1);
		nameSalary.insert(personData2);
		
		assertEquals(2, nameAge.size());
		assertEquals(2, nameAge.size());
	}
	
	@Test
	public void InsertingTest03() {
		personData1 = new KVPair<String, Integer>("Mike", 19);
		personData2 = new KVPair<String, Double>("Mike", 1823.35);
		
		nameAge.insert(personData1);
		nameSalary.insert(personData2);
		
		assertEquals(3, nameAge.size());
		assertEquals(3, nameAge.size());
	}
	
	@Test
	public void InsertingTest04() {
		personData1 = new KVPair<String, Integer>("Bob", 27);
		personData2 = new KVPair<String, Double>("Bob", 2030.22);
		
		nameAge.insert(personData1);
		nameSalary.insert(personData2);
		
		assertEquals(4, nameAge.size());
		assertEquals(4, nameSalary.size());
	}
	
	@Test
	public void InsertingTest05() {
		personData1 = new KVPair<String, Integer>("Alice", 25);
		personData2 = new KVPair<String, Double>("Alice", 4050.88);
		
		nameAge.insert(personData1);
		nameSalary.insert(personData2);
		
		assertEquals(5, nameAge.size());
		assertEquals(5, nameAge.size());
	}
	
	@Test
	public void InsertingTest06() {
		personData1 = new KVPair<String, Integer>("Mike", 19);
		personData2 = new KVPair<String, Double>("Mike", 1823.35);
		
		nameAge.insert(personData1);
		nameSalary.insert(personData2);
		
		assertEquals(6, nameAge.size());
		assertEquals(6, nameAge.size());
	}
	
	@Test
	public void InsertingTest07() {
		personData1 = new KVPair<String, Integer>("Bob", 17);
		personData2 = new KVPair<String, Double>("Bob", 1020.11);
		
		nameAge.insert(personData1);
		nameSalary.insert(personData2);
		
		assertEquals(7, nameAge.size());
		assertEquals(7, nameSalary.size());
	}
	
	@Test
	public void InsertingTest08() {
		nameAge.insert(null);
		nameSalary.insert(null);
		
		assertEquals(7, nameAge.size());
		assertEquals(7, nameSalary.size());
	}
	
	@Test
	public void SearchingTest01() {
		ArrayList<KVPair<String, Integer>> searchArray1 = nameAge.search("Mikke");
		ArrayList<KVPair<String, Double>> searchArray2 = nameSalary.search("Mike");
		
		assertTrue(searchArray1.size() == 0);
		assertTrue(searchArray2.size() != 0);
	}
	
	@Test
	public void SearchingTest02() {
		ArrayList<KVPair<String, Integer>> searchArray1 = nameAge.search("Mike");
		ArrayList<KVPair<String, Double>> searchArray2 = nameSalary.search("Mik");
		
		assertTrue(searchArray1.size() != 0);
		assertTrue(searchArray2.size() == 0);
	}
	
	@Test
	public void SearchingTest03() {
		ArrayList<KVPair<String, Integer>> searchArray1 = nameAge.search("Bob");
		ArrayList<KVPair<String, Double>> searchArray2 = nameSalary.search("Alice");
		
		assertTrue(searchArray1.size() != 0);
		assertTrue(searchArray2.size() != 0);
	}
	
	@Test
	public void SearchingTest04() {
		ArrayList<KVPair<String, Integer>> searchArray1 = nameAge.search("Alan");
		ArrayList<KVPair<String, Double>> searchArray2 = nameSalary.search("Dani");
		
		assertTrue(searchArray1.size() == 0);
		assertTrue(searchArray2.size() == 0);
	}
	
	@Test
	public void SearchingTest05() {
		ArrayList<KVPair<String, Integer>> searchArray1 = nameAge.search(null);
		ArrayList<KVPair<String, Double>> searchArray2 = nameSalary.search(null);
		
		assertTrue(searchArray1.size() == 0);
		assertTrue(searchArray2.size() == 0);
	}
	
	@Test
	public void RemovingTest01() {
		personData1 = nameAge.remove("Alan");
		personData2 = nameSalary.remove("Dani");
		
		assertNull(personData1);
		assertNull(personData2);
		
		assertEquals(7, nameAge.size());
		assertEquals(7, nameSalary.size());
	}
	
	@Test
	public void RemovingTest02() {
		personData1 = nameAge.remove("Bob");
		personData2 = nameSalary.remove("Dani");
		
		assertNotNull(personData1);
		assertNull(personData2);
		
		assertEquals(6, nameAge.size());
		assertEquals(7, nameSalary.size());
	}
	
	@Test
	public void RemovingTest03() {
		personData1 = nameAge.remove("Alan");
		personData2 = nameSalary.remove("Alice");
		
		assertNull(personData1);
		assertNotNull(personData2);
		
		assertEquals(6, nameAge.size());
		assertEquals(6, nameSalary.size());
	}
	
	@Test
	public void RemovingTest04() {
		personData1 = nameAge.remove("Mike");
		personData2 = nameSalary.remove("Mike");
		
		assertNotNull(personData1);
		assertNotNull(personData2);
		
		assertEquals(5, nameAge.size());
		assertEquals(5, nameSalary.size());
	}
	
	@Test
	public void RemovingTest05() {
		personData1 = nameAge.remove(null);
		personData2 = nameSalary.remove(null);
		
		assertNull(personData1);
		assertNull(personData2);
		
		assertEquals(5, nameAge.size());
		assertEquals(5, nameSalary.size());
	}
	
	@Test
	public void RemovingTest06() {
		personData1 = nameAge.removeByValue(27);
		personData2 = nameSalary.removeByValue(2030.22);
		
		assertNotNull(personData1);
		assertNotNull(personData2);
		
		assertEquals(4, nameAge.size());
		assertEquals(4, nameSalary.size());
	}
	
	@Test
	public void RemovingTest07() {
		personData1 = nameAge.removeByValue(30);
		personData2 = nameSalary.removeByValue(1020.0);
		
		assertNull(personData1);
		assertNull(personData2);
		
		assertEquals(4, nameAge.size());
		assertEquals(4, nameSalary.size());
	}
	
	@Test
	public void RemovingTest08() {
		personData1 = nameAge.removeByValue(19);
		personData2 = nameSalary.removeByValue(13023.0);
		
		assertNotNull(personData1);
		assertNull(personData2);
		
		assertEquals(3, nameAge.size());
		assertEquals(4, nameSalary.size());
	}
	
	@Test
	public void RemovingTest09() {
		personData1 = nameAge.removeByValue(55);
		personData2 = nameSalary.removeByValue(1823.35);
		
		assertNull(personData1);
		assertNotNull(personData2);
		
		assertEquals(3, nameAge.size());
		assertEquals(3, nameSalary.size());
	}
	
	@Test
	public void RemovingTest10() {
		personData1 = nameAge.removeByValue(null);
		personData2 = nameSalary.removeByValue(null);
		
		assertNull(personData1);
		assertNull(personData2);
		
		assertEquals(3, nameAge.size());
		assertEquals(3, nameSalary.size());
	}
	
	@Test
	public void RemovingTest11() {
		personData1 = nameAge.remove("Alice");
		personData2 = nameSalary.remove("Alice");
		
		assertNotNull(personData1);
		assertNotNull(personData2);
		
		assertEquals(2, nameAge.size());
		assertEquals(2, nameSalary.size());
	}
	
	@Test
	public void RemovingTest12() {
		personData1 = nameAge.removeByValue(25);
		personData2 = nameSalary.removeByValue(1020.11);
		
		assertNotNull(personData1);
		assertNotNull(personData2);
		
		assertEquals(1, nameAge.size());
		assertEquals(1, nameSalary.size());
	}
	
	@Test
	public void RemovingTest13() {
		personData1 = nameAge.remove("Bob");
		personData2 = nameSalary.remove("Bob");
		
		assertNotNull(personData1);
		assertNotNull(personData2);
		
		assertEquals(0, nameAge.size());
		assertEquals(0, nameSalary.size());
	}
	
	@Test
	public void RemovingTest14() {
		personData1 = nameAge.remove("Bob");
		personData2 = nameSalary.remove("Alice");
		
		assertNull(personData1);
		assertNull(personData2);
		
		assertEquals(0, nameAge.size());
		assertEquals(0, nameSalary.size());
	}
	
	@Test
	public void RemovingTest15() {
		personData1 = nameAge.remove("Mike");
		personData2 = nameSalary.remove("Mike");
		
		assertNull(personData1);
		assertNull(personData2);
		
		assertEquals(0, nameAge.size());
		assertEquals(0, nameSalary.size());
	}
	
	@Test
	public void generatorTest() {
		
		ArrayList<String> names1 = new ArrayList<String>();
		ArrayList<String> names2 = new ArrayList<String>();
		ArrayList<Integer> ages = new ArrayList<Integer>();
		ArrayList<Double> salaries = new ArrayList<Double>();
		
		for(int i = 1; i <= 10000; i++) {
			
			int randomNumber = (int)(Math.random() * 100) % 5;
			String name = Helper.generateRandomName(2);
			int age = (int)(Math.random() * 10);
			double salary = Double.parseDouble(String.format("%.1f", (Math.random() * 10)));
			
			if(randomNumber == 0) {
				personData1 = new KVPair<String, Integer>(name, age);
				personData2 = new KVPair<String, Double>(name, salary);
				
				names1.add(name);
				names2.add(name);
				ages.add(age);
				salaries.add(salary);
				
				nameAge.insert(personData1);
				nameSalary.insert(personData2);
				
				assertEquals(names1.size(), nameAge.size());
				assertEquals(names2.size(), nameSalary.size());
				assertEquals(ages.size(), nameAge.size());
				assertEquals(salaries.size(), nameSalary.size());
			}
			else if(randomNumber == 1) {
				ArrayList<KVPair<String, Integer>> searchArray1 = nameAge.search(name);
				ArrayList<KVPair<String, Double>> searchArray2 = nameSalary.search(name);
				
				if(names1.contains(name)) {
					assertTrue(searchArray1.size() != 0);
					for(int j = 0; j < searchArray1.size(); j++) {
						assertEquals(name, searchArray1.get(j).getKey());
					}
				}
				else {
					assertFalse(searchArray1.size() != 0);
				}
				
				if(names2.contains(name)) {
					assertTrue(searchArray2.size() != 0);
					for(int j = 0; j < searchArray2.size(); j++) {
						assertEquals(name, searchArray2.get(j).getKey());
					}
				}
				else {
					assertFalse(searchArray2.size() != 0);
				}
				
			}
			else if(randomNumber == 2) {
				personData1 = nameAge.remove(name);
				personData2 = nameSalary.remove(name);
				
				if(names1.contains(name)) {
					assertNotNull(personData1);
					assertEquals(name, personData1.getKey());
					assertTrue(ages.contains(personData1.getValue()));
					names1.remove(name);
					ages.remove(Integer.valueOf(personData1.getValue()));
					assertEquals(names1.size(), nameAge.size());
					assertEquals(ages.size(), nameAge.size());
				}
				else {
					assertNull(personData1);
					assertEquals(names1.size(), nameAge.size());
					assertEquals(ages.size(), nameAge.size());
				}
				
				if(names2.contains(name)) {
					assertNotNull(personData2);
					assertEquals(name, personData2.getKey());
					assertTrue(salaries.contains(personData2.getValue()));
					names2.remove(name);
					salaries.remove(personData2.getValue());
					assertEquals(names2.size(), nameSalary.size());
					assertEquals(salaries.size(), nameSalary.size());
				}
				else {
					assertNull(personData2);
					assertEquals(names2.size(), nameSalary.size());
					assertEquals(salaries.size(), nameSalary.size());
				}
				
			}
			else if(randomNumber == 3) {
				personData1 = nameAge.removeByValue(age);
				personData2 = nameSalary.removeByValue(salary);
				
				if(ages.contains(age)) {
					assertNotNull(personData1);
					assertEquals(age, personData1.getValue());
					assertTrue(names1.contains(personData1.getKey()));
					names1.remove(personData1.getKey());
					ages.remove(Integer.valueOf(age));
					assertEquals(names1.size(), nameAge.size());
					assertEquals(ages.size(), nameAge.size());
				}
				else {
					assertNull(personData1);
					assertEquals(names1.size(), nameAge.size());
					assertEquals(ages.size(), nameAge.size());
				}
				
				if(salaries.contains(salary)) {
					assertNotNull(personData2);
					assertEquals(salary, personData2.getValue());
					assertTrue(names2.contains(personData2.getKey()));
					names2.remove(personData2.getKey());
					salaries.remove(salary);
					assertEquals(names2.size(), nameSalary.size());
					assertEquals(salaries.size(), nameSalary.size());
				}
				else {
					assertNull(personData2);
					assertEquals(names2.size(), nameSalary.size());
					assertEquals(salaries.size(), nameSalary.size());
				}
				
			}
			else if(randomNumber == 4) {
				System.out.println("//////////Generator Test//////////");
				nameAge.dump();
				System.out.println();
				nameSalary.dump();
				System.out.println();
				assertEquals(names1.size(), nameAge.size());
				assertEquals(names2.size(), nameSalary.size());
				assertEquals(ages.size(), nameAge.size());
				assertEquals(salaries.size(), nameSalary.size());
			}
			sortingTest();
		}
		nameAge = new SkipList<String, Integer>();
		nameSalary = new SkipList<String, Double>();
	}
	
	@AfterAll
	@Timeout(10)
	public static void TimeComplexityTest() {
		for(int i = 1; i <= 1000000; i++) {
			String name = Helper.generateRandomName(5);
			int age = (int)(Math.random() * 100);
			double salary = Math.random() * 10000.0;
			personData1 = new KVPair<String, Integer>(name, age);
			personData2 = new KVPair<String, Double>(name, salary);
			nameAge.insert(personData1);
			nameSalary.insert(personData2);
		}
	}
}
