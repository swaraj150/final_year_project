package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "time_log_id")
    private Integer id;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
//    A user can log time across multiple timelog entries.
//    Each timelog entry is associated with a single user.
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id")
//    A task can have multiple time logs associated with it.
//    Each timelog entry is associated with a single task.
    private Task task;

    @ManyToOne
    @JoinColumn(name = "project_id")
//    A project can have multiple time logs associated with it.
//    Each timelog entry is associated with a single project.
    private Project project;

    private LocalDate date;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime updatedAt;
}
