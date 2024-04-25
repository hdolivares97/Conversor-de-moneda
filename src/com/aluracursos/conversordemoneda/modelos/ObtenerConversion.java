package com.aluracursos.conversordemoneda.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObtenerConversion {
    private String tasaAconvertir;
    private String tasaConvertida;

    public String[] obtenerTasas(int opcionSeleccionada){
        String[] tasas = new String[2];
        switch (opcionSeleccionada){
            case 1:
                tasas[0] = "USD";
                tasas[1] = "ARS";
                break;
            case 2:
                tasas[0] = "ARS";
                tasas[1] = "USD";
                break;
            case 3:
                tasas[0] = "USD";
                tasas[1] = "BRL";
                break;
            case 4:
                tasas[0] = "BRL";
                tasas[1] = "USD";
                break;
            case 5:
                tasas[0] = "USD";
                tasas[1] = "COP";
                break;
            case 6:
                tasas[0] = "COP";
                tasas[1] = "USD";
                break;
        }
        return tasas;
    }

    public TasasDeConversion conversion(int opcion) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String[] tasas = obtenerTasas(opcion);
        tasaAconvertir = tasas[0];
        tasaConvertida = tasas[1];

        String direccion = "https://v6.exchangerate-api.com/v6/1bcbd478ded9267623cf2844/pair/" + tasaAconvertir + "/" + tasaConvertida;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TasasDeConversion.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontre esa tasa");
        }
    }
}
