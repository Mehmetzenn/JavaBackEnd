package kodlamaio.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
	private int id;
	private	String productName;
	private String categoryName;

}
