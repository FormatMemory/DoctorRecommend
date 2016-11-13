package DoctorRecommendation;

import java.util.Comparator;


/***
 * Doctors Comparator
 * This comparator only take location factor into consideration
 * @author yusheng
 * @param <Doctor>
 */
public class DoctorComparatorLocation implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Doctor d1 = (Doctor)o1;
		Doctor d2 = (Doctor)o2;
		int locationDiff = Math.abs(d1.getLocation().getZipcode() - d2.getLocation().getZipcode()); 
		if(locationDiff <= 200) return 0;//in the same area
		else return locationDiff;
	}
}