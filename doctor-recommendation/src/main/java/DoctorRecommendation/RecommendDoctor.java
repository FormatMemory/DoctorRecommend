package DoctorRecommendation;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * This class in charge of finding doctor's k similar of doctors
 * @author yusheng
 */
public class RecommendDoctor {
	public static TreeSet<Doctor> doctorSet;
	public RecommendDoctor(){
		/***
		 *we can choose different comparators with use different methods to compare Doctors,
		 *we can also use different TreeSet(s) to save them at the same time if needed 
		 *		--> provide multiple ways of recommendation but need more space and time cost
		 *After my testing, the single factor comparators may need more adjustment due to their performance are not very good
		***/
		//doctorSet = new TreeSet<Doctor>(new DoctorComparatorLocation());
		//doctorSet = new TreeSet<Doctor>(new DoctorComparatorScore());
		doctorSet = new TreeSet<Doctor>(new DoctorComparator());
		
	}
	
	/**
	 * Add/Update doctor in TreeSet 
	 * @param doc
	 */
	public void setDoctor(Doctor doc){
		//check doc is right
		if(!this.doctorSet.contains(doc)){
			this.doctorSet.add(doc);//already there
		}else{
			//remove the old one and add the new one,
			//just incase only ID_Number is the same 
			//(equal and hash function has been overrided for Doctor class).
			doctorSet.remove(doc);
			doctorSet.add(doc);
		}
		
	}
	/***
	 * Remove a doctor from TreeSet according to his/her ID number
	 * @param doc
	 */
	public void delDoctor(String ID){
		//hash function and equal function in TreeSet has been rewrote,
		//the same id indicates one doctor
		Doctor doc = new Doctor(ID);
		if(doctorSet.contains(doc)){
			doctorSet.remove(doc);
		}
	}
	
	/**
	 * Add all doctors information into TreeSet
	 * @param doctorList
	 */
	public void addAll(ArrayList<Doctor> doctorList){
		for(Doctor doc:doctorList){
			this.setDoctor(doc);
		}
	}
	
	/**
	 *Find input doc's k nearest doctors from trSet
	 *@param trSet: TreeSet contains all doctors, 
	 *		 k: number of doctors needed in return list, 
	 *       doc: input target doctor
	 *@return ArrayList<Doctor>
	 **/
	public ArrayList<Doctor> get_K_SimilarDoctor(Doctor doc, int k, TreeSet<Doctor> trSet){
		ArrayList<Doctor> ret = new ArrayList<Doctor>();
		if(doc == null || k <= 0) return ret;
		Doctor hCur = doc;
		if(trSet.size() <= k){
			ret.addAll(trSet);
		}else{
			/**
			 * add doctors in trSet near input doc
			 * higher k/2, lower k-k/2 
			 * 	if higher/lower doctor number < k/2, use the other side to add into ret list
			 */

			while(hCur!= null && trSet.higher(hCur) != null && ret.size() < k/2){
				hCur = trSet.higher(hCur);
				if(ret.contains(hCur)|| hCur==null){
					break;
				}
				ret.add(hCur);
			}
			Doctor lCur = doc;
			while(lCur != null && trSet.lower(lCur) != null && ret.size() < k){
				lCur = trSet.lower(lCur);
				if(ret.contains(lCur)|| hCur==null){
					break;
				}
				ret.add(lCur);
			}
			while(hCur!= null && ret.size() < k){
				hCur = trSet.higher(hCur);
				if(ret.contains(hCur) || hCur==null){
					break;
				}
				ret.add(hCur);
			}
		}
		return ret;
	}
	
}

