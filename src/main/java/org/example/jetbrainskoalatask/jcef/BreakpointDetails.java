package org.example.jetbrainskoalatask.jcef;

public class BreakpointDetails {
    private String identifier;
    private String type;
    private String details;
    private boolean isBreakpointEnabled;

    public BreakpointDetails(String identifier, String type, String details, boolean isBreakpointEnabled) {
        this.identifier = identifier;
        this.type = type;
        this.details = details;
        this.isBreakpointEnabled = isBreakpointEnabled;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }

    public boolean isBreakpointEnabled() {
        return isBreakpointEnabled;
    }
}
