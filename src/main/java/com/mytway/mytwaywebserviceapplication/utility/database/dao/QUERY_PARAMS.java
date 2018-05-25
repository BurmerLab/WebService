package com.mytway.mytwaywebserviceapplication.utility.database.dao;

public class QUERY_PARAMS {
  
  //main
  public final static String AND = " AND ";
  public final static String WHERE = " WHERE ";
  public final static String OR = " OR ";
  public final static String LIMIT = " LIMIT ";
  
  //points
//  public final static String SELECT_ALL_RECORDS_FROM_POINT = "SELECT osmid, latitude, longitude, degree FROM points";
//  public final static String SELECT_RECORD_FROM_POINT_BY_OSM_ID = "SELECT osmid, latitude, longitude, degree FROM points WHERE osmid=";
//
//  //segments
//  public final static String SELECT_ALL_RECORDS_FROM_SEGMENTS = "SELECT ids, osm_way_id, osm_start_node_id, osm_end_node_id,  length_km, max_speed_km_h, directed, start_azimuth, end_azimuth FROM segments";
//  public final static String SELECT_ALL_RECORDS_FROM_SEGMENTS_WITH_LIMIT = "SELECT ids, osm_way_id, osm_start_node_id, osm_end_node_id,  length_km, max_speed_km_h, directed, start_azimuth, end_azimuth FROM segments";
//  public final static String SELECT_RECORD_FROM_SEGMENTS_BY_IDS = "SELECT ids, osm_way_id, osm_start_node_id, osm_end_node_id, length_km, max_speed_km_h, directed, start_azimuth, end_azimuth, passing_time FROM segments WHERE ids=";
public final static String UPDATE_USER_TABLE_TO_EXTERNAL_DATABASE = "UPDATE t_user_repository SET type_work=?, length_time_work=?, start_standard_time_work=?, work_place_latitude=?,"
        + " work_place_longitude=?, home_place_latitude=?, home_place_longitude=?, work_week=?, way_distance=?, way_duration=? WHERE user_name=? and password=? ";

public final static String INSERT_USER_TABLE_TO_EXTERNAL_DATABASE = "INSERT INTO t_user_repository (user_name, create_date, email, password, type_work, length_time_work, start_standard_time_work, work_place_latitude, "
                                                                    + "work_place_longitude, home_place_latitude, home_place_longitude, work_week, way_distance, way_duration)" 
                                                                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

public final static String IS_USER_NAME_EXIST_IN_DATA_BASE = "SELECT * FROM t_user_repository WHERE user_name = ?";

public final static String IS_USER_NAME_AND_PASSWORD_IS_CORRECT_IN_DATA_BASE = "SELECT * FROM t_user_repository WHERE user_name = ? AND password = ?";
public final static String GET_USER_FROM_DATA_BASE = "SELECT * FROM t_user_repository WHERE user_name = ? AND password = ?";
public final static String GET_USER_ID_FROM_DATA_BASE = "SELECT id FROM t_user_repository WHERE user_name = ? AND password = ?";





}
