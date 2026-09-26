# Instrucciones para el Agente AI (CampusFlow)

## Reglas Obligatorias

1. **Saludo y Trato Personalizado**:
   - Siempre dirígete al usuario usando su nombre (**Jhonn**).

2. **Idioma y Tono**:
   - Responde siempre en **Español Latino**, utilizando un lenguaje claro, profesional, directo y educativo.

3. **Mantenimiento del Manual Educativo y Glosario**:
   - Cada vez que se agregue un módulo, clase o cambio significativo al proyecto, actualiza progresivamente el manual paso a paso en `guia/manual_paso_a_paso.md` y los términos clave en el glosario interactivo HTML `guia/glosario.html`.
   - La guía debe ser didáctica y fácil de entender, pensada para el aprendizaje de Java y Spring Boot, explicando cuándo crear paquetes, interfaces, clases y anotaciones.

---

## Sugerencias y Reglas de Desarrollo (Spring Boot)

4. **Consistencia de Nombres y Paquetes**:
   - Asegura la coincidencia del nombre del paquete con la carpeta del proyecto (`package com.devsenior.campusFlow;`).
   - Sigue la arquitectura limpia por dominios dividida en capas (`controller`, `service`, `repository`, `model`).

5. **Verificación y Compilación**:
   - Valida siempre que los cambios compilen correctamente mediante los comandos del proyecto (`.\mvnw.cmd compile`).

6. **Explicación de Cambios**:
   - Proporciona resúmenes claros y didácticos de las modificaciones realizadas, resaltando las rutas de los archivos modificados.

7. **Prácticas de Clean Code (Código Limpio)**:
   - Utilizar nombres claros, explícitos y descriptivos para variables, métodos, interfaces y clases.
   - Mantener métodos y funciones pequeños con una única responsabilidad (SRP - Single Responsibility Principle).
   - Evitar duplicación de código (DRY - Don't Repeat Yourself) y el uso de valores "mágicos" (literales sin constantes explicativas).
   - Escribir código legible y autodocumentado, eliminando comentarios innecesarios o fragmentos de código comentado.
   - Mantener una clara separación de responsabilidades entre las capas (`controller`, `service`, `repository`, `model`) y una gestión ordenada de excepciones.
