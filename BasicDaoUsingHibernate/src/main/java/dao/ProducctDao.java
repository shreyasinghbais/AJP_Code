package dao;
 
import java.util.List;
import exception.ProductException;
import model.Product;

public interface ProducctDao {
	public boolean addProduct(Product p) throws ProductException;
	public boolean deleteProduct(int pId) throws ProductException;
	public boolean updateProduct(Product p) throws ProductException;
	public List<Product> findAllProduct() throws ProductException;
	public Product findSingleProduct(int pId) throws ProductException;
}
