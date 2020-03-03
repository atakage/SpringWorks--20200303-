package com.biz.ems.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name="tbl_ems", schema = "emsDB")
public class EmailVO {

	
	// 보내는 Email
	// 받는 Email
	// 보내는 사람
	// 받는 사람 이름
	// 받는 사람 이름
	// 제목
	// 내용
	// 작성일자
	// 작성시각
	
	
	/*
	 * 
	 * @Entity
	 * 	import javax.persistence.Entity
	 *  - JPA interface에 정의된 속성 지정
	 *  - 지금부터 이 클래스는 Entity이니 물리적 table과 연동되도록 준비
	 *  속성 중에 다음 항목이 지정되어 있으면(<prop key="hibernate.hbm2ddl.auto">create</prop>) Entity에 지정된 속성에 따라 table을 생성
	 *  create value : drop and create
	 *  지정하지 않으면 기본값 create
	 *  update로 지정하면 테이블이 없을 때 생성하고 만약 물리적 table과 구조가 다르면 오류가 발생
	 *  
	 *  만약 hib.hbm2ddl.auto 속성을 지정하지 않으면 기본값으로 create가 지정되어 기존의 테이블을  Drop한 후 재작성해 버림
	 *  none: 기본값, 아무일도 하지 않음
	 *  create-only: 테이블을 새로 생성
	 *  drop: 삭제
	 *  create: drop and create
	 *  create-drop: 시작할 때 drop and create를 하고 session이 끝나면 다시 drop
	 *  validate: 검증만
	 *  update: 스키마를 갱신, 없으면 만들고 있으면 validate 수행
	 * */
	
	
	
	
	/*
	 * 필드변수에 @Column, @Id 속성을 지정하면 테이블의 컬럼으로 생성
	 * @Id: PRIMARY KEY 컬럼으로 생성
	 * @GeneratedValue() 속성을 AUTO로 지정하면 auto increment를 수행하여 insert할 때 자동으로 값 채움
	 * 
	 * 
	 * 
	 * table의 컬럼명은 ems_seq로 지정하고
	 * vo 클래스의 필드변수는 emsSeq
	 * 
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ems_seq")
	private long ems_seq;
	
	/*
	 * @Column() 지정하는 속성
	 * nullable: not null 속성과 연관
	 * nullable = false : not null
	 * nullable = true : null(default)
	 * length: 컬럼의 길이, 지정하지 않으면 DB기본 값으로 255설정
	 * 컬럼을 생성할 때는 필드변수의 이름과 같이 설정
	 * 
	 */
	@Column(name="from_email", nullable = false, length = 125)
	private String from_email;
	
	
	/*
	 * @Column(name="to_email")
	 * 필드변수화 컬럼의 이름ㅇ르 달리 설정하고자 할 때
	 * 
	 */
	@Column(name="to_email", nullable = false, length = 125)
	private String to_email;
	
	
	
	/*
	 *  @Column(columnDefinition = "")
	 *  컬럼의 type을 DB의 고유한 type으로 강제 적용
	 */
	@Column(name="from_name", nullable = true, length = 125)
	@Nationalized // 문자열 컬럼 type을 locale type에 따라 변경
	private String from_name;
	
	@Column(nullable = false, length = 255)
	@Nationalized
	private String subject;
	
	@Column(nullable = true, length = 125)
	@Nationalized
	private String to_name;
	
	@Column(nullable = true, length = 1000)
	@Nationalized
	private String content;
	
	@Column(name="send_date" , nullable = true)
	private String send_date;
	
	@Column(name="send_time", nullable = true)
	private String send_time;
	
}
