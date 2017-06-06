package foo.bar.client.app;

import java.io.IOException;
import java.util.List;

import foo.bar.client.api.OnlineStore;
import foo.bar.client.json.entity.Attribute;
import foo.bar.client.json.entity.Attributes;


public class Main {
	public static void main(String[] args) throws IOException {
		OnlineStore store = new OnlineStore();
		Attributes attributeList = store.products().list("96592").attributes().setValueOption("option").execute();
		
		List<Attribute> attributes = attributeList.getAttributes();
		for (Attribute attribute : attributes) {
			System.out.println(attribute.getValue());
		}
		
	}
}
