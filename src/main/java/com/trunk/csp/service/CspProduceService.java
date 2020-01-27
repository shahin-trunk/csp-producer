package com.trunk.csp.service;

import com.trunk.csp.document.CarServiceProvider;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
@Slf4j
public class CspProduceService {

    private final KafkaTemplate<String, CarServiceProvider> cspProduceTemplate;

    public void produce(CarServiceProvider carServiceProvider) {
        final ListenableFuture<SendResult<String, CarServiceProvider>> sendResultListenableFuture = cspProduceTemplate.sendDefault(carServiceProvider);
        sendResultListenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, CarServiceProvider>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Failed producing new CarServiceProvider.", throwable);
            }

            @Override
            public void onSuccess(SendResult<String, CarServiceProvider> sendResult) {
                log.debug(sendResult.toString());
            }
        });
    }
}
