package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.modelos.Menu;
import com.aluracursos.conversordemoneda.modelos.ObtenerConversion;
import com.aluracursos.conversordemoneda.modelos.TasasDeConversion;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcionSeleccionada = 0;
        Menu menu = new Menu();
        menu.mostrarBienvenida();
        try{
            while (opcionSeleccionada != 7){
                menu.mostrarMenu();
                opcionSeleccionada = Integer.valueOf(in.nextLine());
                if (opcionSeleccionada == 7) {
                    System.out.println("Finalizando la aplicación...");
                    break;
                } else if (opcionSeleccionada > 7) {
                    System.out.println("No existe la opcion seleccionada.\n");
                } else {
                    System.out.println("Ingresa el valor que deseas convertir: ");
                    double valorAconvertir = Double.valueOf(in.nextLine());
                    ObtenerConversion obtener = new ObtenerConversion();
                    TasasDeConversion tasa = obtener.conversion(opcionSeleccionada);
                    double conversionApi = tasa.conversion_rate();
                    double conversionReal = conversionApi * valorAconvertir;
                    System.out.println("El valor " + valorAconvertir + " [" + tasa.base_code() + "] corresponde al valor final de =>> " + conversionReal + " [" + tasa.target_code() + "]\n" );
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Opción no válida: " + e.getMessage());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");

        }
    }
}
