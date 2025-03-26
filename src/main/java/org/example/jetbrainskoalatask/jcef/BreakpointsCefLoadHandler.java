package org.example.jetbrainskoalatask.jcef;

import org.example.jetbrainskoalatask.service.BreakpointService;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.handler.CefLoadHandler;
import org.cef.network.CefRequest;

public class BreakpointsCefLoadHandler implements CefLoadHandler {
    private BreakpointService breakpointService;

    public BreakpointsCefLoadHandler(BreakpointService breakpointService) {
        this.breakpointService = breakpointService;
    }

    @Override
    public void onLoadingStateChange(CefBrowser browser, boolean isLoading, boolean canGoBack, boolean canGoForward) {

    }

    @Override
    public void onLoadStart(CefBrowser browser, CefFrame frame, CefRequest.TransitionType transitionType) {

    }

    @Override
    public void onLoadEnd(CefBrowser browser, CefFrame frame, int httpStatusCode) {
        breakpointService.loadAllBreakpointsToWindow();
    }

    @Override
    public void onLoadError(CefBrowser browser, CefFrame frame, ErrorCode errorCode, String errorText, String failedUrl) {

    }
}
