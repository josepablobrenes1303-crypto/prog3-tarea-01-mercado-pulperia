package mercado;

public class Limpieza extends Producto implements Descontable {

    private double porcentajeDescuento; // ej. 0.10 = 10%

    public Limpieza(String nombre, double precioBase, int cantidad, double porcentajeDescuento) {
        super(nombre, precioBase, cantidad);
        setPorcentajeDescuento(porcentajeDescuento);
    }

    @Override
    public double precioFinal() {
        double total = getPrecioBase() * getCantidad() * 1.13;
        total -= aplicarDescuento();
        return total;
    }

    @Override
    public double aplicarDescuento() {
        double total = getPrecioBase() * getCantidad() * 1.13;
        return total * porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double pct) {
        if (pct >= 0 && pct <= 1) {
            porcentajeDescuento = pct;
        } else {
            System.out.println("Descuento inválido: " + pct);
        }
    }

    public void promo() {
        System.out.println("Producto de limpieza en promoción.");
    }

    public void promo(boolean conEtiqueta) {
        if (conEtiqueta) {
            System.out.println("PROMO: " + getNombre() + " con " + (porcentajeDescuento * 100) + "% de descuento.");
        } else {
            promo();
        }
    }
}