/**
 * Generated by MicroLang
 */
package microservices;

public interface DogService {
	
	String HOST = "192.168.0.2";
	int PORT = 5001;
	
	int postDog(int dogYears);
	
	String getDog();
	
}
