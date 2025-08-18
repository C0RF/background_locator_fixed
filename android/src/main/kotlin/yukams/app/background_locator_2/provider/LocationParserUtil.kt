package yukams.app.background_locator_2.provider

import android.location.Location
import com.google.android.gms.location.LocationResult

object LocationParserUtil {

    fun getLocationMapFromLocation(location: Location): HashMap<Any, Any?> {
        val map = HashMap<Any, Any?>()
        map["latitude"] = location.latitude
        map["longitude"] = location.longitude
        map["accuracy"] = location.accuracy
        map["altitude"] = location.altitude
        map["bearing"] = location.bearing
        map["speed"] = location.speed
        map["time"] = location.time
        map["provider"] = location.provider
        map["isMocked"] = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            location.isFromMockProvider
        } else {
            false
        }
        map["speedAccuracy"] = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            location.speedAccuracyMetersPerSecond
        } else {
            0f
        }
        return map
    }

    fun getLocationMapFromLocation(locationResult: LocationResult?): HashMap<Any, Any?>? {
        val location = locationResult?.lastLocation ?: return null
        val map = HashMap<Any, Any?>()
        map["latitude"] = location.latitude
        map["longitude"] = location.longitude
        map["accuracy"] = location.accuracy
        map["altitude"] = location.altitude
        map["bearing"] = location.bearing
        map["speed"] = location.speed
        map["time"] = location.time
        map["provider"] = location.provider
        map["isMocked"] = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            location.isFromMockProvider
        } else {
            false
        }
        map["speedAccuracy"] = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            location.speedAccuracyMetersPerSecond
        } else {
            0f
        }
        return map
    }
}
