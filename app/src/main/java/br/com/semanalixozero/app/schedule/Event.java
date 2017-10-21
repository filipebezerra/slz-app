package br.com.semanalixozero.app.schedule;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Filipe Bezerra
 */
public class Event implements Parcelable {

    private String title;
    private String placeName;
    private String address;
    private Long startsAt;
    private Long endsAt;
    private String summary;
    private String details;

    public Event(
            String title,
            String placeName,
            String address,
            Long startsAt,
            Long endsAt,
            String summary,
            String details) {
        this.title = title;
        this.placeName = placeName;
        this.address = address;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.summary = summary;
        this.details = details;
    }

    Event(Parcel in) {
        title = in.readString();
        placeName = in.readString();
        address = in.readString();
        startsAt = in.readLong();
        endsAt = in.readLong();
        summary = in.readString();
        details = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getAddress() {
        return address;
    }

    public Long getStartsAt() {
        return startsAt;
    }

    public Long getEndsAt() {
        return endsAt;
    }

    public String getSummary() {
        return summary;
    }

    public String getDetails() {
        return details;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel out, int flags) {
        out.writeString(title);
        out.writeString(placeName);
        out.writeString(address);
        out.writeLong(startsAt);
        out.writeLong(endsAt);
        out.writeString(summary);
        out.writeString(details);
    }
}
