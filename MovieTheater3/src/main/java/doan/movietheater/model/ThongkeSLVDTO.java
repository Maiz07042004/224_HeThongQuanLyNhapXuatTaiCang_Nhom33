/*	
*	(C) Copyright 2021 Fresher56. All Rights Reserved
*
* @author tuand
* @date Apr 17, 2021
* @ version 1.0
*/

package doan.movietheater.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ThongkeSLVDTO {
	private String movieID;
	private String movieName;
	private int slV;
	private int month;
	private int doanhThu;
}
