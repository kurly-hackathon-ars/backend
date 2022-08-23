package com.crawling.item.service;

import com.crawling.item.dto.ActionDto;
import com.crawling.item.entity.ActivityLogs;
import com.crawling.item.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DummyService {

    private final ActivityLogRepository activityLogRepository;
    private final KafkaProducer kafkaProducer;

    @Transactional
    public void saveDummyDataInKafkaAndDatabase(ActionDto actionDto) {
        ActivityLogs activityLogs = actionDto.toActivityLogsEntity();

        activityLogRepository.save(activityLogs);

        ActionDto fullActionResponse = ActionDto.builder()
                .id(activityLogs.getNo())
                .memberId(activityLogs.getMemberId())
                .productId(activityLogs.getProductId())
                .actionType(activityLogs.getType())
                .createdDate(activityLogs.getCreatedTime())
                .build();

        kafkaProducer.sendMessage(fullActionResponse.toString());

    }

}
