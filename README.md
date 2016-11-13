# Doctor Recommendation

----------------------------------
##Problem To Solve

#####What we have:
 * Some doctors' information.

#####Goal:
 * To find and return a list of similar doctors for one provided doctor.

#####Assumption:
 * The entire directory of doctors fits into memory. 
 * We have all doctors' information in the right format at this point.
  
##How to Run

####Windows: 

*  run``gradlew.bat`` file

####Linux/MacOS: 

* run ``./gradlew build`` to build the whole project. In this process, [gradle](https://github.com/gradle/gradle) would be downloaded into this folder, no installation needed though. Tests will run at the same time. 

* Then run ``./gradlew run`` will run the project with sample inputs.

##Logic 
Create a ```Doctor``` class for saving doctors' information

Save all doctors objects into a TreeSet and define the comparator for this TreeSet.

How to define the comparator will influence the accuracy of doctor recommendation.

The reason I use *TreeSet* to save doctors information is because I assume we will do *```find K Similar Doctors```* action very frequently. And TreeSet is ```red-black tree```'s java implementation, we can easily find a doctor in *log(n)* time and then access it's neighbors(similar doctors) in constant time (after finding that doctor). And every time we want to update this TreeSet, the time cost would be *log(n)*. Totally space cost for TreeMap is *O(n)*, which is also very good. 

The comparator here takes ```location```, ```reviewScore```, ```location```(now is zip code), ```category```, ```language``` into consideration. I self-defined some weights for these factors, which might be not very precisely.

I also implemented two other comparators (Review Score, location), however, I found the performance (recommendation accuracy) for these single factor comparators are not very good. I think it is because, for single factor comparator, weight adjustment/normalization is also needed. 

##Future Work/Improvement

If I have more time for this, I would do more in these aspects:

1. Add exception handle for invalid inputs, special cases.  For example, City must be a String type object from a set of City names.
2. For location factor, google Map's API can provide location (x, y) coordinates, which is better than using the zip code in my opinion. 
3. Language,  Category fields should take bilingual and doctors have multiple skills into consideration and saved to a new data structure, for example, a list.
4. If using the same data structure (TreeSet), do more work to adjust weight numbers in the comparator or more ideally we can have a model for calculating the difference between doctors. To make recommendation results more scientifically.
5. Adjust comparator or add new data structure for saving single factors related doctors. However, this may take more space and time cost for every time add/del/update a doctor.
6. Add more unit tests, test cases.


## Environment Requirement 
You need Java 1.7 or higher installed