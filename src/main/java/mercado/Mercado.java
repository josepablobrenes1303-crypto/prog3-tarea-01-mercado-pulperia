package mercado;

public class Mercado {

    public static double totalCarrito(Producto[] carrito) {
        double total = 0;
        for (Producto p : carrito) {
            total += p.precioFinal();
        }
        return total;
    }

    public static Producto masCaro(Producto[] carrito) {
        Producto mayor = carrito[0];

        for (Producto p : carrito) {
            if (p.precioFinal() > mayor.precioFinal()) {
                mayor = p;
            }
        }

        return mayor;
    }

    public static Producto masBarato(Producto[] carrito) {
        Producto menor = carrito[0];

        for (Producto p : carrito) {
            if (p.precioFinal() < menor.precioFinal()) {
                menor = p;
            }
        }

        return menor;
    }

    public static double totalDescuentos(Producto[] carrito) {
        double total = 0;

        for (Producto p : carrito) {
            if (p instanceof Descontable) {
                Descontable d = (Descontable) p;
                total += d.aplicarDescuento();
            }
        }

        return total;
    }
}