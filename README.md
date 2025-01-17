# List of tasks:
Implement a logging system that will record events in the logs.txt file (log events: servlet initialization, request processing, servlet destruction).
Develop a new servlet that will handle requests at /logs. This servlet should read the contents of the logs.txt file and output it to the browser in a readable format.
Create servlets for the application from homework 22. Servlets should return a page about you or your goals. (Make sure logging is configured in the servlets.)
It is necessary to define configuration parameters in the web.xml file. Parameters: appName, appVersion, developerName, supportEmail. Create a servlet that will extract these parameters from web.xml and output them to the browser when switching to /settings.
Create a servlet that will print the number of visits to this page when switching to /count. Use the Sessions mechanism when working.
Add the ability to reset the visitor counter. This should be implemented via a separate URL (/reset) that resets the number of visits to the /count page.
