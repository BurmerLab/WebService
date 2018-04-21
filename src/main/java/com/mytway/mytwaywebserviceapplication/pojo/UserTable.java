package com.mytway.mytwaywebserviceapplication.pojo;

public class UserTable {
    // Labels table name
    public static final String TABLE = "User";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_USER_NAME = "user_name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String TYPE_WORK = "type_work";
    public static final String LENGTH_TIME_WORK = "length_time_work";
    public static final String START_STANDARD_TIME = "start_standard_time";
    public static final String WORK_PLACE_LATITUDE = "work_place_latitude";
    public static final String WORK_PLACE_LONGITUDE = "work_place_longitude";
    public static final String HOME_PLACE_LATITUDE = "home_place_latitude";
    public static final String HOME_PLACE_LONGITUDE = "home_place_longitude";
    public static final String WORK_WEEK = "work_week";
    public static final String WAY_DISTANCE = "way_distance";
    public static final String WAY_DURATION = "way_duration";

    // property help us to keep data
    public int userId;
    public String userName;
    public String email;
    public String password;
    public int typeWork;
    public String lengthTimeWork;
    public String startStandardTimeWork;
    public double workPlaceLatitude;
    public double workPlaceLongitude;
    public double homePlaceLatitude;
    public double homePlaceLongitude;
    public String workWeek;
    public String wayDistance;
    public String wayDuration;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTypeWork() {
        return typeWork;
    }

    public void setTypeWork(int typeWork) {
        this.typeWork = typeWork;
    }

    public String getLengthTimeWork() {
        return lengthTimeWork;
    }

    public void setLengthTimeWork(String lengthTimeWork) {
        this.lengthTimeWork = lengthTimeWork;
    }

    public String getStartStandardTimeWork() {
        return startStandardTimeWork;
    }

    public void setStartStandardTimeWork(String startStandardTimeWork) {
        this.startStandardTimeWork = startStandardTimeWork;
    }

    public double getWorkPlaceLatitude() {
        return workPlaceLatitude;
    }

    public void setWorkPlaceLatitude(double workPlaceLatitude) {
        this.workPlaceLatitude = workPlaceLatitude;
    }

    public double getWorkPlaceLongitude() {
        return workPlaceLongitude;
    }

    public void setWorkPlaceLongitude(double workPlaceLongitude) {
        this.workPlaceLongitude = workPlaceLongitude;
    }

    public double getHomePlaceLatitude() {
        return homePlaceLatitude;
    }

    public void setHomePlaceLatitude(double homePlaceLatitude) {
        this.homePlaceLatitude = homePlaceLatitude;
    }

    public double getHomePlaceLongitude() {
        return homePlaceLongitude;
    }

    public void setHomePlaceLongitude(double homePlaceLongitude) {
        this.homePlaceLongitude = homePlaceLongitude;
    }

    public String getWorkWeek() {
        return workWeek;
    }

    public void setWorkWeek(String workWeek) {
        this.workWeek = workWeek;
    }

    public String getWayDistance() {
        return wayDistance;
    }

    public void setWayDistance(String wayDistance) {
        this.wayDistance = wayDistance;
    }

    public String getWayDuration() {
        return wayDuration;
    }

    public void setWayDuration(String wayDuration) {
        this.wayDuration = wayDuration;
    }


    @Override
    public String toString() {
        return "UserTable{" + "userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password + ", typeWork=" + typeWork + ", lengthTimeWork=" + lengthTimeWork + ", startStandardTimeWork=" + startStandardTimeWork + ", workPlaceLatitude=" + workPlaceLatitude + ", workPlaceLongitude=" + workPlaceLongitude + ", homePlaceLatitude=" + homePlaceLatitude + ", homePlaceLongitude=" + homePlaceLongitude + ", workWeek=" + workWeek + ", way_distance=" + wayDistance + ", way_duration=" + wayDuration + '}';
    }

}
