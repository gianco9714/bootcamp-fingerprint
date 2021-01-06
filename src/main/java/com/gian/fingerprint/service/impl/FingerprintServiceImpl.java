package com.gian.fingerprint.service.impl;

import com.gian.fingerprint.model.request.FingerprintRequest;
import com.gian.fingerprint.model.response.FingerprintResponse;
import com.gian.fingerprint.service.IFingerprintService;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

@Service
public class FingerprintServiceImpl implements IFingerprintService {
    @Override
    public Single<FingerprintResponse> validateFingerPrint(FingerprintRequest fingerprintRequest) {
        FingerprintResponse response = new FingerprintResponse();
        response.setSuccess(true);
        response.setEntityName("Core");

        return Single.just(response);
    }
}
