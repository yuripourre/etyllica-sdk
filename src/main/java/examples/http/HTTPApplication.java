package examples.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.network.http.DefaultResponseHandler;

public class HTTPApplication extends Application {

	private CloseableHttpClient httpclient;

	public HTTPApplication(int w, int h) {
		super(w, h);	
	}

	@Override
	public void load() {

		httpclient = HttpClients.createDefault();

		try {
			doLogin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doLogin() throws IOException {

		HttpGet httpget = new HttpGet("http://localhost:3000/");

		ResponseHandler<String> responseHandler = new DefaultResponseHandler();

		String responseBody;
		
		try {

			responseBody = httpclient.execute(httpget, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			httpclient.close();	
		}	

	}

	@Override
	public void draw(Graphic g) {
		// TODO Auto-generated method stub

	}

}
