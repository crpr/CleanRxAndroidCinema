
############### RETROLAMBDA #####################
-dontwarn java.lang.invoke.*

############### RETROFIT ########################
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

############### BUTTERKNIFE #####################
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

########################################################
# Android Support

-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep class android.support.v7.app.** { *; }
-keep interface android.support.v7.app.** { *; }
-keep class android.support.v7.widget.** { *; }

-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

########################################################
# Class Models
-keep class com.crpr.androidcinema.domain.models.** {*;}
-keep class com.crpr.androidcinema.data.api.models.** {*;}
-keep class com.crpr.androidcinema.data.api.responses.** {*;}

########################################################