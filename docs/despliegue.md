# Diagrama de Despliegue - SATE-UNIAJC

```mermaid
graph TD
subgraph ClientNode ["Nodo Cliente"]
    UI["Interfaz Web"]
end

subgraph GitHubNode ["Nodo CI CD"]
    Runner["GitHub Actions Runner"]
end

subgraph AppServerNode ["Servidor de Aplicacion"]
    MVC["SATE Core Engine"]
end

subgraph DBNode ["Base de Datos"]
    DB[(Data Store)]
end

UI --> MVC
Runner --> MVC
MVC --> DB
