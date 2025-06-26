# Resume Editor - Java Spring Boot Backend

This is the backend for a Resume Editor application built using **Java Spring Boot**. It provides APIs to upload, enhance, and save resumes.

---

## 📦 Features

- ✅ Upload `.pdf` or `.docx` file (mock parse to JSON)
- ✅ Enhance resume content using a mock AI engine
- ✅ Save the entire resume object to memory

---

## 📁 Project Structure

resume-editor-java/
├── pom.xml
└── src/main/java/com/example/resumeeditor/
├── ResumeEditorApplication.java
├── controller/ResumeController.java
└── model/
├── EnhanceRequest.java
└── Resume.java
