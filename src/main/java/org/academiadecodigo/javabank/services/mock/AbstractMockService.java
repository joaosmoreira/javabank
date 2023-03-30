package org.academiadecodigo.javabank.services.mock;

import org.academiadecodigo.javabank.persistence.model.AbstractModel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMockService<T extends AbstractModel> {

    protected Map<Integer, T> modelMap = new HashMap<>();

    protected Integer getNextId() {
        return modelMap.isEmpty() ? 1 : Collections.max(modelMap.keySet()) + 1;
    }
}
