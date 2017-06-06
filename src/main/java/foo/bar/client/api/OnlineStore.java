package foo.bar.client.api;

public class OnlineStore {
	
	public Products products() {
		return new Products();
	}
	
	public class Products extends OnlineStoreRequest<foo.bar.client.json.entity.Products> {
		private static final String REST_PATH = "api/v{version}/products";

		public Products() {
			super(OnlineStore.this, REST_PATH, foo.bar.client.json.entity.Products.class);
		}
		
		public Product list(String id) {		
			return new Product(id);
		}
		
		public class Product extends OnlineStoreRequest<foo.bar.client.json.entity.Product> {
			private static final String REST_PATH = "api/v{version}/products/{id}";
			private String id = "";
			
			public Product(String id) {					
				super(OnlineStore.this, REST_PATH, foo.bar.client.json.entity.Product.class);
				super.id = id;
				this.id = id;
			}

			public Attributes attributes() {		
				Attributes result = new Attributes();
				return result;
			}
			
			public class Attributes extends OnlineStoreRequest<foo.bar.client.json.entity.Attributes> {
				private static final String REST_PATH = "api/v{version}/products/{id}/attributes";

				public Attributes() {		
					super(OnlineStore.this, REST_PATH, foo.bar.client.json.entity.Attributes.class);
					super.id = Product.this.id;
				}
				
				public Attributes setValueOption(String valueOption) {
					super.put("value_type", valueOption);
					return this;
				}
				

			}
		}
	}
	
	public String getBaseUrl() {
		return "http://localhost:8083/rest-api-to-java-api/";
	}
	

}
