package Servicio;

public class ComparadorFechas {

    public static boolean esMenor(String f1, String f2) {
        String[] a = f1.split("/");
        String[] b = f2.split("/");

        int d1 = Integer.parseInt(a[0]);
        int m1 = Integer.parseInt(a[1]);
        int y1 = Integer.parseInt(a[2]);

        int d2 = Integer.parseInt(b[0]);
        int m2 = Integer.parseInt(b[1]);
        int y2 = Integer.parseInt(b[2]);

        if (y1 != y2) return y1 < y2;
        if (m1 != m2) return m1 < m2;
        return d1 < d2;
    }
}