import java.util.Scanner;

// Clase abstracta Persona
abstract class Persona {
    protected String nombre;
    protected String cedula;

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public abstract double calcularSueldo();
}

// Subclase ProfesorUniversitario
class ProfesorUniversitario extends Persona {
    private String nivelEducativo;
    private String tipoContrato;

    public ProfesorUniversitario(String nombre, String cedula, String nivelEducativo, String tipoContrato) {
        super(nombre, cedula);
        this.nivelEducativo = nivelEducativo;
        this.tipoContrato = tipoContrato;
    }

    @Override
    public double calcularSueldo() {
        double sueldoBase = 0;
        switch (nivelEducativo.toLowerCase()) {
            case "pregrado":
                sueldoBase = 37000;
                break;
            case "especializacion":
                sueldoBase = 40000;
                break;
            case "maestria":
                sueldoBase = 50000;
                break;
            case "doctorado":
                sueldoBase = 95000;
                break;
            default:
                System.out.println("Nivel educativo no válido.");
                return 0;
        }

        switch (tipoContrato.toLowerCase()) {
            case "planta":
                return sueldoBase * 12;
            case "ocacional":
                return sueldoBase * 7;
            case "catedra":
                // 17 horas semanales * 4 semanas * sueldoBase / 44 horas (proporcional)
                return ((sueldoBase / 44) * 17) * 4 * 12;
            default:
                System.out.println("Tipo de contrato no válido.");
                return 0;
        }
    }
}

// Subclase Secretaria
class Secretaria extends Persona {
    private double salarioMensual;

    public Secretaria(String nombre, String cedula, double salarioMensual) {
        super(nombre, cedula);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSueldo() {
        return salarioMensual * 12;
    }
}

// Subclase Rector
class Rector extends Persona {
    private double salarioMensual;

    public Rector(String nombre, String cedula, double salarioMensual) {
        super(nombre, cedula);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSueldo() {
        return salarioMensual * 12;
    }
}

package com.mycompany.salarios;

// Clase principal para probar
public class Salarios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese nombre del profesor:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese cédula del profesor:");
        String cedula = sc.nextLine();
        System.out.println("Ingrese nivel educativo (pregrado, especializacion, maestria, doctorado):");
        String nivel = sc.nextLine();
        System.out.println("Ingrese tipo de contrato (planta, ocacional, catedra):");
        String contrato = sc.nextLine();

        ProfesorUniversitario profesor = new ProfesorUniversitario(nombre, cedula, nivel, contrato);
        System.out.println("El sueldo anual del profesor es: $" + profesor.calcularSueldo());

        // Ejemplo para secretaria y rector
        Secretaria secretaria = new Secretaria("Ana", "12345", 25000);
        Rector rector = new Rector("Carlos", "54321", 50000);

        System.out.println("El sueldo anual de la secretaria es: $" + secretaria.calcularSueldo());
        System.out.println("El sueldo anual del rector es: $" + rector.calcularSueldo());
    }
}

/*
La clase main ya está implementada dentro de la clase Universidad en el código proporcionado.
*/