/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package probandocongit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Supermercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, Double> supermercado = new HashMap<>();
        String producto;
        int intentos = 3;
        boolean b = false;
        float cantidad = 0;

        supermercado.put("avena", 2.21);
        supermercado.put("garbanzos", 2.39);
        supermercado.put("tomate", 1.59);
        supermercado.put("jenjibre", 3.13);
        supermercado.put("quinoa", 4.50);
        supermercado.put("guisantes", 1.60);

        HashMap<String, Float> compra = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Producto: ");
            producto = sc.next();
            System.out.println("");
            System.out.print("Cantidad: ");
           if(!producto.equals("fin")) cantidad = sc.nextFloat();

            if (!compra.containsKey(producto)) {

                compra.putIfAbsent(producto, cantidad);
       
            } else {
                float cant = compra.get(producto);
                cant++;

                compra.replace(producto, cant);

            }
        } while (!producto.equals("fin"));

        System.out.println("Producto \t Precio \t cantidad \t");
        for (Map.Entry entry : compra.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println("");
            
            if(compra.containsKey())
            double i = (double) compra * supermercado.get(producto);
            System.out.println(i );

        }

    }
}