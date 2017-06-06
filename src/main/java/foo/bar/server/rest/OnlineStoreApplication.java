package foo.bar.server.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/v1/")
public class OnlineStoreApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {

	    Set<Class<?>> resourcesSet = new java.util.HashSet<>();
	    adicionarClassesRecursos( resourcesSet );
	    return resourcesSet;

	}

	private void adicionarClassesRecursos( Set<Class<?>> resources ) {
	    resources.add(foo.bar.server.rest.OnlineStoreResource.class);
	}
}
