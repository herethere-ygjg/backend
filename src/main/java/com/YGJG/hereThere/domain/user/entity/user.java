package com.YGJG.hereThere.domain.user.entity;

import com.YGJG.hereThere.domain.auth.entity.UserOauth;
import com.YGJG.hereThere.domain.folder.entity.Folder;
import com.YGJG.hereThere.domain.folder.entity.FolderCollaborator;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`user`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UserStatus status;

    @Column(length = 255)
    private String email;

    @Column(length = 50)
    private String nickname;

    @Column(length = 20)
    private String phone;

    @Column(length = 10)
    private String gender;

    @Column(name = "profile_image_url", length = 512)
    private String profileImageUrl;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "follower_count", nullable = false)
    private Long followerCount = 0L;

    @OneToMany(mappedBy = "owner")
    private List<Folder> folders = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserOauth> oauthAccounts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserInterest> interests = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<FolderCollaborator> collaborations = new ArrayList<>();
}
