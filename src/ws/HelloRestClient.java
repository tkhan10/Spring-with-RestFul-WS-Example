/**
 * 
 */
package ws;

import java.text.MessageFormat;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author tofek.khan
 *
 */
public class HelloRestClient {
	
		private WebResource webResource;
		private Client client;
		private static final String BASE_URL = "http://localhost:9090/SpringRestful_Server/rest";
		
		public HelloRestClient(){
			client =  Client.create(new DefaultClientConfig());
			webResource = client.resource(BASE_URL).path("hellorest");
		}
		
		public String hello() throws UniformInterfaceException{
			//return webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
			WebResource resource = webResource;
			resource =  resource.path(MessageFormat.format("hello", new Object[]{}));
			return resource.accept(MediaType.TEXT_PLAIN).get(String.class);
		}
		
		public String hi(String name) throws UniformInterfaceException{
			//return webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
			WebResource resource = webResource;
			resource =  resource.path(MessageFormat.format("hi/{0}", new Object[]{name}));
			return resource.accept(MediaType.TEXT_PLAIN).get(String.class);
		}
		
		public String sum(String a, String b) throws UniformInterfaceException{
			
			WebResource resource = webResource;
			resource =  resource.path(MessageFormat.format("sum/{0}/{1}", new Object[]{a,b}));
			return resource.accept(MediaType.TEXT_PLAIN).get(String.class);
		}
		
		public void close(){
			client.destroy();
		}

}
