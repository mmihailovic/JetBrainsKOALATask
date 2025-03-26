package org.example.jetbrainskoalatask.service.impl;

import org.example.jetbrainskoalatask.service.JCefService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.ui.jcef.JBCefBrowser;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JCefServiceImpl implements JCefService {
    private JBCefBrowser browser;
    private ObjectMapper objectMapper;

    public JCefServiceImpl(JBCefBrowser browser, ObjectMapper objectMapper) {
        this.browser = browser;
        this.objectMapper = objectMapper;
    }

    @Override
    public void executeJavaScript(String methodName, Object arguments) {
        try {
            String script = methodName + "(" + objectMapper.writeValueAsString(arguments) + ");";
            browser.getCefBrowser().executeJavaScript(script, browser.getCefBrowser().getURL(), 0);
        } catch (JsonProcessingException e) {
            Logger.getGlobal().log(Level.SEVERE, "Error executing java script!");
        }
    }
}
