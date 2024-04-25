package com.aluracursos.conversordemoneda.modelos;

public class Menu {
    private String bienvenida;
    private String menu;

    public void mostrarBienvenida(){
        bienvenida = """
                *****************************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                """;
        System.out.println(bienvenida);
    }

    public void mostrarMenu(){
        menu = """
                1) Dólar =>> Peso Argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                *****************************************************************
                """;
        System.out.println(menu);
    }
}
