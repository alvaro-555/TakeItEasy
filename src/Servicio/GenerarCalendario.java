package Servicio;

import java.time.YearMonth;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Calendario.*;

public class GenerarCalendario {

    public Calendario generarCalendario() {

        int anioActual = LocalDate.now().getYear();

        List<Mes> listaMeses = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {

            YearMonth anioMes = YearMonth.of(anioActual, i);
            int cantidadDias = anioMes.lengthOfMonth();

            List<Dia> listaDias = new ArrayList<>();

            for (int d = 1; d <= cantidadDias; d++) {
                Dia dia = new Dia();
                dia.setNumero(d);
                listaDias.add(dia);
            }

            Mes mes = new Mes();

            // Meses en español 🔥
            String[] nombresMeses = {
                "Enero", "Febrero", "Marzo", "Abril",
                "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre"
            };

            mes.setNombre(nombresMeses[i - 1]);
            mes.setDias(listaDias);

            listaMeses.add(mes);
        }

        Anio anio = new Anio();
        anio.setNumero(anioActual);
        anio.setMeses(listaMeses);

        List<Anio> listaAnios = new ArrayList<>();
        listaAnios.add(anio);

        Calendario calendario = new Calendario();
        calendario.setAnios(listaAnios);

        return calendario;
    }
}