package com.example.ProjectPracticeAngular.sorting;

import java.util.Comparator;

import com.example.ProjectPracticeAngular.entity.Mobile;

public class MobileSorting extends Mobile implements Comparator<Mobile> {

	@Override
	public int compare(Mobile mobile1, Mobile mobile2) {
		
		Integer mob1=mobile1.getPrice();
		Integer mob2=mobile2.getPrice();
		
		if(mob1.equals(mob2)) {
			return - mobile1.getSpeed().compareTo(mobile2.getSpeed());
		}else {
		return mob1.compareTo(mob2);
		}
	}
}