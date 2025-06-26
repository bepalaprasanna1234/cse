package com.example.resumeeditor.controller;

import com.example.resumeeditor.model.EnhanceRequest;
import com.example.resumeeditor.model.Resume;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ResumeController {

    private Resume savedResume = new Resume();

    @PostMapping("/ai-enhance")
    public Map<String, String> enhance(@RequestBody EnhanceRequest req) {
        String improved = "[Enhanced] " + req.getContent();
        Map<String, String> result = new HashMap<>();
        result.put("improved_content", improved);
        return result;
    }

    @PostMapping("/save-resume")
    public Map<String, String> saveResume(@RequestBody Resume resume) {
        this.savedResume = resume;
        return Map.of("status", "saved");
    }

    @PostMapping("/upload-resume")
    public ResponseEntity<Resume> uploadFile(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        if (filename == null || !(filename.endsWith(".pdf") || filename.endsWith(".docx"))) {
            return ResponseEntity.badRequest().build();
        }

        // Return dummy parsed content
        Resume dummy = new Resume();
        dummy.setName("Jane Doe");
        dummy.setSummary("Motivated professional with a strong background in software development.");
        dummy.setExperience("[{\"company\": \"Tech Ltd\", \"role\": \"Engineer\", \"duration\": \"2020-2023\"}]");
        dummy.setEducation("[{\"institution\": \"ABC College\", \"degree\": \"B.Sc IT\", \"year\": \"2019\"}]");
        dummy.setSkills("[\"JavaScript\", \"React\", \"Node.js\"]");

        return ResponseEntity.ok(dummy);
    }
}
