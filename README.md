# 🛡️ Moderation Service

![Java](https://img.shields.io/badge/Java-17+-green?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot)
![Maven](https://img.shields.io/badge/Maven-Build-blue?style=flat-square&logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)

🚀 **Moderation Service** es un microservicio construido con Spring Boot para filtrar mensajes en tiempo real, evitando spam, lenguaje ofensivo y links maliciosos. Utiliza un modelo de aprendizaje automático para mejorar la moderación.

---

## ✨ Características

- ✅ **Filtrado de mensajes** basado en listas negras y un modelo preentrenado.
- ⚡ **API REST** para validar mensajes en tiempo real.
- 🔗 **Integración sencilla** con sistemas de mensajería existentes.
- 🛠️ Configurable con finales de línea normalizados.

---

## 📂 Estructura del Proyecto

```plaintext
moderation-service/
├── src/
│   ├── main/
│   │   ├── java/com/moderation/  # Código fuente principal
│   │   ├── resources/            # Configuración y archivos estáticos
│   └── test/                     # Pruebas unitarias
├── .gitignore
├── .gitattributes
├── mvnw, mvnw.cmd                # Scripts para usar Maven Wrapper
├── pom.xml                       # Configuración de dependencias
