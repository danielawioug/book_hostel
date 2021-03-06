package lan.tmsystem.bookhostel.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hostel implements Parcelable {
    private String mName;
    private GeoPoint mLocation;
    private String userId;
    private String price;
    private List<String> rooms = new ArrayList<String>();
    private String numSingles;
    private String numDoubles;

    public Hostel() {
    }

    public Hostel(String name, String price, String numSingles, String numDoubles, GeoPoint location, String userId) {
        this.setName(name);
        this.setLocation(location);
        this.setUserId(userId);
        List<String> a = new ArrayList<>();
        a.add(numSingles);
        a.add(numDoubles);
        this.setRooms(a);
        this.setPrice(price);
        this.setNumSingles(numSingles);
        this.setNumDoubles(numDoubles);
    }

    protected Hostel(Parcel in) {
        mName = in.readString();
        userId = in.readString();
        price = in.readString();
        numSingles = in.readString();
        numDoubles = in.readString();
        in.readList(rooms, null);
    }

    public static final Creator<Hostel> CREATOR = new Creator<Hostel>() {
        @Override
        public Hostel createFromParcel(Parcel in) {
            return new Hostel(in);
        }

        @Override
        public Hostel[] newArray(int size) {
            return new Hostel[size];
        }
    };

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public GeoPoint getLocation() {
        return mLocation;
    }

    public void setLocation(GeoPoint location) {
        mLocation = location;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getRooms() {
        return rooms;
    }

    public void setRooms(List<String> rooms) {
        this.rooms = rooms;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumSingles() {
        return numSingles;
    }

    public void setNumSingles(String numSingles) {
        this.numSingles = numSingles;
    }

    public String getNumDoubles() {
        return numDoubles;
    }

    public void setNumDoubles(String numDoubles) {
        this.numDoubles = numDoubles;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(userId);
        dest.writeString(price);
        dest.writeString(numSingles);
        dest.writeString(numDoubles);
        dest.writeList(rooms);
    }
}

class HostelRoom {
    public HostelRoom() {
    }
}
