package com.lotus.jewel.sample.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MySort {

	public static void main(String[] args) {
		
		Set<PositionVo> positionSet = new HashSet<PositionVo>();
		positionSet.add(new PositionVo(100));
		positionSet.add(new PositionVo(110));
		positionSet.add(new PositionVo(120));
		positionSet.add(new PositionVo(130));
		positionSet.add(new PositionVo(190));
		positionSet.add(new PositionVo(180));
		positionSet.add(new PositionVo(120));
		positionSet.add(new PositionVo(100));
		
		List<PositionVo> positionList = new ArrayList<PositionVo>(positionSet);
		
		System.out.println("sort order");
		Collections.sort(positionList);
		
		for (PositionVo position : positionList) {
			System.out.println(position.toString() + " hashCode : " + position.hashCode());
		}
		
		System.out.println("sort reverse");
		Collections.sort(positionList, Collections.reverseOrder());
		
		for (PositionVo position : positionList) {
			System.out.println(position.toString() + " hashCode : " + position.hashCode());
		}
	}
	
	public static class PositionVo implements Comparable<PositionVo>{

		private Integer positionId;
		
		private Integer positionX;
		
		private Integer positionY;
		
		private String description;
		
		public PositionVo(Integer positionId) {
			this.positionId = positionId;
		}
		
		public Integer getPositionId() {
			return positionId;
		}

		public void setPositionId(Integer positionId) {
			this.positionId = positionId;
		}

		public Integer getPositionX() {
			return positionX;
		}

		public void setPositionX(Integer positionX) {
			this.positionX = positionX;
		}

		public Integer getPositionY() {
			return positionY;
		}

		public void setPositionY(Integer positionY) {
			this.positionY = positionY;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public int compareTo(PositionVo other) {
			if(this == other) {
				return 0;
			}
			
			if(positionId != null && other.positionId != null) {
				if(!positionId.equals(other.positionId)) {
					return positionId.compareTo(other.positionId);
				}
			}
			
			return 0;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof PositionVo) {
				if (positionId == ((PositionVo) o).getPositionId()) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			if( positionId == null ) {
				return 0;
			}
			return positionId;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("PositionVo [positionId=");
			builder.append(positionId);
			builder.append(", positionX=");
			builder.append(positionX);
			builder.append(", positionY=");
			builder.append(positionY);
			builder.append(", description=");
			builder.append(description);
			builder.append("]");
			return builder.toString();
		}
		
	}
}
