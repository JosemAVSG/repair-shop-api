-- Sistema de Reparación de Celulares - Schema PostgreSQL

-- Tablas principales
CREATE TABLE marcas (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    categoria VARCHAR(20) NOT NULL CHECK (categoria IN ('CELULARES', 'LINEA_BLANCA')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

CREATE TABLE modelos (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    marca_id BIGINT NOT NULL REFERENCES marcas(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

CREATE TABLE componentes (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    modelo_id BIGINT NOT NULL REFERENCES modelos(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

CREATE TABLE clientes (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

CREATE TABLE dispositivos (
    id BIGSERIAL PRIMARY KEY,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('CELULAR', 'MICROONDAS', 'NEVERA', 'COCINA', 'LAVADORA')),
    modelo_id BIGINT NOT NULL REFERENCES modelos(id),
    cliente_id BIGINT NOT NULL REFERENCES clientes(id),
    numero_serie VARCHAR(50),
    imei VARCHAR(20),
    notas_tecnicas TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

CREATE TABLE ordenes_trabajo (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL REFERENCES clientes(id),
    dispositivo_id BIGINT NOT NULL REFERENCES dispositivos(id),
    estado VARCHAR(30) NOT NULL DEFAULT 'REGISTRO',
    fallo_reportado TEXT,
    precio_total DECIMAL(10,2),
    fecha_entrada TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_salida TIMESTAMP,
    notas TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

CREATE TABLE reparaciones (
    id BIGSERIAL PRIMARY KEY,
    orden_id BIGINT NOT NULL REFERENCES ordenes_trabajo(id) ON DELETE CASCADE,
    tipo VARCHAR(30) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

CREATE TABLE tarifas (
    id BIGSERIAL PRIMARY KEY,
    marca_id BIGINT REFERENCES marcas(id),
    modelo_id BIGINT REFERENCES modelos(id),
    tipo VARCHAR(30) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    activa BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

CREATE TABLE historial (
    id BIGSERIAL PRIMARY KEY,
    entidad_tipo VARCHAR(30) NOT NULL,
    entidad_id BIGINT NOT NULL,
    contenido TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

-- Índices para mejorar performance
CREATE INDEX idx_modelos_marca ON modelos(marca_id);
CREATE INDEX idx_componentes_modelo ON componentes(modelo_id);
CREATE INDEX idx_dispositivos_cliente ON dispositivos(cliente_id);
CREATE INDEX idx_ordenes_cliente ON ordenes_trabajo(cliente_id);
CREATE INDEX idx_ordenes_estado ON ordenes_trabajo(estado);
CREATE INDEX idx_reparaciones_orden ON reparaciones(orden_id);
CREATE INDEX idx_tarifas_modelo ON tarifas(modelo_id);
CREATE INDEX idx_tarifas_marca ON tarifas(marca_id);
CREATE INDEX idx_historial_entidad ON historial(entidad_tipo, entidad_id);