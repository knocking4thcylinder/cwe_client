package com.cwe_client.app;

import com.google.gson.*;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    HTTPClient client = new HTTPClient("https://echo.free.beeceptor.com");
    Gson gson = new Gson();
    JsonObject jsonData = JsonParser.parseString(gson.toJson(new Data())).getAsJsonObject();
    JsonObject response = client.POST(jsonData);
    System.out.println(response);
  }
}
