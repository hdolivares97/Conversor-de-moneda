package com.aluracursos.conversordemoneda.modelos;

import java.util.Map;

public record TasasDeConversion(String base_code, String target_code, double conversion_rate) {
}
