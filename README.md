# Reparaciones API

## 🏗️ Arquitectura

Este proyecto sigue una **Clean Architecture** (Arquitectura Limpia) con separación de responsabilidades:

```
src/main/java/com/reparaciones/
├── api/                    # Adaptadores de entrada (REST Controllers, DTOs)
├── application/            # Lógica de aplicación (use cases, services)
├── domain/                 # Entidades y reglas de negocio puras
└── infrastructure/         # Implementaciones externas (JPA, repositorios)
```

### Capas del sistema:

1. **Domain** - Entidades y lógica de negocio pura, sin dependencias externas
2. **Application** - Casos de uso y servicios de aplicación
3. **Infrastructure** - Adaptadores de salida (JPA, base de datos)
4. **Interface/API** - Adaptadores de entrada (REST controllers, DTOs)

## 🚀 Cómo ejecutar el proyecto

### Prerrequisitos:
- Java 17
- Maven
- PostgreSQL

### Pasos para ejecutar:

1. **Configurar la base de datos:**
   ```bash
   # Crear la base de datos (si no existe)
   createdb reparaciones_db
   
   # O usar el script proporcionado
   psql -U postgres -f schema.sql
   ```

2. **Configurar las propiedades de la aplicación:**
   El proyecto usa `application.properties` por defecto. Revise y ajuste según su entorno:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/reparaciones_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

3. **Compilar y ejecutar:**
   ```bash
   # Compilar el proyecto
   mvn clean install
   
   # Ejecutar la aplicación
   mvn spring-boot:run
   ```

   O directamente con el wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

### Endpoints disponibles:

Una vez ejecutada la aplicación, puede acceder a:
- **API Documentation (Swagger UI):** http://localhost:8080/swagger-ui.html
- **API Endpoints:** http://localhost:8080/api/

## 📦 Dependencias principales

- Spring Boot 4.0.6
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Lombok (para reducir boilerplate)
- SpringDoc OpenAPI (Swagger) para documentación API
- Spring Boot DevTools (para desarrollo)

## 🧪 Testing

Para ejecutar los tests:
```bash
mvn test
```

## 📋 Estructura de paquetes

```
com.reparaciones.api
├── controller      # REST Controllers
├── dto             # Data Transfer Objects
├── config          # Configuración (Swagger, etc.)
└── infrastructure  # Capa de infraestructura
    └── persistence # Persistencia (JPA entities, repositories)

com.reparaciones.domain
├── model           # Entidades de dominio
└── repository      # Interfaces de repositorio

com.reparaciones.application
└── service         # Servicios de aplicación

## 🔧 Desarrollo

El proyecto usa:
- **Lombok** para generar getters, setters, constructores, etc.
- **MapStruct** (implícito en algunos DTOs) para mapeo entre entidades y DTOs
- **Validación Bean Validation** (annotations @NotNull, @Size, etc.)

## 📝 Licencia

Este proyecto está bajo licencia privada.

---

## 🚧 Roadmap

### ✅ Implementado (Core)
- [x] Gestión de órdenes de reparación (CRUD básico)
- [x] Estados de orden con historial
- [x] Clientes y dispositivos
- [x] API REST documentada con Swagger
- [x] Inventario de repuestos con stock mínimo

### 🔜 Por implementar (Prioridad Alta)
- [ ] Presupuestos y aprobación de clientes
- [ ] Pagos parciales y generación de recibos PDF
- [ ] Fotos del equipo al recibir
- [ ] Checklist de recepción

### 📋 Planeado (Media Prioridad)
- [ ] Código QR / ticket público para seguimiento
- [ ] Seguimiento automático por WhatsApp/SMS
- [ ] Control de técnicos y métricas
- [ ] Garantías y reingresos
- [ ] Reportes y dashboard de estadísticas
- [ ] Autenticación JWT
- [ ] Roles y permisos (admin, recepcionista, técnico, cajero)

### 🔮 Futuro (Baja Prioridad)
- [ ] Multi-sucursal con transferencia de stock
- [ ] Sistema anti fraude / auditoría
- [ ] WebSockets para actualizaciones en tiempo real

---

## 🎯 Endpoints actuales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/clientes | Listar clientes |
| POST | /api/clientes | Crear cliente |
| GET | /api/clientes/{id} | Obtener cliente |
| PUT | /api/clientes/{id} | Actualizar cliente |
| DELETE | /api/clientes/{id} | Eliminar cliente |
| GET | /api/ordenes | Listar órdenes |
| POST | /api/ordenes | Crear orden |
| PUT | /api/ordenes/{id}/estado | Cambiar estado |
| GET | /api/repuestos | Listar repuestos |
| POST | /api/repuestos | Crear repuesto |
| GET | /api/repuestos/bajo-stock | Repuestos bajo stock mínimo |