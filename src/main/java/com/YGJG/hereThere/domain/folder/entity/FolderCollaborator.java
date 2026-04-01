package com.YGJG.hereThere.domain.folder.entity;

import com.YGJG.hereThere.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "folder_collaborator")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FolderCollaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private FolderCollaboratorRole role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private FolderCollaboratorStatus status;

    @Column(name = "invited_by", nullable = false)
    private Long invitedBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
