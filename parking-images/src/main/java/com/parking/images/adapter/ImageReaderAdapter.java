package com.parking.images.adapter;

import com.parking.images.domain.reader.ImageReaderFeature;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

public class ImageReaderAdapter implements ImageReaderFeature {

    private final Log LOGGER = LogFactory.getLog(ImageReaderAdapter.class);

    private List<Map<String, String>> results;

    public ImageReaderAdapter() {
        results = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("placa", "1c3d2s");
        map1.put("marco", "toyota");
        map1.put("modelo", "Union");
        map1.put("puertas", "5");
        map1.put("cilindraje", "140");
        Map<String, String> map2 = new HashMap<>();
        map2.put("placa", "111222");
        map2.put("marco", "renoult");
        map2.put("modelo", "kwid");
        map2.put("puertas", "3");
        map2.put("cilindraje", "120");
        results.add(map1);
        results.add(map2);

    }

    @Override
    public Map<String, String> readFeatureFromImageBase64(String base64) {
        LOGGER.info("");
        return null;
    }
}
