package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}



	@GetMapping("/getall")
	public DataResult<List<Product>> getall() {
		return this.productService.getAll();
	}
	
	@PostMapping
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
		
	}
	
	@GetMapping("/getByProductNameOrCategory_CategoryId")
	public DataResult<Product> getByProductNameOrCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public	DataResult<List<Product>> getByProductNameContains(String productName){
		return this.productService.getByProductNameContains(productName);	
		
	}
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNumber , int pageSize){
		return this.productService.getAll(pageNumber, pageSize);
	}
	
	@GetMapping("/getAllSortedAsc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	

	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	
		
}