package com.example.server.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="task_id")
    private UUID id;
    private String title;
    private String description;
    private Integer priority;
    private TaskType type;

    @Column(name = "created_by_user_id")
    private UUID createdBy;

    @ElementCollection
    @CollectionTable(name = "assigned_to", joinColumns = @JoinColumn(name = "task_id"))
    @Column(name = "user_id")
    private Set<UUID> assignedTo = new HashSet<>();

    private LocalDateTime createdAt;
    private Integer estimatedHours;
    private LocalDateTime completedAt;
    @Enumerated(EnumType.STRING)
    private CompletionStatus completionStatus;


//    @OneToMany(mappedBy = "parentTask")
//    private List<Task> subTasks;
    //one Task (parent task) can have many subTasks.
    //The mappedBy = "parentTask" part refers to the field in the Task entity that owns the relationship (the other side of the relationship).

    @Column(name = "parent_task_id")
    private UUID parentTaskId;

    @Column(name = "project_id")
    private UUID projectId;


}
