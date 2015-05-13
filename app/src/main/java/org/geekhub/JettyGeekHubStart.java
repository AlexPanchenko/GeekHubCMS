package org.geekhub;

import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.util.resource.FileResource;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

import java.io.File;

public class JettyGeekHubStart {
	public void testApplication() throws Exception {
		main(new String[0]);
	}

	/**
     * @param -forceSC force using SocketConnector instead of SelectChannelConnector. Default on Vista
     * @param -ssl start additional SSL connector on port 8443
	 */
	public static void main(String[] args) throws Exception {
		Server server = new Server();
        int port = getServerPort();
        int sslPort = getSslPort();
        
		Connector connector = createSelectChannelConnector(server, port);
        
		Connector sslConnector = createSSLConnector(server, sslPort);
			
        Connector[] connectors = new Connector[] { connector, sslConnector };
        server.setConnectors(connectors);

		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setServer(server);
		webAppContext.setContextPath("/");
		webAppContext.setWar("src/main/webapp");
		webAppContext.setMaxFormContentSize(1 * 1024 * 1024);
		webAppContext.getMetaData().addContainerResource(new FileResource(new File("./target/classes").toURI()));
		webAppContext.setResourceBase("src/main/webapp");
		webAppContext.setTempDirectory(new File("./target/tmp"));
		webAppContext.setConfigurations(new Configuration[]{new WebXmlConfiguration()});
		server.setHandler(webAppContext);


		try {
			System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP!!");
			server.start();
			while (System.in.available() == 0) {
				Thread.sleep(5000);
			}
			server.stop();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(100);
		}

	}

    private static int getSslPort() {
        String strPort = System.getProperty("port.ssl");
        return strPort != null ? Integer.parseInt(strPort) : 8443;
    }

    private static int getServerPort() {
        String strPort = System.getProperty("port.server");
        return strPort != null ? Integer.parseInt(strPort) : 8080;
    }

	static Connector createSelectChannelConnector(Server server,int port) {
		ServerConnector connector = new ServerConnector(server);
		connector.setIdleTimeout(1000 * 60 * 60);
		connector.setSoLingerTime(-1);
		connector.setPort(port);
		return connector;
	}
	static Connector createSSLConnector(Server server,int port) {
		SslContextFactory contextFactory = new SslContextFactory();
		contextFactory.setKeyStorePath("conf/dev.keystore");
		contextFactory.setKeyStorePassword("geekhub");
		contextFactory.setKeyManagerPassword("geekhub");

		ServerConnector sslConnector = new ServerConnector(server,
				new SslConnectionFactory(contextFactory, HttpVersion.HTTP_1_1.asString()));
		sslConnector.setPort(port);
		sslConnector.setIdleTimeout(1000 * 60 * 60);
		return sslConnector;
	}
}
