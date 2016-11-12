package DoctorRecommendation;

/**
 * Location Class
 * Save location information
 * @author yusheng
 *
 */
public class Location{
	private String country;
	private String city;
	private String state;
	private int zipcode;
	public String street;
	private double locationNum;
	
	public Location(){
		country = "United States";
		city = "San Francisco";
		state = "CA";
		zipcode = 94101;
		street = "null";
		locationNum = -404;
	}
	public void setLocationNum(){
		/**
		 *  In the future I want to use Google maps' API
		 *	to get the locationNum through  which makes it easier for us to find 
		 *	doctors from the same area;
		 */
		 this.locationNum = 0.0;
		 
	}
	public double getLocationNum(){
		return locationNum;
	}
	

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the county
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param county the county to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipcode
	 */
	public int getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
