package com.cwe_client.app;

import com.google.gson.*;
import java.io.IOException;
import java.net.*;
import java.net.http.*;
import java.net.http.HttpClient.*;
import java.net.http.HttpRequest.*;
import java.net.http.HttpResponse.*;
import java.time.Duration;

/** HTTPClient */
public class HTTPClient {
  private String url = "";

  public HTTPClient(String url) {
    this.url = url;
  }

  private HttpClient client =
      HttpClient.newBuilder()
          .version(Version.HTTP_2)
          .followRedirects(Redirect.NEVER)
          .connectTimeout(Duration.ofMinutes(2))
          .build();

  public JsonObject POST(JsonObject data) {
    HttpRequest request =
        HttpRequest.newBuilder(URI.create(this.url))
            .header("Content-Type", "json")
            .POST(BodyPublishers.ofString(data.toString()))
            .build();

    try {
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
      return jsonResponse;
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Error occured while sending/recieving data");
      return new JsonObject();
    } catch (InterruptedException e) {
      e.printStackTrace();
      System.out.println("Operation interrupted, check internet connection");
      return new JsonObject();
    }
  }
}
