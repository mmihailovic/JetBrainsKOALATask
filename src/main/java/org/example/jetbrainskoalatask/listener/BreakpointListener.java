package org.example.jetbrainskoalatask.listener;

import com.intellij.xdebugger.breakpoints.XBreakpoint;
import com.intellij.xdebugger.breakpoints.XBreakpointListener;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BreakpointListener implements XBreakpointListener {
    private Consumer<XBreakpoint> breakpointAddedFunction;
    private Consumer<XBreakpoint> breakpointRemovedFunction;
    private Consumer<XBreakpoint> breakpointChangedFunction;

    public BreakpointListener(Consumer<XBreakpoint> breakpointAddedFunction, Consumer<XBreakpoint> breakpointRemovedFunction,
                              Consumer<XBreakpoint> breakpointChangedFunction) {
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

        /// Reason for executing this method in a new thread and added
        /// a Thread.sleep() is that additional attributes for breakpoint
        /// like field name, method name, exception name are loading lazily
        /// and there is a risk that they won't be available when breakpointAdded
        /// method is called. I am aware that using threads and Thread.sleep() isn't
        /// the best approach. I wanted to extend the task to display additional
        /// information for each breakpoint. The file, which is required,
        /// is loaded immediately, and there wouldn't be any issue with lazy
        /// loading. There are several ways to find out which file a breakpoint is
        /// located in, such as using breakpoint.getSourcePosition().getFile().

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
