package entities;

import java.util.*;

public class Cart {

	private List<IMedia> medias = new ArrayList<IMedia>();
	private boolean validate = false;
	
	public List<IMedia> getMedias() {
		return medias;
	}
	
	public double getTotalPrice() {
		double total = 0;
		for(IMedia m : medias) {
			total += m.getVATPrice();
		}
		return total;
	}

	public boolean isValidated() {
		return validate;
	}

	public void validate() throws MediaException {
		if(!validate) {
			validate = true;
		}
		else throw new MediaException("Validate twice");
	}
	

}
