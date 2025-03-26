package org.example.jetbrainskoalatask.service.impl;

import org.example.jetbrainskoalatask.jcef.BreakpointDetails;
import org.example.jetbrainskoalatask.mapper.BreakpointMapper;
import org.example.jetbrainskoalatask.service.BreakpointService;
import org.example.jetbrainskoalatask.service.JCefService;
import com.intellij.xdebugger.breakpoints.XBreakpoint;
import com.intellij.xdebugger.breakpoints.XBreakpointManager;

import java.util.LinkedList;
import java.util.List;

public class BreakpointServiceImpl implements BreakpointService {
    private JCefService jCefService;
    private XBreakpointManager breakpointManager;
    private BreakpointMapper breakpointMapper;


    public BreakpointServiceImpl(XBreakpointManager breakpointManager, JCefService jCefService,
                                 BreakpointMapper breakpointMapper) {
        this.breakpointManager = breakpointManager;
        this.jCefService = jCefService;
        this.breakpointMapper = breakpointMapper;
    }

    @Override
    public void loadAllBreakpointsToWindow() {
        XBreakpoint<?>[] breakpoints = breakpointManager.getAllBreakpoints();

        List<BreakpointDetails> breakpointDetailsList = new LinkedList<>();

        for (XBreakpoint breakpoint : breakpoints) {
            breakpointDetailsList.add(breakpointMapper.breakpointToBreakpointDetails(breakpoint));
        }

        jCefService.executeJavaScript("window.loadBreakpoints", breakpointDetailsList);
    }

    @Override
    public void addBreakpointToWindow(XBreakpoint breakpoint) {
        jCefService.executeJavaScript("window.addBreakpoint", breakpointMapper.breakpointToBreakpointDetails(breakpoint));
    }

    @Override
    public void removeBreakpointFromWindow(XBreakpoint breakpoint) {
        jCefService.executeJavaScript("window.removeBreakpoint", breakpointMapper.breakpointToBreakpointDetails(breakpoint));
    }

    @Override
    public void updateBreakpoint(XBreakpoint breakpoint) {
        jCefService.executeJavaScript("window.updateBreakpoint", breakpointMapper.breakpointToBreakpointDetails(breakpoint));
    }
}
