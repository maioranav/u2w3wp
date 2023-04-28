package org.vm93.u2w3wp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sonda {
	
	private Long id;
	private Double lat;
	private Double lon;
	private Integer smokeLevel;

}
