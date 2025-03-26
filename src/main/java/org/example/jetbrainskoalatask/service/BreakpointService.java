package org.example.jetbrainskoalatask.service;

import com.intellij.xdebugger.breakpoints.XBreakpoint;

public interface BreakpointService {

    /**
     * This method loads all breakpoints in the window
     */
    void loadAllBreakpointsToWindow();

    /**
     * This method adds a breakpoint to the window
     * @param breakpoint the breakpoint to be added
     */
    void addBreakpointToWindow(XBreakpoint breakpoint);

    /**
     * This method removes a breakpoint from the window
     * @param breakpoint the breakpoint to be removed
     */
    void removeBreakpointFromWindow(XBreakpoint breakpoint);

    /**
     * This method updates breakpoint from the window
     * @param breakpoint the breakpoint to be updated
     */
    void updateBreakpoint(XBreakpoint breakpoint);


}
