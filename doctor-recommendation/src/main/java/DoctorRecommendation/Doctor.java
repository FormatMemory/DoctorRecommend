package DoctorRecommendation;

/**
 * Save one doctor's information
 * Id_Number is the primary key for identify a Doctor
 * @author yusheng
 *
 */
public class Doctor{
	private String ID_Number;
	private String name;
	private int age;
	private Location location;
	private int language; //Assume language has been converted to number
	private double reviewScore;//Assume 0 - 5
	private int category; //Assume category has been converted to number
	
	public Doctor(String id, String name, int age, Location location, double score, int cate){
		this.ID_Number = id;
		this.name = name;
		this.age = age;
		this.location = location;
		this.reviewScore = score;
		this.category = cate;
	}
	
	public Doctor(String id){
		this.ID_Number = id;
		this.name = "None";
		this.age = -1;
		this.location = new Location();
		this.reviewScore = -1;
		this.category = -1;
	}
	/**
	 * If ID_Number is the same then it's the same doctor
	 * @param Doctor doc
	 * @return true: is the same doctor; false: not the same doctor
	 */
	 @Override public boolean equals(Object other) {
		    boolean result = false;
		    if (other instanceof Doctor) {
		    	Doctor that = (Doctor) other;
		        result = this.ID_Number.equals(that.ID_Number);
		    }
		    return result;
	}
	/**
	 * HashMap, Set, TreeMap, etc. use hashcode to compare
	 * Need the same hashcode when using eg. treemap.contains(doc) 
	 */
    @Override public int hashCode() {
        //return this.ID_Number.hashCode();
    	int hash = 7;
    	for(int i = 0; i < this.ID_Number.length(); i++){
    		hash = hash*31 + this.ID_Number.charAt(i);
    	}
		return hash;
    }
	 
    public String getID_Number(){
    	return this.ID_Number;
    }
    
    public void setID_Number(String id){
    	this.ID_Number = id;
    }
    
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the language
	 */
	public int getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(int language) {
		this.language = language;
	}

	/**
	 * @return the reviewScore
	 */
	public double getReviewScore() {
		return reviewScore;
	}

	/**
	 * @param reviewScore the reviewScore to set
	 */
	public void setReviewScore(double reviewScore) {
		this.reviewScore = reviewScore;
	}

	/**
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}
	

}
