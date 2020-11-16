import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Java11HttpClient {

	// one instance, reuse
	private final HttpClient httpClient = HttpClient.newBuilder()
			.version(HttpClient.Version.HTTP_2)
			.build();

	public void sendGet() throws Exception {

		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://httpbin.org/get"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot")
				.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// print status code
		System.out.println(response.statusCode());

		// print response body
		System.out.println(response.body());

	}

	public void sendPost(String searchItem) throws Exception {

		// form parameters
		String json = "{" +
				"\"search\":\"" +searchItem + "\"," +
				"\"usecase_id\":\"575676f5b6e32d98675d368b\"," +
				"\"market_name\":\"seattle\"," +
				"\"fee\":0," +
				"\"id\":null," +
				"\"apitoken\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50X2lkIjoiNWU5NGFhODI5NTc5ZmY4NGFmNmFiNDI3In0.PJL-2U-wCjm2MVMkRIdUATRDIxH52n8Xm6HEvTziE0c\"," +
				"\"account_id\":\"5e94aa829579ff84af6ab427\"," +
				"\"role_filter\":\"user\"," +
				"\"client\":\"user_app\"," +
				"\"platform\":\"web\"," +
				"\"support\":false," +
				"\"source_description\":\"book.dolly user\"," +
				"\"version\":\"1.0\"" +
				"}";

		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create("https://api.dolly.com/v2/job/item/find"))
				.header("Content-Type", "application/json")
				.build();


		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// print status code
		System.out.println(response.statusCode());

		// print response body
		System.out.println(response.body());

	}

}