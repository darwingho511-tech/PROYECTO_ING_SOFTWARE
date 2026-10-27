package co.edu.uniajc.sate.evaluador;

public class EvaluadorInasistencia {
    public boolean evaluarAlertaRoja(int totalClases, int inasistencias) {
        if (totalClases <= 0) return false;
        double porcentaje = ((double) inasistencias / totalClases) * 100.0;
        return porcentaje > 15.0;
    }
}
