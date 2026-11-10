# Diagrama de Despliegue - SATE-UNIAJC

```mermaid
graph TD
subgraph ClientNode ["Nodo Cliente (Navegador Web / App Móvil)"]
    UI ["Interfaz de Usuario SATE (HTML5 / Bootstrap)"]
end

subgraph GitHubNode ["Nodo CI/CD (GitHub Actions)"]
    Runner ["Runner Linux (Maven + JDK 17 + JUnit 5)"]
end

subgraph AppServerNode ["Nodo Servidor de Aplicación (Staging Cloud/Docker)"]
    MVC ["Controladores & Servicios (SATE Core Engine)"]
end

subgraph DBNode ["Nodo Servidor de Base de Datos"]
    DB [("PostgreSQL / MySQL Data Store")]
end

UI -->|HTTPS / REST API| MVC
Runner -->|Automated Deployment / SSH| MVC
MVC -->|JDBC / SQL Connection| DB
