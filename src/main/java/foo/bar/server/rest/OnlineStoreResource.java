package foo.bar.server.rest;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;


@Path("products")
public class OnlineStoreResource {
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String anyMethodName1() throws IOException {
		File file = new File(this.getClass().getResource("/foo/bar/server/rest/products.json").getFile());
		String string = FileUtils.readFileToString(file);
        return string;
    }
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String anyMethodName2(@PathParam("id") String id) throws IOException {
		File file = new File(this.getClass().getResource("/foo/bar/server/rest/product_detail.json").getFile());
		String string = FileUtils.readFileToString(file);
        return string;
    }

	@GET
	@Path("/{id}/attributes")
	@Produces(MediaType.APPLICATION_JSON)
	public String anyMethodName3(@PathParam("id") String id, @QueryParam("value_type") String value_type) throws IOException {
		File file = null;		
		if (value_type == null) { 
			file = new File(this.getClass().getResource("/foo/bar/server/rest/product_attributes.json").getFile());
		}
		else {
			file = new File(this.getClass().getResource("/foo/bar/server/rest/product_attributes_value_type.json").getFile());
		}
		
		String string = FileUtils.readFileToString(file);
        return string;
    }
}
