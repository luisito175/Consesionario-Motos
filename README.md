# MotoRecyclerApp

## Descripción
**MotoRecyclerApp** es una aplicación Android que muestra un listado de motos en un `RecyclerView` horizontal. Cada item contiene información detallada de la moto, incluyendo:

- Marca
- Modelo
- Características técnicas
- Imagen

La app permite simular acciones de **eliminar** y **actualizar** motos mediante botones en cada item, utilizando funciones en el `Controller` para manejar los eventos.

---

## Tecnologías
- **Kotlin**: Lenguaje principal
- **Android SDK**: Desarrollo nativo
- **RecyclerView**: Para mostrar la lista horizontal de motos
- **Glide**: Para cargar imágenes desde internet
- **ViewHolder y Adapter**: Patrón de diseño para listas
- **FrameLayout y Toolbar**: Diseño de interfaz
- **Funciones de orden superior (lambdas)**: Para manejar listeners de botones

---

## Funcionalidades

1. **Lista horizontal de motos**:  
   - Se puede deslizar horizontalmente para ver todas las motos.
2. **Carga de imágenes desde internet** con Glide.
3. **Botones de acción por item**:  
   - **Actualizar**: Llama a la función `updateMoto(pos)` en el `Controller`.  
   - **Eliminar**: Llama a la función `delMoto(pos)` en el `Controller`.
4. **Toolbar superior**: Muestra el nombre de la aplicación.
5. **Botón flotante (ImageButton)**: Posicionado sobre el RecyclerView, listo para agregar nuevas motos.

---

## Cómo ejecutar

1. Clonar el repositorio:
```bash
git clone https://github.com/tu_usuario/MotoRecyclerApp.git
```

[Video Demostrativo](https://github.com/tu_usuario/MotoRecyclerApp)
