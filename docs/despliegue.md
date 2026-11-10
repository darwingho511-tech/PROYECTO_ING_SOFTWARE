```mermaid 
architecture-beta 
    group cliente(cloud)[Cliente / Dispositivo] 
    group github(cloud)[Entorno DevOps CI/CD] 
    group servidor(server)[Servidor de Aplicación - Staging] 
    group bd(database)[Servidor de Datos] 
    service browser(internet) in cliente [Navegador Web / App] 
    service runner(server) in github [GitHub Actions Runner] 
    service app(server) in servidor [SATE Application Server - Java 17 Spring] 
    service postgres(database) in bd [PostgreSQL Database Engine]
 browser:R -- L:app 
    runner:B -- T:app 
    app:R -- L:postgres 
```
