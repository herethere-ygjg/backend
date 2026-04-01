package com.YGJG.hereThere.domain.place.entity;

import com.YGJG.hereThere.domain.folder.entity.FolderPlace;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "place",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_place_kakao_place_id", columnNames = "kakao_place_id")
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class  Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kakao_place_id", nullable = false, length = 64)
    private String kakaoPlaceId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 255)
    private String address;

    @Column(nullable = false, precision = 15, scale = 10)
    private BigDecimal latitude;

    @Column(nullable = false, precision = 15, scale = 10)
    private BigDecimal longitude;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "place")
    private List<FolderPlace> folderPlaces = new ArrayList<>();
}
