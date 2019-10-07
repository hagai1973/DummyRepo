package Main;


import java.io.IOException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface AutoCompleteInterface {
	
	@WebMethod
	List<String> autoComplete(String word) throws IOException;

	
}
