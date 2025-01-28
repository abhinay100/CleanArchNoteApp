package com.abhinay.cleanarchitecturenoteapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
- * Created by Abhinay on 28/01/25.
- *
- *
+ * NoteApp is the main application class for the Notes application.
+ * It extends the Android Application class and serves as the entry point for the application.
+ * It is annotated with @HiltAndroidApp, which triggers Hilt's code generation.
+ * Hilt will generate an application-level dependency container that is the parent container
+ * of the app.
+ * This container will provide dependencies to other components that are in the application.
+ *
+ * @see dagger.hilt.android.HiltAndroidApp
 */
@HiltAndroidApp
class NoteApp: Application()