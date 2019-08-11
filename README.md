# TestingWithUiAutomator

## WHAT IS UI AUTOMATOR?

UI Automator is a UI testing framework suitable for cross app functional UI testing across system and installed apps
But this framework requires Android 4.3 (API level 18) or higher
The UI Automator testing frameworl provides a set of APIs to build UI tests that perform interactions on user apps and system apps.

The key features of the UI automator testing framework include the following:
* A viewer to inspect layout hierarchy. 
* An API to retrieve state information and perform operations on the target device 
* APIs that support cross-app UI testing.
## Accessing device state
The UI Automator testing framework provides a UiDevice class to access and proform operations on the device which the target app is running. You can call its methods to access device proprties such as current orientation or display size.

* Change the device rotation.
* Press the Back, Home, or Menu Button.
* Open the notification shade.
* Take a screenshot 
## UI Automator APIs
The UI Automator APIs allow you to write robust tests without needing to know about what thing inside the app that you are targeting. You can use these APIs  to capture and manipulate UI components across multiple apps:
* UiCollection: Enumerates a containe's UI elements for the purpose of counting or targeting sub-elements by their /a visible text or content-description property.
* UiObject: Represents a Ui element that is visible on the device 
* UiScrollable: Provides support for searching for items in a scrollable UI container.
* UiSelector: Represents a query for one or more target UI elements on a device.
* Configurator: Allows you to set key parameters for running UI Automator tests.

## What is UiObject?
A UiObject is a representation of a view. A UiObject contains information to help it locate a matching view at runtime based on the UiSelector properties specified in its constructor.
Note: Once you create an instance of a UiObject, it can be reused foe different views that match the selector criteria.

## What is UiObject2?
A UiObject2 represents a UI element.Unlike UiObject. It is bound to a particular view instance and can become stale if the underlying view object is destroyed. As a result, it may be necessary to call findObject(BySelector) to obtaina new UiObject2 instance if the UI changes
## How to build and run UI Automator by command lines

Step 1: Build Debug
    
    ./gradlew assemble
    
Step 2: Build Debug Test
    
    ./gradlew assembleAndroidTest
    
Step 3: Install Debug on your device

    ./gradlew install <your-path-debug-file>
    Ex:adb install -r app/build/outputs/apk/debug/app-debug.apk
    
Step 4: Install Debug Test on your device

     ./gradlew install <your-path-debug-test-file>
     Ex:adb install -r app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk 

Step 5: Run on Device
    
    ./gradlew connectedTest

Note: You can use ./gradlew cAT to build debug and debug test












