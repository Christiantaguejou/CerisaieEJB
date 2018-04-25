package controle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Properties;

public class JBossContext {

	public static Context getInitialContext() throws NamingException {

		Properties prop = new Properties();
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		prop.put("jboss.naming.client.ejb.context", true);
		return new InitialContext(prop);
	}


}



