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
  - `foo.bar.server.rest.OnlineStoreApplication` as REST main application`
  - `foo.bar.server.rest.OnlineStoreResource` as REST resource

    ```
    
        dependencies {
            compile "javax.ws.rs:javax.ws.rs-api:2.0.1"
            
            compile "org.glassfish.jersey.core:jersey-server:2.25.1"
            compile "org.glassfish.jersey.containers:jersey-container-servlet:2.25.1"
        }
    ```    
    
4. tried [jsonschema2pojo gradle plugin](https://github.com/joelittlejohn/jsonschema2pojo/tree/master/jsonschema2pojo-gradle-plugin) to convert json to POJO
5. tried com.m3:curly, a handly http client
6. tried to define REST API and convert it to Java API

