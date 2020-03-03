# EMS Project
* Email Management System V1
* 20200121


### JPA-Hibernate, MySQL 연동 프로젝트


<bean  class="org.apache.commons.dbcp2.BasicDataSource" >
		<property name="driverClassName"/ value="com.mysql.cj.jdbc.Driver">
		<property name="url" value="jdbc:mysql:thin://127.0.0.1:3306/emsDB?serverTimezone=Asia/Seoul&useSSL=false"/>
		<property name="username" value="ems"/>
		<property name="password" value="ems"/>
</bean>






* driverClassName: com.mysql.cj.jdbc.Driver를 사용
* url: 기본 연결 주소에 쿼리값을 추가하는데 serverTimezone=Asia/Seoul로 설정
* 5.x에서는 SSL 연결을 하지 않는 &useSSL=false 옵션을 사용해야 하며, 8.x에서는 오류가 발생하니 추가하지 않음