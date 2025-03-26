This project is my solution for the task for project **KOALA - System of controlled experiments in IDE**.

### Description
This is IntelliJ IDEA plugin that adds a **"Breakpoints"** tool window that displays all breakpoints in project.
The **"Breakpoints"** tool window can be opened from the **View > Tool Windows** menu.
For each breakpoint, the type and its corresponding icon are displayed.

Additionally, for each breakpoint type, the plugin displays specific details:
- **Line Breakpoint:** The file and line number.
- **Method Breakpoint:** The file and method name.
- **Field Breakpoint:** The file and field name.
- **Exception Breakpoint:** The name of the exception.

The plugin also reacts to breakpoints changes, such as when a breakpoint is enabled or disabled, and updates the corresponding icon accordingly.

The plugin has a separate frontend module that handles the user interface and communicates with the frontend using JCEF.
Therefore, before running the plugin, it is necessary to start the frontend server by running **npm start** from the frontend module directory.

### Visual presentation
![tool window](https://github.com/user-attachments/assets/ebf32a6b-8e88-4a55-a269-42768608e041)

![breakpoints](https://github.com/user-attachments/assets/8510d638-7852-4f42-901f-57f6c4fad6cb)
