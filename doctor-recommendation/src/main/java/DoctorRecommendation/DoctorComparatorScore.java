package DoctorRecommendation;

import java.util.Comparator;

/***
 * Doctors Comparator
 * This comparator only take review score factor into consideration
 * @author yusheng
 */
public class DoctorComparatorScore implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Doctor d1 = (Doctor)o1;
		Doctor d2 = (Doctor)o2;
		double scoreDiff = d1.getReviewScore() - d2.getReviewScore(); //same score range
		if(Math.abs(scoreDiff) <= 0.5) return 0;
		else{
			return scoreDiff > 0 ? 1 : -1;
		}
	}
}
