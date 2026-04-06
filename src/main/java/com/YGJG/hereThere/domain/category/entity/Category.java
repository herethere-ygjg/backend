package com.YGJG.hereThere.domain.category.entity;

import com.YGJG.hereThere.domain.folder.entity.FolderCategory;
import com.YGJG.hereThere.domain.user.entity.UserInterest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<FolderCategory> folderCategories = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<UserInterest> userInterests = new ArrayList<>();
}
