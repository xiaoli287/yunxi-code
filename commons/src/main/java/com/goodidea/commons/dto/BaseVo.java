package com.goodidea.commons.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class BaseVo
        implements Serializable {
    private Map<String, Object> extFields = new HashMap<String, Object>();

    public Map<String, Object> getExtFields() {
        return this.extFields;
    }

    public void setExtFields(Map<String, Object> extFields) {
        this.extFields = extFields;
    }
}

