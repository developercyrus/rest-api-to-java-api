package foo.bar.client.api;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import foo.bar.client.json.entity.Attributes;
import foo.bar.client.json.entity.Product;
import foo.bar.client.json.entity.Products;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OnlineStoreIT {
	OnlineStore store;
	
	@Before
	public void init() {
		store = new OnlineStore();
	}
	
	@Test
	public void test1_Products() throws IOException {
		Products productList = store.products().execute();
		String actual = productList.getProducts().get(2).getName();
		String expected = "FM Player";
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void test2_ProductDetail() throws IOException {
		Product product = store.products().list("96592").execute();
		String actual = product.getName();
		String expected = "MP3 Player";
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void test3_ProductAttribute() throws IOException {
		Attributes attributeList = store.products().list("96592").attributes().execute();
		String actual = attributeList.getAttributes().get(0).getKey().getName();
		String expected = "color";
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void test4_ProductAttributeValueOption() throws IOException {
		Attributes attributeList = store.products().list("96592").attributes().setValueOption("text").execute();
		String actual = attributeList.getAttributes().get(0).getKey().getName();
		String expected = "material";
		
		assertEquals(actual, expected);
	}
}
