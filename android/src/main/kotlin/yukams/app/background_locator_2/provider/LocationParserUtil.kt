package yukams.app.background_locator_2.provider

import android.location.Location
import android.os.Build
import com.google.android.gms.location.LocationResult

class LocationParserUtil {
    companion object {

        fun getLocationMapFromLocation(location: Location): HashMap<Any, Any> {
            val speedAccuracy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) location.speedAccuracyMetersPerSecond else 0f
            val isMocked = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) location.isFromMockProvider else false

            return hashMapOf(
                "is_mocked" to isMocked,
                "latitude" to location.latitude,
                "longitude" to location.longitude,
                "accuracy" to location.accuracy,
                "altitude" to (location.altitude ?: 0.0), // افتراضي 0.0
                "speed" to location.speed,
                "speed_accuracy" to speedAccuracy,
                "heading" to location.bearing,
                "time" to location.time.toDouble(),
                "provider" to (location.provider ?: "unknown") // افتراضي unknown
            )
        }

        fun getLocationMapFromLocation(locationResult: LocationResult?): HashMap<Any, Any> {
            val location = locationResult?.lastLocation
            if (location == null) {
                // رجع خريطة افتراضية لتجنب null
                return hashMapOf(
                    "is_mocked" to false,
                    "latitude" to 0.0,
                    "longitude" to 0.0,
                    "accuracy" to 0f,
                    "altitude" to 0.0,
                    "speed" to 0f,
                    "speed_accuracy" to 0f,
                    "heading" to 0f,
                    "time" to 0.0,
                    "provider" to "unknown"
                )
            }

            val speedAccuracy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) location.speedAccuracyMetersPerSecond else 0f
            val isMocked = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) location.isFromMockProvider else false

            return hashMapOf(
                "is_mocked" to isMocked,
                "latitude" to location.latitude,
                "longitude" to location.longitude,
                "accuracy" to location.accuracy,
                "altitude" to (location.altitude ?: 0.0),
                "speed" to location.speed,
                "speed_accuracy" to speedAccuracy,
                "heading" to location.bearing,
                "time" to location.time.toDouble(),
                "provider" to (location.provider ?: "unknown")
            )
        }
    }
}
