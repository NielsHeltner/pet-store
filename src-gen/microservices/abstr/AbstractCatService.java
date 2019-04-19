/**
 * Generated by MicroLang
 */
package microservices.abstr;

import microservices.CatService;
import lib.HttpUtil;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public abstract class AbstractCatService implements CatService, Runnable {
	
	protected HttpUtil util = new HttpUtil();
	
	@Override
	public final void run() {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
			server.createContext("/", exchange -> {
				String path = exchange.getRequestURI().getPath();
				String method = exchange.getRequestMethod();
				System.out.println(method + " " + path);
				String body = util.getBody(exchange.getRequestBody());
				System.out.println("body: " + body);
				Map<String, String> parameters = new HashMap<>();
				try {
					parameters = util.toMap(body);
				}
				catch (Exception e) {
					util.sendResponse(exchange, 400, "Malformed parameters in body");
					return;
				}
				System.out.println("parameters: " + parameters);
				if (path.matches("\\/cat")) {
					System.out.println("/cat was hit");
					switch (method) {
						case "POST": {
							int catYears = Integer.valueOf(parameters.get("catYears"));
							Object response = postCat(catYears);
							util.sendResponse(exchange, 200, response);
							return;
						}
						default:
							util.sendResponse(exchange, 405, method + " is not implemented on " + path);
					}
				}
				if (path.matches("\\/cat")) {
					System.out.println("/cat was hit");
					switch (method) {
						case "GET": {
							Object response = getCat();
							util.sendResponse(exchange, 200, response);
							return;
						}
						default:
							util.sendResponse(exchange, 405, method + " is not implemented on " + path);
					}
				}
				else {
					util.sendResponse(exchange, 404, path + " could not be found");
				}
			});
			server.start();
			System.out.println("Now listening on port " + PORT);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
