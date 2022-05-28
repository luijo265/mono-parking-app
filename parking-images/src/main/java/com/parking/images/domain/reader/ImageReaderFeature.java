package com.parking.images.domain.reader;

import java.util.Map;

public interface ImageReaderFeature {

    Map<String, String> readFeatureFromImageBase64(String base64);

}
