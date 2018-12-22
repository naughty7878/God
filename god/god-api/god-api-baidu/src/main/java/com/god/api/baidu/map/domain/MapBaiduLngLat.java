package com.god.api.baidu.map.domain;

import java.io.Serializable;

/**
 * 经纬度对象
 * @author chenheng
 * @date 2018-09-07 15:49:19
 *
 */
public class MapBaiduLngLat  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//经度
	private Double lng;
	
	//纬度
	private Double lat;


	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MapBaiduLngLat [lng=" + lng + ", lat=" + lat + "]";
	}

		
	
}
