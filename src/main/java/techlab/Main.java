package techlab;

import techlab.service.PedidoService;
import techlab.service.ProductoService;

import java.util.InputMismatchException; // Podría usarse si usáramos scanner.nextInt(), etc.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Instancia de los servicios que manejan la lógica de negocio
        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService(productoService); // PedidoService depende de ProductoService

        int opcion;

        // Bucle principal del menú
        do {
            System.out.println("\n===================================");
            System.out.println(" SISTEMA DE GESTIÓN - TECHLAB     ");
            System.out.println("===================================");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("0) Salir"); // La opción 0 para salir
            System.out.print("Elija una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine()); // Lee la línea completa para evitar problemas con nextInt()
                switch (opcion) {
                    case 1:
                        productoService.agregarProducto();
                        break;
                    case 2:
                        productoService.listarProductos();
                        break;
                    case 3:
                        productoService.buscarActualizarProducto();
                        break;
                    case 4:
                        productoService.eliminarProducto();
                        break;
                    case 5:
                        pedidoService.crearPedido();
                        break;
                    case 6:
                        pedidoService.listarPedidos();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                // Manejo de excepción si el usuario no ingresa un número
                System.out.println("Error: Por favor, ingrese un número para seleccionar una opción.");
                opcion = -1; // Asigna un valor que no sea 0 para mantener el bucle
            }
        } while (opcion != 0); // El bucle continúa hasta que la opción sea 0

        scanner.close(); // Cierra el scanner al finalizar el programa
    }
}
