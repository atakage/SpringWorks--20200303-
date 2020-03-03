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



### naver 아이디로 로그인 구현
1. 네이버에게 login창을 보내달라고 요청
- 서버에서 state라는 특별한 key를 생성하고 그 값을 같이 보내야 함


2. 네이버는 login창을 다시 redirect 해주고
3. 네이버가 보내는 login창에 로그인을 수행하고 정상으로 로그인이 되면
4. OAuth20 규격의 token을 보내주는데 이 토큰을 이용해서 naver에 어떤 정보들을 요청할 수 있음