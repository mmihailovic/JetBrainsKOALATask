package org.example.jetbrainskoalatask.toolwindow;

import org.example.jetbrainskoalatask.jcef.BreakpointsCefLoadHandler;
import org.example.jetbrainskoalatask.listener.BreakpointListener;
import org.example.jetbrainskoalatask.mapper.BreakpointMapper;
import org.example.jetbrainskoalatask.service.BreakpointService;
import org.example.jetbrainskoalatask.service.impl.BreakpointServiceImpl;
import org.example.jetbrainskoalatask.service.impl.JCefServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.openapi.project.Project;
import com.intellij.ui.jcef.JBCefBrowser;
import com.intellij.xdebugger.XDebuggerManager;
import com.intellij.xdebugger.breakpoints.XBreakpointManager;
import com.intellij.xdebugger.breakpoints.XBreakpointType;

import javax.swing.*;

public class BreakpointPanel extends JPanel {

    private JBCefBrowser browser;
    private ObjectMapper objectMapper;
    private BreakpointService breakpointService;

    public BreakpointPanel(Project project) {
        this.browser = new JBCefBrowser("http://localhost:3000/");
        this.objectMapper = new ObjectMapper();
        this.breakpointService = new BreakpointServiceImpl(XDebuggerManager.getInstance(project).getBreakpointManager(),
                new JCefServiceImpl(browser, objectMapper), new BreakpointMapper());

        BreakpointsCefLoadHandler breakpointsCefLoadHandler = new BreakpointsCefLoadHandler(breakpointService);
        browser.getJBCefClient().addLoadHandler(breakpointsCefLoadHandler, browser.getCefBrowser());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addBreakpointListener(project);
        add(browser.getComponent());
    }

    private void addBreakpointListener(Project project) {
        XBreakpointManager breakpointManager = XDebuggerManager.getInstance(project).getBreakpointManager();

        // add breakpoint listener for each breakpoint type
        for(XBreakpointType type: XBreakpointType.EXTENSION_POINT_NAME.getExtensions()) {
            breakpointManager.addBreakpointListener(type, new BreakpointListener(breakpointService::addBreakpointToWindow, breakpointService::removeBreakpointFromWindow, breakpointService::updateBreakpoint));
        }
    }
}
