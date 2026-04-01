package com.YGJG.hereThere.domain.folder.entity;

import com.YGJG.hereThere.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folder")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_user_id", nullable = false)
    private User owner;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "thumbnail_url", length = 512)
    private String thumbnailUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Visibility visibility;

    @Column(name = "place_count", nullable = false)
    private int placeCount = 0;

    @Column(name = "avg_rating")
    private BigDecimal avgRating = BigDecimal.ZERO;

    @Column(name = "view_count", nullable = false)
    private int viewCount = 0;

    @Column(name = "scrap_count", nullable = false)
    private int scrapCount = 0;

    @Column(name = "share_count", nullable = false)
    private int shareCount = 0;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "folder")
    private List<FolderCollaborator> collaborators = new ArrayList<>();

    @OneToMany(mappedBy = "folder")
    private List<FolderCategory> folderCategories = new ArrayList<>();

    @OneToMany(mappedBy = "folder")
    private List<FolderPlace> folderPlaces = new ArrayList<>();
}
