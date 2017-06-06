## Notes
1. tried servlet 3.0, no longer required web.xml (still included in the project, because for reference only)
   - entry point: http://localhost:8083/rest-api-to-java-api/index.jsp
2. tried gretty to launch jetty9 for integration test
    ```

        apply plugin: 'org.akhikhl.gretty'
    
        buildscript {
            repositories {
                maven {
                    url "https://plugins.gradle.org/m2/"
                }
            }
            dependencies {
                classpath "gradle.plugin.org.akhikhl.gretty:gretty:1.4.2"
            }
        }
        
        gretty {
            httpPort = 8083
            contextPath = '/rest-api-to-java-api'
            servletContainer = 'jetty9'
            
            loggingLevel='INFO'
            debugPort = 5005      // default
            debugSuspend = true   // default
        
            httpsEnabled = true
            httpsPort = 8443
            sslKeyStorePath = 'some.jks'
            sslKeyStorePassword = 'somepwd'  
            
            integrationTestTask = 'integrationTest'  
        }
        
        
        test {
            include '**/Test*.*'
            include '**/*Test.*'
            exclude '**/*IT.*'
        }
        
        task integrationTest(type: Test, dependsOn: 'test') {
            outputs.upToDateWhen { false }
            include '**/*IT.*'
        }
      
    ```
3. tried jersey + JAX-RS for REST
   - `foo.bar.server.rest.OnlineStoreApplication` as REST main application
   - `foo.bar.server.rest.OnlineStoreResource` as REST resource

    ```
    
        dependencies {
            compile "javax.ws.rs:javax.ws.rs-api:2.0.1"
            
            compile "org.glassfish.jersey.core:jersey-server:2.25.1"
            compile "org.glassfish.jersey.containers:jersey-container-servlet:2.25.1"
        }
    ```        
4. tried [jsonschema2pojo gradle plugin](https://github.com/joelittlejohn/jsonschema2pojo/tree/master/jsonschema2pojo-gradle-plugin) to convert json to POJO
   - schema as input
   - schema can be generated by json by [https://jsonschema.net](https://jsonschema.net)
  
    ```
    
        apply plugin: 'jsonschema2pojo'
        
        buildscript {
            repositories {
                mavenCentral()        
            }
                
            dependencies {
                classpath 'org.jsonschema2pojo:jsonschema2pojo-gradle-plugin:0.4.34'
            }
        }
        
        // Each configuration is set to the default value
        jsonSchema2Pojo {
            ...        
        }
    ```
5. tried [com.m3:curly](https://github.com/m3dev/curly), a handly http client
6. tried to define REST API and convert it to Java API
   - create a nested inner classes of `Attributes` of `Product` of `Products` of `OnlineStore`
   - each inner class extends `OnlineStoreRequest<T>`
   - each inner class super the constructor `(OnlineStore client, String uriTemplate, Class<T> responseClass)`
   - `OnlineStoreRequest` builds the REST URL, if any, with the key-value parameters stored in its `HashMap`. 
  

    | REST API | Java API 
    |----------|----------
    | `api/v{version}/products` | `store.products().execute()`
    | `api/v{version}/products/{id}` | `store.products().list("96592").execute()`
    | `api/v{version}/products/{id}/attributes` | `store.products().list("96592").attributes().execute()`
    | `api/v{version}/products/{id}/attributes?value_type={VALUE_TYPE}` | `store.products().list("96592").attributes().setValueType("text").execute()`
