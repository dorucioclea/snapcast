package de.badaix.snapcast.control;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by johannes on 06.01.16.
 */
public class Volume {
    private boolean muted;
    private int percent;

    public Volume(JSONObject json) {
        fromJson(json);
    }

    public Volume(int percent, boolean muted) {
        this.percent = percent;
        this.muted = muted;
    }

    public void fromJson(JSONObject json) {
        try {
            percent = json.getInt("percent");
            muted = json.getBoolean("muted");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getPercent() {
        return percent;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Volume{" +
                "muted=" + muted +
                ", percent=" + percent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volume volume = (Volume) o;

        if (muted != volume.muted) return false;
        return percent == volume.percent;

    }

    @Override
    public int hashCode() {
        int result = (muted ? 1 : 0);
        result = 31 * result + percent;
        return result;
    }
}