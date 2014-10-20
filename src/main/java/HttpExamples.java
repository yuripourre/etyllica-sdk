import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;
import examples.http.HTTPApplication;


public class HttpExamples extends EtyllicaFrame {

	public HttpExamples(int w, int h) {
		super(w, h);
		// TODO Auto-generated constructor stub
	}
	
	public HttpExamples() {
		super(800,600);
	}

	public static void main(String[] args) {
		
		HttpExamples example = new HttpExamples();
		
		example.init();		
	}

	@Override
	public Application startApplication() {
		
		return new HTTPApplication(w, h);		
	}
	
}