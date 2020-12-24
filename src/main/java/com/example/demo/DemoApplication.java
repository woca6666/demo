package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@PropertySource("classpath:person.properties")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //http转https
//	@Bean
//	public Connector connector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		connector.setPort(8080);
//		connector.setSecure(false);
//		connector.setRedirectPort(8079);
//		return connector;
//	}
//
//	@Bean
//	public TomcatServletWebServerFactory tomcatServletWebServerFactory(Connector connector) {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//
//			@Override
//			protected void postProcessContext(Context context) {
//				SecurityConstraint securityConstraint = new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");
//				SecurityCollection collection = new SecurityCollection();
//				collection.addPattern("/*");
//				securityConstraint.addCollection(collection);
//				context.addConstraint(securityConstraint);
//			}
//		};
//		tomcat.addAdditionalTomcatConnectors(connector);
//		return tomcat;
//	}

}
