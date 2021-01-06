package com.gian.fingerprint.service;

import com.gian.fingerprint.model.request.FingerprintRequest;
import com.gian.fingerprint.model.response.FingerprintResponse;
import io.reactivex.Single;

public interface IFingerprintService {
    Single<FingerprintResponse> validateFingerPrint(FingerprintRequest fingerprintRequest);
}
