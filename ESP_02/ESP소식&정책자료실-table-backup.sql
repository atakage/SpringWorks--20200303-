--------------------------------------------------------
--  파일이 생성됨 - 월요일-12월-23-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TBL_NEWS
--------------------------------------------------------

  CREATE TABLE "TBL_NEWS" 
   (	"N_SEQ" NUMBER, 
	"N_TITLE" NVARCHAR2(125), 
	"N_CONTENT" NVARCHAR2(1000), 
	"N_WRITER" NVARCHAR2(25), 
	"N_DATE" NVARCHAR2(10), 
	"N_FILE" NVARCHAR2(255)
   ) ;
--------------------------------------------------------
--  DDL for Table TBL_POLICYDATA
--------------------------------------------------------

  CREATE TABLE "TBL_POLICYDATA" 
   (	"D_SEQ" NUMBER, 
	"D_TITLE" NVARCHAR2(125), 
	"D_CONTENT" NVARCHAR2(1000), 
	"D_WRITER" NVARCHAR2(25), 
	"D_DATE" NVARCHAR2(10), 
	"D_FILE" NVARCHAR2(255)
   ) ;
REM INSERTING into TBL_NEWS
SET DEFINE OFF;
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (1,'취업지원정보모음 사이트 오픈','취업지원정보모음 온라인 사이트가 새로 오픈하였습니다. 

감사합니다.','관리자','2019.12.13',null);
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (2,'2020년 기준중위소득을 알려드립니다.','안녕하세요. 

2020년부터 적용될 기준중위소득 공지합니다.','관리자','2019.12.13',null);
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (21,'청년구직활동지원금 서식 모음','안녕하세요!



청년구직활동지원금 지원시 필요한 서식 모음 탑재합니다. 감사합니다.','관리자','2019.12.21',null);
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (22,'[보도자료] 청년구직활동지원금 하반기 지원 강화','안녕하세요. 

고용부에서 금일 발표된 청년구직활동지원금 자격 요건 완화 관련 보도자료 공유드립니다.

<핵심 요약>
2019년 8월부터는 청년구직활동지원금* 지원 대상을 선정할 때 우선순위를 적용하지 않고 요건**만 충족하면 지원금을 지원하게 된다.
  * 청년들이 스스로 취업을 준비하는 데 필요한 비용(월 50만 원x6개월)과 취업지원 서비스
     (예비 교육 수강, 1:1 취업 상담 등)를 함께 지원하는 제도
** ▴ 만 18~34세, ▴ 졸업·중퇴 후 2년 이내, ▴기준중위소득 120% 이하인 미취업 청년
      (단, 자치단체의 청년수당 등 유사 사업 종료 후 6개월 경과 필수)


감사합니다.','관리자','2019.12.21',null);
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (23,'[보도자료] 청년 희망사다리 강화방안','안녕하세요. 기획재정부에서 주재하는 ｢제20차 경제활력대책회의 겸 제19차 경제관계장관회의｣에서 청년 희망사다리 강화방안 등이 논의되었습니다.



｢청년 희망사다리 강화방안｣은 청년층이 겪는 여러 가지 어려움을 완화하기 위해 마련된 대책입니다.



지난 7.3일 발표한 ’19년 하반기 경제정책방향에 청년희망사다리 대책의 주요 골자를 발표하였으며, 안건으로 ➊청년 일자리, ➋청년 주거, ➌청년 교육, ➍취약청년 자립지원 분야의 추가적인 과제들을 포함하고 있다고 합니다.



자세한 내용을 첨부파일에서 확인해 보세요!','관리자','2019.12.21',null);
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (24,'[자료] 청년정책 매뉴얼(19.6.18 수정)','안녕하세요. 

정책을 알면 세상이 보인다! 청년정책 매뉴얼 자료를 탑재합니다.

감사합니다.

<수정 사항>
19.6.18 13쪽 청년친화강소기업 설명 수정, 31쪽 홈페이지 주소 수정','관리자','2019.12.21',null);
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (25,'2019 기능한국인','고용노동부와 한국산업인력공단에서 발간한 2019년 기능한국인 자료를 탑재합니다.','관리자','2019.12.21',null);
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (26,'청년취업체크카드 영업점 매칭리스트','안녕하세요. 온라인청년센터 관리자입니다.



청년취업체크카드 영업점 매칭리스트를 탑재합니다.



감사합니다.','관리자','2019.12.21',null);
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (27,'[구활금] 구직활동보고서 심사 기준','안녕하세요.



청년구직활동지원금 보고서 심사 기준을 탑재합니다.



감사합니다.','관리자','2019.12.21',null);
Insert into TBL_NEWS (N_SEQ,N_TITLE,N_CONTENT,N_WRITER,N_DATE,N_FILE) values (28,'[구활금] 근로 사실 신고하는 법 자세히 알아보기(19.7.17 수정)','청년 여러분, 안녕하세요!

 

구직활동보고서를 작성할 때의 근로 사실 신고에 대해 자세히 알려드리겠습니다.

근로 사실 신고는 주 20시간 이하로 근로하더라도, 불규칙적으로 근로하더라도 반드시 필요하다는 점 꼭 숙지해 주시기 바라요!

 

1. 주 20시간 이하로 근로하는 경우

주 20시간 초과 근로의 경우와 마찬가지로, 주 20시간 이하로 근로할 때에도 근로 사실을 신고해 주셔야 해요. 증빙서류 역시 주 20시간 초과 근로와 같이 근로계약서를 첨부하여 신고하면 된답니다.

 

2. 일용직, 단기 일자리 등 불규칙적으로 근로하는 경우

일용직이나 단기 일자리로 일하는 경우에도 근로 사실 신고는 필요합니다. 첫 보고서의 경우 지원금 신청일~당월 20일, 두 번째 보고서부터는 전월 21일~당월 20일 동안의 근로사실을 모두 신고해주세요(수정).

* 근로계약서를 모두 받기 어렵거나, 보고서 제출 기한 내에 받기 어려운 경우 아래 ‘3. 근로사실신고서 활용하기’를 참고해주세요.

 

3. 근로사실신고서 활용하기

근로 사실 신고를 위한 증빙서류는 근로계약서가 원칙이지만, 근로계약서 발급에 시간이 걸리는 등의 사정으로 근로계약서로 근로 사실을 신고하기 어려운 경우에는 근로사실신고서(첨부1)을 활용해 근로 사실을 신고할 수 있습니다. 근로사실신고서를 작성하실 때에는 예시 작성 파일(첨부2)을 참고하셔서 작성해 주세요.','관리자','2019.12.21',null);
REM INSERTING into TBL_POLICYDATA
SET DEFINE OFF;
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (1,'서울특별시 기초자치단체 정책종합자료입니다.','서울특별시 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (2,'인천광역시 기초자치단체 정책종합자료입니다.','인천광역시 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (3,'부산광역시 기초자치단체 정책종합자료입니다.','부산광역시 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (4,'광주광역시 기초자치단체 정책종합자료입니다.','광주광역시 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (5,'대전광역시 기초자치단체 정책종합자료입니다.','대전광역시 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (6,'대구광역시 기초자치단체 정책종합자료입니다.','대구광역시 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (7,'울산광역시 기초자치단체 정책종합자료입니다.','울산광역시 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (8,'경기도 기초자치단체 정책종합자료입니다.','경기도 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (9,'강원도 기초자치단체 정책종합자료입니다.','강원도 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (10,'충청북도 기초자치단체 정책종합자료입니다.','충청북도 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (11,'충청남도 기초자치단체 정책종합자료입니다.','충청남도 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (12,'전라북도 기초자치단체 정책종합자료입니다.','전라북도 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (13,'전라남도 기초자치단체 정책종합자료입니다.','전라남도 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (14,'경상북도 기초자치단체 정책종합자료입니다.','경상북도 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (15,'경상남도 기초자치단체 정책종합자료입니다.','경상남도 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
Insert into TBL_POLICYDATA (D_SEQ,D_TITLE,D_CONTENT,D_WRITER,D_DATE,D_FILE) values (16,'제주특별자치도 기초자치단체 정책종합자료입니다.','제주특별자치도 기초자치단체 정책종합자료입니다.','관리자','2019.12.13',null);
--------------------------------------------------------
--  DDL for Index SYS_C007087
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007087" ON "TBL_NEWS" ("N_SEQ") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007065
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007065" ON "TBL_POLICYDATA" ("D_SEQ") 
  ;
--------------------------------------------------------
--  Constraints for Table TBL_NEWS
--------------------------------------------------------

  ALTER TABLE "TBL_NEWS" ADD PRIMARY KEY ("N_SEQ") ENABLE;
  ALTER TABLE "TBL_NEWS" MODIFY ("N_DATE" NOT NULL ENABLE);
  ALTER TABLE "TBL_NEWS" MODIFY ("N_WRITER" NOT NULL ENABLE);
  ALTER TABLE "TBL_NEWS" MODIFY ("N_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "TBL_NEWS" MODIFY ("N_TITLE" NOT NULL ENABLE);
  ALTER TABLE "TBL_NEWS" MODIFY ("N_SEQ" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TBL_POLICYDATA
--------------------------------------------------------

  ALTER TABLE "TBL_POLICYDATA" ADD PRIMARY KEY ("D_SEQ") ENABLE;
  ALTER TABLE "TBL_POLICYDATA" MODIFY ("D_DATE" NOT NULL ENABLE);
  ALTER TABLE "TBL_POLICYDATA" MODIFY ("D_WRITER" NOT NULL ENABLE);
  ALTER TABLE "TBL_POLICYDATA" MODIFY ("D_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "TBL_POLICYDATA" MODIFY ("D_TITLE" NOT NULL ENABLE);
  ALTER TABLE "TBL_POLICYDATA" MODIFY ("D_SEQ" NOT NULL ENABLE);
