package com.Ecom.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecom.api.model.Category;
import com.Ecom.api.model.Product;
import com.Ecom.api.model.Review;
import com.Ecom.api.repository.CategoryRepository;
import com.Ecom.api.repository.ProductRepository;
import com.Ecom.api.repository.ReviewRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class ProductController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@PostMapping("/product/{cid}")
	public Product addProduct(@PathVariable("cid")Long cid, @RequestBody Product product) {
		
		Category category = categoryRepository.getById(cid);
		product.setCategory(category);
		return productRepository.save(product);
	}
	
	@GetMapping("/product/{cid}")
	public List<Product> getAllProduct(@PathVariable("cid")Long cid) {
		List<Product> list = new ArrayList<>();
		list = productRepository.findByCategoryId(cid);
		return list;
	}
	
//	@GetMapping("/review/{pid}")
//	public Long getReviewCount(@PathVariable("pid") Long pid) {
//		
//		return reviewRepository.getReviewCount(pid);
//	}
	
	@GetMapping("/review/product/{pid}")
	public List<Review> getAllReview(@PathVariable("pid") Long pid) {
		return reviewRepository.findByProductId(pid);
	}
	
	@PostMapping("/review/{pid}")
	public Review addReview(@PathVariable("pid") Long pid, @RequestBody Review review) {
		
		Product product = productRepository.getById(pid);
		review.setProduct(product);
		return reviewRepository.save(review);
	}
}














