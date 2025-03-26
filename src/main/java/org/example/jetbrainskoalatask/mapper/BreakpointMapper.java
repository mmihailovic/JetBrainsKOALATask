package org.example.jetbrainskoalatask.mapper;

import org.example.jetbrainskoalatask.jcef.BreakpointDetails;
import com.intellij.xdebugger.breakpoints.XBreakpoint;
import org.codehaus.plexus.util.StringUtils;

public class BreakpointMapper {

    public BreakpointDetails breakpointToBreakpointDetails(XBreakpoint breakpoint) {
        String identifier = breakpoint.getSourcePosition() + " " + breakpoint.getType().getShortText(breakpoint);
        String type = StringUtils.capitaliseAllWords(breakpoint.getType().toString().replace('-', ' '));
        String details = breakpoint.getType().getShortText(breakpoint);
        boolean isEnabled = breakpoint.isEnabled();

        return new BreakpointDetails(identifier, type, details, isEnabled);
    }
}
