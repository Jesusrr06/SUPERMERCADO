/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package probandocongit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Supermercado {

    private static final String RUTA = "Datos/compra.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        HashMap o = null;

        do {
            System.out.println("introduce una opcion");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    o = supermercado();
                    break;
                case 2:
                    guardardatosHashmap(o);
                    break;
                case 3:
                  o=  cargarHashMap();
                    break;

            }

        } while (opcion != 0);

    }

    public static HashMap supermercado() {
        HashMap<String, Double> supermercado = new HashMap<>();
        String producto;
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
            if (!producto.equals("fin")) {
                System.out.print("Cantidad: ");
                cantidad = sc.nextFloat();

                if (!compra.containsKey(producto)) {

                    compra.putIfAbsent(producto, cantidad);

                } else {
                    float cant = compra.get(producto);
                    cant++;

                    compra.replace(producto, cant);

                }
            }
        } while (!producto.equals("fin"));
        System.out.println("");
        System.out.println("Producto \t Precio \t cantidad \t");
        for (Map.Entry entry : compra.entrySet()) {
            System.out.print(entry.getKey() + " \t ");
            String prod = (String) entry.getKey();
            double i;
            double precio;
            precio = (double) supermercado.get(prod);
            float cant = (float) entry.getValue();

            i = (double) precio * cant;

            System.out.print(i + " \t ");
            System.out.println(entry.getValue());
        }
        return compra;
    }

    public static void guardardatosHashmap(HashMap<String, Float> o) {
        Scanner sc = new Scanner(System.in);
        String info = "";

        for (Map.Entry entry : o.entrySet()) {
            info += entry.getKey() + "#" + entry.getValue() + "# \n";
        }
        if (guardarinfo(RUTA, true, info)) {

            System.out.println("Todo bien");
        }

    }

    public static boolean guardarinfo(String ruta, boolean b, String info) {

        File file = new File(ruta);
        BufferedWriter bw = null;
        try {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            bw = new BufferedWriter(new FileWriter(file, b));
            bw.write(info);
            if (info.endsWith(System.lineSeparator())) {
                bw.newLine();

            }
            bw.flush();
            System.out.println("se termino correctamente" + ruta);
            return true;
        } catch (IOException e) {

            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            return false;
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ignored) {
                }
            }
        }

    }

    public static String Cargarficherodetexto() {
        Scanner sc = null;
                 String datos = "";
   try {
            File fichero = new File(RUTA);

            System.out.println("Leyendo el contenido del fichero..........\n\n");
            sc = new Scanner(fichero);
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                datos += linea + "\n";
                System.out.println(linea);

            }
            System.out.println("\n --->>   Lectura completada");
        } catch (Exception e) {
            System.out.println("Mensaje:  " + e.getMessage());
        } finally {
            try {
                if (sc != null) {
                    sc.close();
                }
            } catch (Exception e2) {
                System.out.println("Mensaje fichero:   " + e2.getMessage());
            }
        }
        return datos;
    }

    public static HashMap cargarHashMap() {
        HashMap<String, Float> o = new HashMap<>();
        String datos = Cargarficherodetexto();
        String[] linea = datos.split("\n");
        String[] unProducto = null;
        int i = 0;
        try {
            while (i < linea.length) {
                unProducto = linea[i].split("#");
                String producto = unProducto[0];
                String cant = unProducto[1];

                o.putIfAbsent(producto, Float.valueOf(cant));

                i++;
            }

        } catch (Error e) {
            System.out.println(e.getMessage());
            return o;
        }
        return o;
    }

}
