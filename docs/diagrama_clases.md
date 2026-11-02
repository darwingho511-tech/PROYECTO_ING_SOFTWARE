mermaid 
classDiagram
 %% Relaciones del Dominio SATE-UNIAJC 
    Estudiante "1" -- "1..*" RegistroAsistencia : registra 
    Estudiante "1" -- "0..*" Alerta : posee 
    Docente "1" -- "1..*" Asignatura : dicta 
    Asignatura "1" -- "1..*" RegistroAsistencia : contiene 
 
    %% Relaciones de Lógica de Negocio y Servicios (SOLID - DIP/SRP) 
    GestorAlertas ..> EvaluadorInasistencia : usa 
    GestorAlertas ..> ServicioNotificacion : usa 
    GestorAlertas ..> Alerta : crea 
 
    %% Entidades de Dominio 
    class Estudiante { 
        -Long idEstudiante 
        -String codigo 
        -String nombre 
        -double promedioAcumulado 
        +getPromedioAcumulado() double 
        +getCodigo() String 
    } 
 
    class Docente { 
        -Long idDocente 
        -String nombre 
        -String correoInstitucional 
        +getCorreoInstitucional() String 
    } 
 
    class Asignatura { 
        -Long idAsignatura 
        -String codigoMateria 
        -int totalClasesProgramadas 
        +getTotalClasesProgramadas() int 
    } 
 
    class RegistroAsistencia { 
        -Long idRegistro 
        -LocalDate fechaClase 
        -boolean esPresente 
        +esPresente() boolean 
    } 
 
    class Alerta { 
        -Long idAlerta 
        -String tipoAlerta 
        -LocalDateTime fechaGeneracion 
        +getTipoAlerta() String 
    } 
 
    %% Clases de Lógica y Servicios (Fase de Ingeniería / SOLID) 
    class EvaluadorInasistencia { 
        +evaluarAlertaRoja(int totalClases, int inasistencias) boolean
+evaluarAlertaAmarilla(double promedio) boolean 
} 
class GestorAlertas { 
+procesarEstudiante(Estudiante estudiante) List~Alerta~ 
} 
class ServicioNotificacion { 
+enviarNotificacion(Alerta alerta) boolean 
}
