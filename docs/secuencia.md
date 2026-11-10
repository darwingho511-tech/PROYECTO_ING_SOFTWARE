# Diagrama de Secuencia - SATE-UNIAJC

```mermaid
sequenceDiagram
autonumber
actor Docente as Docente / Sistema
participant Controller as EstudianteController
participant Gestor as GestorAlertas
participant Evaluador as Evaluador Inasistencia
participant Notificador as ServicioNotificacion
participant Repo as Estudiante Repository
participant AlertaRepo as AlertaRepository

Docente->>Controller: registrarAsistencia (idEstudiante, fecha, esPresente)
Controller->>Repo: buscarEstudiantePorId(idEstudiante)
Repo-->>Controller: objetoEstudiante
Controller->>Gestor: procesarEstudiante(objetoEstudiante)
activate Gestor
Gestor->>Evaluador: evaluarAlertaRoja(totalClases, inasistencias)
activate Evaluador
Evaluador-->>Gestor: boolean (true Alerta Roja)
deactivate Evaluador
alt Requiere Generar Alerta
    Gestor->>AlertaRepo: guardar(alerta)
    activate AlertaRepo
    AlertaRepo-->>Gestor: confirmacionGuardado
    deactivate AlertaRepo
end
Gestor->>Notificador: enviarNotificacion(nuevaAlerta)
activate Notificador
Notificador-->>Gestor: exitoNotificacion(true)
deactivate Notificador
Gestor-->>Controller: listaAlertasGeneradas
deactivate Gestor
Controller-->>Docente: Respuesta HTTP 200 (OK + Alertas)
