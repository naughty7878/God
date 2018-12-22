package com.god.api.baidu.map.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.god.api.baidu.map.config.MapBaiduConfig;
import com.god.api.baidu.map.domain.MapBaiduDrivingResult;
import com.god.api.baidu.map.domain.MapBaiduGeocodeResult;
import com.god.api.baidu.map.domain.MapBaiduLngLat;
import com.god.api.baidu.map.domain.MapBaiduResponse;
import com.god.api.baidu.map.service.IMapBaiduService;
import com.god.api.baidu.map.util.MapConnBaiduUtil;



/**
 * 百度地图服务类
 * @author H__D
 * @date 2018-09-09 23:51:23
 *
 */
public class MapBaiduServiceImpl implements IMapBaiduService{
	
	private final String KEY = "ak";
	
	private final String STATUS_OK = "ok";
	
	private final String ADDRESS = "address";
	
	private final String OUT_PUT = "output";
	
	private final String ORIGIN = "origin";
	
	private final String DESTINATION = "destination";
	
	private final String QUESTION_MARK = "?";

	private final String UTF8 = "utf-8"; 
	
	// json 解析类
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public MapBaiduResponse<MapBaiduGeocodeResult> getGeocode(String address)
	{
	
		Map<String, String> requestMap = new HashMap<String, String>();
		if(address != null && address.trim().length() > 42) {
			address = address.substring(0, 42);
		}
		
		
		try {
			requestMap.put(ADDRESS, URLEncoder.encode(address, UTF8));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		requestMap.put(OUT_PUT, MapBaiduConfig.JSON);
		requestMap.put(KEY, MapBaiduConfig.KEY);
		String resultStr = MapConnBaiduUtil.getMethod(MapBaiduConfig.MAP_GEOCODER_URL + QUESTION_MARK + MapConnBaiduUtil.convertStringParamter(requestMap));
		
		MapBaiduResponse<MapBaiduGeocodeResult> mapResponse = null;
		try {
			// 设置在反序列化时忽略在JSON字符串中存在，而在Java中不存在的属性
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapResponse = objectMapper.readValue(resultStr,  new TypeReference<MapBaiduResponse<MapBaiduGeocodeResult>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapResponse;
	}
	
	
	@Override
	public MapBaiduResponse<MapBaiduDrivingResult> getDriving(double originLng, double originLat, double destinationLng, double destinationLat  ){
		
		MapBaiduLngLat mapLonLat1 = new MapBaiduLngLat();
		mapLonLat1.setLng(originLng);
		mapLonLat1.setLat(originLat);
		
		MapBaiduLngLat mapLonLat2 = new MapBaiduLngLat();
		mapLonLat2.setLng(destinationLng);
		mapLonLat2.setLat(destinationLat);
		
		return getDriving(mapLonLat1, mapLonLat2);
	}
	
	@Override
	public MapBaiduResponse<MapBaiduDrivingResult> getDriving(MapBaiduLngLat origin, MapBaiduLngLat destination ){
		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put(ORIGIN, new BigDecimal(origin.getLat()).setScale(6,BigDecimal.ROUND_HALF_UP) + "," + new BigDecimal(origin.getLng()).setScale(6,BigDecimal.ROUND_HALF_UP));
		requestMap.put(DESTINATION, new BigDecimal(destination.getLat()).setScale(6,BigDecimal.ROUND_HALF_UP) + "," + new BigDecimal(destination.getLng()).setScale(6,BigDecimal.ROUND_HALF_UP));
		requestMap.put(OUT_PUT, MapBaiduConfig.JSON);
		requestMap.put(KEY, MapBaiduConfig.KEY);
		
		//http://api.map.baidu.com/direction/v2/driving?origin=40.01116,116.339303&destination=39.936404,116.452562&ak=您的AK
		String resultStr = MapConnBaiduUtil.getMethod(MapBaiduConfig.MAP_DRIVING_URL + QUESTION_MARK + MapConnBaiduUtil.convertStringParamter(requestMap));
		
		MapBaiduResponse<MapBaiduDrivingResult> mapResponse = null;
		try {
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapResponse = objectMapper.readValue(resultStr,  new TypeReference<MapBaiduResponse<MapBaiduDrivingResult>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapResponse;
	}
	
	public static void main(String[] args) {
		// origin=40.01116,116.339303&destination=39.936404,116.452562
		
		MapBaiduServiceImpl mapService = new MapBaiduServiceImpl();
		System.out.println(mapService.getGeocode("深圳大学城"));
		
		
		//MapLngLat [lng=113.83109606852621, lat=22.677660583608028]
		//MapLngLat [lng=113.98054983851213, lat=22.59488113651925]
		MapBaiduLngLat mapLonLat1 = new MapBaiduLngLat();
		mapLonLat1.setLng(116.339303);
		mapLonLat1.setLat(40.01116);
		
		MapBaiduLngLat mapLonLat2 = new MapBaiduLngLat();
		mapLonLat2.setLng(116.452562);
		mapLonLat2.setLat(39.936404);
		
		System.out.println("==============");
		MapBaiduResponse<MapBaiduDrivingResult> driving = mapService.getDriving(mapLonLat1, mapLonLat2);
		System.out.println(driving);
		
	}
}
