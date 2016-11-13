package DoctorRecommendation;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorTest {
  @Test
  public void DoctorEqualTest() {
	Location l1 = new Location();
	l1.setZipcode(1111);
	Location l2 = new Location();
	l2.setZipcode(2222);
	Location l3 = new Location();
	l3.setZipcode(3333);
	Doctor d1 = new Doctor("Dc110", "David0", 35, l1, 3.3, 2);
	Doctor d2 = new Doctor("Dc110", "David3", 343, l2, 3.3, 2);
	Doctor d3 = new Doctor("Dc111", "David1", 18, l1, 3.5, 2);

    assertTrue(d1.equals(d1));
	assertTrue(d1.equals(d2)); // same id
	assertFalse(d1.equals(d3)); //different id
  }
  @Test
  public void DoctorHashTest() {
	  Location l1 = new Location();	
	  l1.setZipcode(1111);
	  Location l2 = new Location();
	  l2.setZipcode(2222);
	  Location l3 = new Location();
	  l3.setZipcode(3333);
	  Doctor d1 = new Doctor("Dc110", "David0", 35, l1, 3.3, 2);
	  Doctor d3 = new Doctor("Dc110", "David3", 343, l2, 3.3, 2);
	  Doctor d2 = new Doctor("Dc111", "David1", 18, l1, 3.5, 2);
	
	  assertFalse(d1.hashCode() == d2.hashCode());
	  assertTrue(d1.hashCode() == d3.hashCode());
	  assertTrue(d1.hashCode() == d1.hashCode());
  }  

}