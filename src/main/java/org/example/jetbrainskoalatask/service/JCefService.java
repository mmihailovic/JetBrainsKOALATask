package org.example.jetbrainskoalatask.service;

public interface JCefService {

    /**
     * This method executes specified javascript method with specified arguments in JCef browser
     * @param methodName name of the method to be executed
     * @param arguments arguments for the method
     */
    void executeJavaScript(String methodName, Object arguments);
}
