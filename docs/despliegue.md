# Diagrama de Despliegue - SATE-UNIAJC

```mermaid
graph TD
subgraph ClientNode [Nodo Cliente]
    UI [Interfaz de Usuario SATE]
end

subgraph GitHubNode [Nodo CI CD]
    Runner [Runner Linux Maven JDK 17]
end

subgraph AppServerNode [Nodo Servidor de Aplicacion]
    MVC [Controladores y Servicios SATE Core]
end

subgraph DBNode [Nodo Servidor de Base de Datos]
    DB [(PostgreSQL Data Store)]
end

UI --> MVC
Runner --> MVC
MVC --> DB
