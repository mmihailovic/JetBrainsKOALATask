package org.example.jetbrainskoalatask.listener;

import com.intellij.xdebugger.breakpoints.XBreakpoint;
import com.intellij.xdebugger.breakpoints.XBreakpointListener;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BreakpointListener implements XBreakpointListener {
    private Consumer<XBreakpoint> breakpointAddedFunction;
    private Consumer<XBreakpoint> breakpointRemovedFunction;
    private Consumer<XBreakpoint> breakpointChangedFunction;

    public BreakpointListener(Consumer<XBreakpoint> breakpointAddedFunction, Consumer<XBreakpoint> breakpointRemovedFunction, Consumer<XBreakpoint> breakpointChangedFunction) {
        this.breakpointAddedFunction = breakpointAddedFunction;
        this.breakpointRemovedFunction = breakpointRemovedFunction;
        this.breakpointChangedFunction = breakpointChangedFunction;
    }

    @Override
    public void breakpointRemoved(@NotNull XBreakpoint breakpoint) {
        XBreakpointListener.super.breakpointRemoved(breakpoint);
        breakpointRemovedFunction.accept(breakpoint);
    }

    @Override
    public void breakpointAdded(@NotNull XBreakpoint breakpoint) {
        XBreakpointListener.super.breakpointAdded(breakpoint);
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(100);
                breakpointAddedFunction.accept(breakpoint);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();
    }

    @Override
    public void breakpointChanged(@NotNull XBreakpoint breakpoint) {
        XBreakpointListener.super.breakpointChanged(breakpoint);
        breakpointChangedFunction.accept(breakpoint);
    }
}
