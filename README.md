# Interbanking Challenge

## Consigna:

Generar los siguientes 3 endpoints:
- Uno que traiga las empresas que hicieron transferencias el último mes
- Otro que traiga las empresas que se adhirieron el ultimo mes.
- El ultimo que haga la adhesión de una empresa.
  
*Deseable*: usar hexagonal.


Base: puede usarse relacional o no relacional

Datos de la empresa: Cuit, razón social, fecha adhesión

Datos de la transferencia: importe, id empresa, cuenta debito, cuenta crédito

Si falto algo asumirlo y cuando envía el texto que envíe lo que asumió

## Trabajo realizado:

Base de datos utilizada: H2 (Base de datos en memoria)

### Entidades creadas:

**Empresa (Company):**
- cuit
- razón social (businessName)
- fecha adhesión (created_at)

**Transferencia (Transference):**
- importe (amount)
- id empresa (company_id)
- cuenta debito (debit_account)
- cuenta crédito (credit_account)

### Extras:

- Se agregó pruebas unitarias básicas de los servicios con JUNIT
- Documentación con Swagger de los endpoints existentes (http://localhost:8080/swagger-ui.html)
- Se utiliza Lombok para crear setter y getter de los objetos
- Se utiliza MapStruct para mappear las entidades a sus dtos de consulta/respuesta
- Se utiliza JPA para crear las entidades y realizar la manipulación de los datos
- Se utilizó Spring Validation para validar las entradas de los parámetros en los endpoints