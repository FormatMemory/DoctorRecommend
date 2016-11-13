package DoctorRecommendation;

import java.util.Comparator;

/***
 * This comparator take location, reviewScore, location(now is zipcode)
 * category, language into consideration
 * the weight number of different difference for calculating ret value can be changed.
 * @author yusheng
 * @param <Doctor>
 */
public class DoctorComparator implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Doctor d1 = (Doctor)o1;
		Doctor d2 = (Doctor)o2;
		if(d1.equals(d2)) return 0;
		double ageDiff = d1.getAge() - d2.getAge();
		double scoreDiff = (d1.getReviewScore() - d2.getReviewScore()) > 1 ? 1 : 0; //review score 
		double locationDiff = d1.getLocation().getZipcode() - d2.getLocation().getZipcode() > 500 ? -1 : 0; //in the same area
		int languageDiff = d1.getLanguage() == d2.getLanguage() ? 0 : -1; // speak the same language
		int categoryDiff = d1.getCategory() == d2.getCategory() ? 0 : -1; // in the same categorys(skills)
		
		int ret = (ageDiff/25 + scoreDiff + locationDiff + languageDiff + categoryDiff) > 0 ? 1:-1;
		return ret;
	}
}