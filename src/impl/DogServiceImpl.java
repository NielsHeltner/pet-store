/**
 * Generated by MicroLang
 */
package impl;

import microservices.abstr.AbstractDogService;

public class DogServiceImpl extends AbstractDogService {
	
	@Override
	public int postDog(int dogYears) {
		//TODO: implement endpoint logic here
		return 0;
	}
	
	@Override
	public String getDog() {
		//TODO: implement endpoint logic here
		return null;
	}
	
	public static void main(String[] args) {
		new DogServiceImpl().run();
	}

}
