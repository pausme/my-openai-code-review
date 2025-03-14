package com.huang.middleware.sdk.domain.model;

import java.util.HashMap;
import java.util.Map;

public class Message {

    private String touser = "ole_r6MiK3pHCz0-t9sSL_qrI1g4";
    private String template_id = "0dBfC8flXQ3WLRoWGG0yfy13bHoCA-rZxJJRZ0DMGDs";
    private String url = "https://github.com/pausme/my-openai-code-review-log/blob/main/2025-03-14/kpyjQyXnXoww.md";
    private Map<String, Map<String, String>> data = new HashMap<>();

    public void put(String key, String value) {
        data.put(key, new HashMap<String, String>() {
            private static final long serialVersionUID = 7092338402387318563L;

            {
                put("value", value);
            }
        });
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }

}
