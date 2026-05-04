package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "NOTES")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String type;     // text, pdf, excel, image

    @Column(columnDefinition = "TEXT")
    private String content;  // for text notes

    private String filename;
    private String noteDate;

    @Column(columnDefinition = "CLOB")
    private String fileData; // base64 encoded file data

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public String getNoteDate() { return noteDate; }
    public void setNoteDate(String noteDate) { this.noteDate = noteDate; }

    public String getFileData() { return fileData; }
    public void setFileData(String fileData) { this.fileData = fileData; }
}