package com.YGJG.hereThere.domain.place.entity;

import com.YGJG.hereThere.domain.folder.entity.FolderPlace;
import com.YGJG.hereThere.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "place_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlacePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_place_id", nullable = false)
    private FolderPlace folderPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploader_user_id", nullable = false)
    private User uploader;

    @Column(name = "image_url", nullable = false, length = 512)
    private String imageUrl;

    @Column(nullable = false, length = 255)
    private String comment;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
