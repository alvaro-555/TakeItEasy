package Servicio;

import java.time.YearMonth;
import java.time.LocalDate;
import model.Calendario.*;
import Servicio.ListaEnlazada.*;

public class GenerarCalendario {

    public Calendario generarCalendario() {

        int anioActual = LocalDate.now().getYear();

        ListaEnlazada<Mes> listaMeses = new ListaEnlazada<>();

        for (int i = 1; i <= 12; i++) {

            YearMonth anioMes = YearMonth.of(anioActual, i);
            int cantidadDias = anioMes.lengthOfMonth();

            ListaEnlazada<Dia> listaDias = new ListaEnlazada<>();

            for (int d = 1; d <= cantidadDias; d++) {
                Dia dia = new Dia();
                dia.setNumero(d);
                listaDias.agregar(dia);
            }

            Mes mes = new Mes();

            // asignación directa sin array
            if (i == 1) mes.setNombre("Enero");
            else if (i == 2) mes.setNombre("Febrero");
            else if (i == 3) mes.setNombre("Marzo");
            else if (i == 4) mes.setNombre("Abril");
            else if (i == 5) mes.setNombre("Mayo");
            else if (i == 6) mes.setNombre("Junio");
            else if (i == 7) mes.setNombre("Julio");
            else if (i == 8) mes.setNombre("Agosto");
            else if (i == 9) mes.setNombre("Septiembre");
            else if (i == 10) mes.setNombre("Octubre");
            else if (i == 11) mes.setNombre("Noviembre");
            else mes.setNombre("Diciembre");

            mes.setDias(listaDias);

            listaMeses.agregar(mes);
        }

        Anio anio = new Anio();
        anio.setNumero(anioActual);
        anio.setMeses(listaMeses);

        ListaEnlazada<Anio> listaAnios = new ListaEnlazada<>();
        listaAnios.agregar(anio);

        Calendario calendario = new Calendario();
        calendario.setAnios(listaAnios);

        return calendario;
    }
}