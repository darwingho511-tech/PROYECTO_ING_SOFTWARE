# Diagrama de Despliegue - SATE-UNIAJC

```mermaid
graph TD
subgraph ClientNode ["Nodo Cliente (Navegador Web)"]
    UI ["Interfaz de Usuario SATE (HTML5)"]
end

subgraph GitHubNode ["Nodo CI/CD (GitHub Actions)"]
    Runner ["Runner Linux (Maven + JDK 17)"]
end

subgraph AppServerNode ["Nodo Servidor de Aplicacion (Staging)"]
    MVC ["Controladores y Servicios (SATE Core Engine)"]
end

subgraph DBNode ["Nodo Servidor de Base de Datos"]
    DB [("PostgreSQL / MySQL Data Store")]
end

UI --> MVC
Runner --> MVC
MVC --> DB
