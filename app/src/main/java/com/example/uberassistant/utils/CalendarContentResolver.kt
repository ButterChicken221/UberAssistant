package com.example.uberassistant.utils

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.CalendarContract
import kotlin.collections.HashSet

class CalendarContentResolver(ctx: Context) {
    var contentResolver: ContentResolver = ctx.contentResolver
    fun getEvents(): Set<String> {
        val events: MutableSet<String> = HashSet()
        val startMillis: Long = System.currentTimeMillis()
        val endMillis: Long = System.currentTimeMillis() + 6*60*60*1000
        val builder: Uri.Builder = CalendarContract.Instances.CONTENT_URI.buildUpon()
        ContentUris.appendId(builder, startMillis)
        ContentUris.appendId(builder, endMillis)

        val cur: Cursor? = contentResolver.query(builder.build(), FIELDS, null, null, null)
        val PROJECTION_LOCATION_INDEX: Int = 0
        val PROJECTION_TITLE_INDEX: Int = 1
        try {
            cur?.let {
                while (it.moveToNext()) {
                    val title: String = cur.getString(PROJECTION_TITLE_INDEX)
                    val location: String = cur.getString(PROJECTION_LOCATION_INDEX)

                    if(location.isNotEmpty())
                        events.add(location)
                }
            }
        } catch (ex: AssertionError) {

        }
        return events
    }

    companion object {
        val FIELDS: Array<String> = arrayOf(
            CalendarContract.Instances.EVENT_LOCATION,
            CalendarContract.Instances.TITLE
        )
        val CALENDAR_URI: Uri = Uri.parse("content://com.android.calendar/calendars")
    }

}