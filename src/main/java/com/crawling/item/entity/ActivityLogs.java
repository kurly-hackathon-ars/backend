package com.crawling.item.entity;

import com.crawling.item.dto.enums.ActionType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Builder
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "activity_logs")
public class ActivityLogs {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String memberId;

    private Long productId;

    @Enumerated(EnumType.STRING)
    private ActionType type;

    @CreatedDate
    private LocalDateTime createdTime;
}
