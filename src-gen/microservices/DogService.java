/**
 * Generated by MicroLang
 */
package microservices;

public interface DogService {
	
	String HOST = "192.168.0.2";
	int PORT = 5001;
	
	int putDog(int dogYears);
	
	String getDog();
	
	int getDog(double legs);
	
}
