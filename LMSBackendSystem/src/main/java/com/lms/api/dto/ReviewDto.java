package com.lms.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.lms.api.controller.ReviewController;
import com.lms.api.model.Course;
import com.lms.api.model.Review;

public class ReviewDto {

	private long total;
	private long fivestar;
	private long fourstar;
	private long threestar;
	private long twostar;
	private long onestar;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getFivestar() {
		return fivestar;
	}

	public void setFivestar(long fivestar) {
		this.fivestar = fivestar;
	}

	public long getFourstar() {
		return fourstar;
	}

	public void setFourstar(long fourstar) {
		this.fourstar = fourstar;
	}

	public long getThreestar() {
		return threestar;
	}

	public void setThreestar(long threestar) {
		this.threestar = threestar;
	}

	public long getTwostar() {
		return twostar;
	}

	public void setTwostar(long twostar) {
		this.twostar = twostar;
	}

	public long getOnestar() {
		return onestar;
	}

	public void setOnestar(long onestar) {
		this.onestar = onestar;
	}


	public ReviewDto convert(List<Review> list) {
		
		long total = list.size();
		ReviewDto dt = new ReviewDto();
		long fivestar = list.stream().filter(p-> p.getRating() == 5.0).count();
		long fourstar = list.stream().filter(p-> p.getRating() == 4.0).count();
		long threestar = list.stream().filter(p-> p.getRating() == 4.0).count();
		long twostar = list.stream().filter(p-> p.getRating() == 2.0).count();
		long onestar = list.stream().filter(p-> p.getRating() == 1.0).count();
		
		dt.setTotal(total);
		dt.setFivestar(fivestar);
		dt.setFourstar(fourstar);
		dt.setThreestar(threestar);
		dt.setTwostar(twostar);
		dt.setOnestar(onestar);
		return dt;
	}

	

}
