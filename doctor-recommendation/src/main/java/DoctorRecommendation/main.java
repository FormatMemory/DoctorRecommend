package DoctorRecommendation;

import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author yusheng
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("           Find Similar Doctors ");
		RecommendDoctor rd = new RecommendDoctor();
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>(); 
		Location l1 = new Location();
		l1.setZipcode(1111);
		Location l2 = new Location();
		l2.setZipcode(2222);
		Location l3 = new Location();
		l3.setZipcode(3333);
		Doctor doc = new Doctor("Dc110", "David0", 35, l1, 3.3, 2);
		doctorList.add(doc);
		System.out.println();
		printDoctorList(" Target Doctor ", doctorList);
		doctorList.add(new Doctor("Dc111", "David1", 18, l1, 3.5, 2));
		doctorList.add(new Doctor("Dc112", "David2", 28, l2, 3.0, 1));
		doctorList.add(new Doctor("Dc113", "David3", 23, l3, 4.1, 8));
		doctorList.add(new Doctor("Dc114", "Davie4", 54, l2, 5.0, 10));
		doctorList.add(new Doctor("Dc115", "Davie5", 65, l3, 0.0, 6));
		doctorList.add(new Doctor("Dc116", "Davie6", 99, l2, 1.4, 2));
		doctorList.add(new Doctor("Dc117", "Davie7", 46, l2, 3.77, 4));
		doctorList.add(new Doctor("Dc118", "Davie8", 35, l3, 2.4, 3));
		doctorList.add(new Doctor("Dc119", "Davie9", 54, l1, 3.2, 6));
		doctorList.add(new Doctor("Dc120", "Davie10", 29, l1, 3.5, 2));
		rd.addAll(doctorList);
		System.out.println();
		printDoctorList(" Add Doctors ", doctorList);
		System.out.println();
		printDoctorList(" Similar Doctors ",  rd.get_K_SimilarDoctor(doc, 3, rd.doctorSet));
	}
	
	private static void printDoctorList(String title, ArrayList<Doctor> list){
		System.out.println("-=-=-=-=-=-=-=-=-="+title+"=-=-=-=-=-=-=-=-=-=");
		for(Doctor dc : list){
			System.out.println("ID: " + dc.getID_Number()+", Name: " + dc.getName() + ", "
					+ " ReviewScore: " + dc.getReviewScore()+", "
					+ " Location: " + dc.getLocation().getZipcode()+ ", "
					+ " Category:" + dc.getCategory());
		}
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
	}

}
